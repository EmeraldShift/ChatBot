package com.lithia.bot.ai;

import com.lithia.bot.repo.ResponseRepository;

public class ResponseGenerator
{
	private ResponseRepository repository;
	
	public ResponseGenerator(ResponseRepository repo)
	{
		this.repository = repo;
	}
	
	public String generateResponse()
	{
		return repository.getResponseList().get((int) (Math.random() * repository.getResponseList().size())).getValue().toString();
	}
}
