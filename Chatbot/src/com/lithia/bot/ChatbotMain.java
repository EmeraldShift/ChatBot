package com.lithia.bot;

import java.util.Scanner;

import com.lithia.bot.ai.Bot;
import com.lithia.bot.ai.Message;

public class ChatbotMain
{
	public static void main(String[] args)
	{
		Bot bot = new Bot();
		bot.greet();
		
		Scanner in = new Scanner(System.in);
		String line;
		while (bot.active && !(line = in.nextLine()).equals("!forcequit"))
		{
			System.out.println(bot.getResponse(new Message(line.replaceAll("|", ""))));
		}
		
		in.close();
	}
}
