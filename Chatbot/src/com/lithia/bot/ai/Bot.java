package com.lithia.bot.ai;

import com.lithia.bot.ai.Message.MessageType;
import com.lithia.bot.repo.LocalResponseRepository;
import com.lithia.bot.repo.ResponseRepository;

public class Bot
{
	@SuppressWarnings("unused")
	private ResponseRepository responseRepository = getResponseRepository();
	
	public String getResponse(Message in)
	{
		String response = "";
		if (in.contains("?"))
			in.setType(MessageType.QUESTION);
		
		// TODO generate response
		
		return response;
	}
	
	public void greet()
	{
		System.out.println("Hello, let's chat!");
	}
	
	public void farewell()
	{
		System.out.println("Bye!");
	}
	
	private ResponseRepository getResponseRepository()
	{
		return new LocalResponseRepository("res.dat");
	}
	
}
