package com.lithia.bot.ai;

import java.io.IOException;
import java.util.AbstractMap;

import com.lithia.bot.ai.Message.MessageType;
import com.lithia.bot.repo.LocalResponseRepository;
import com.lithia.bot.repo.ResponseRepository;

public class Bot
{
	private ResponseRepository responseRepository;
	private ResponseGenerator responseGenerator;
	private String lastMessage;
	public boolean active = true;

	public Bot()
	{
		responseRepository = getResponseRepository();
		responseGenerator = new ResponseGenerator(responseRepository);

		try
		{
			responseRepository.open();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String getResponse(Message in)
	{
		if (in.contains("?"))
			in.setType(MessageType.QUESTION);

		responseRepository.addResponse(new AbstractMap.SimpleEntry<>(lastMessage, in));
		lastMessage = responseGenerator.generateResponse();

		if (in.toString().equalsIgnoreCase("bye"))
		{
			try
			{
				responseRepository.close();
			}
			catch (IOException e)
			{
				System.out.println("Error closing file!!!");
			}
			
			active = false;
			return getFarewell();
		}

		return lastMessage;
	}

	public void greet()
	{
		lastMessage = "Hello, let's chat!";
		System.out.println("Hello, let's chat!");
	}

	public String getFarewell()
	{
		return "Bye!";
	}

	private ResponseRepository getResponseRepository()
	{
		return new LocalResponseRepository("res.dat");
	}
}
