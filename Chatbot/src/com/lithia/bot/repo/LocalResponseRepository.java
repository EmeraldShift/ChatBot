package com.lithia.bot.repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

import com.lithia.bot.ai.Message;

public class LocalResponseRepository extends ResponseRepository
{
	private File repoFile;
	private BufferedReader reader;
	private FileWriter writer;

	public LocalResponseRepository(String path)
	{
		repoFile = new File(path);
	}

	public void open() throws IOException
	{
		if (!repoFile.exists())
			repoFile.createNewFile();
		reader = new BufferedReader(new FileReader(repoFile));
		String line[], i, o;
		int t;
		while (reader.ready())
		{
			line = reader.readLine().split("\\|");
			i = line[0];
			o = line[1];
			t = Integer.parseInt(line[2]);

			addResponse(i, new Message(o).setTypeExact(t));
		}
	}
	
	public void close() throws IOException
	{
		save();
	}

	public void save() throws IOException
	{
		repoFile.delete();
		repoFile.createNewFile();
		writer = new FileWriter(repoFile);

		for (Entry<String, Message> entry : getResponseList())
		{
			writer.write(entry.getKey() +
					"|" + entry.getValue() +
					"|" + entry.getValue().getType() + "\n");
		}
		
		writer.flush();
	}
}
