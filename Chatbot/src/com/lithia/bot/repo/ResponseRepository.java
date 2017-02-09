package com.lithia.bot.repo;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map.Entry;

import com.lithia.bot.ai.Message;

public abstract class ResponseRepository
{
	private ArrayList<Entry<String, Message>> responses = new ArrayList<>();
	
	public abstract void open() throws IOException;
	
	public abstract void close() throws IOException;
	
	public boolean addResponse(Entry<String, Message> entry)
	{
		return responses.add(entry);
	}
	
	public boolean addResponse(String query, Message response)
	{
		return responses.add(new AbstractMap.SimpleEntry<>(query, response));
	}
	
	public ArrayList<Entry<String, Message>> getResponseList()
	{
		return responses;
	}
}
