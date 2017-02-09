package com.lithia.bot.ai;

public class Message
{
	private String line;
	private int type;
	
	public Message(String line)
	{
		this.line = line;
	}
	
	public int getType()
	{
		return type;
	}
	
	public boolean isType(MessageType type)
	{
		return (this.type & type.value()) != 0;
	}
	
	public Message setType(MessageType type)
	{
		this.type |= type.value();
		return this;
	}
	
	public Message setTypeExact(int type)
	{
		this.type = type;
		return this;
	}
	
	public String toString()
	{
		return line;
	}

	public boolean contains(String s)
	{
		return line.toLowerCase().contains(s.toLowerCase());
	}
	
	public static enum MessageType
	{
		STATEMENT,
		QUESTION,
		COMMAND;
		
		public int value()
		{
			return 1 << ordinal();
		}
	}
}
