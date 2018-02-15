package com.binaryphoenixstudios.maas;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver
{
	protected static final int NUMBER_OF_PREVIOUS_TOKENS = 3;
	public SecureRandom random = new SecureRandom();

	/*public static void main(String[] args) throws Exception
	{
		Driver driver = new Driver();
		List<Token> tokens = driver.getTokensFromFile("C:\\Users\\Scott\\Desktop\\jstest\\lazy_dog.html");

		//driver.debugTokenList(tokens);
		StringBuilder output = new StringBuilder();

		//Keep track of previous tokens.
		List<String> previousTokens = new ArrayList<>();

		//Get a first token;
		String token = driver.getNextToken(tokens, previousTokens);
		output.append(token).append(" ");
		previousTokens.add(token);

		boolean endsInPeriod = false;
		int numberOfTokens = 0;
		while (!endsInPeriod)
		{
			token = driver.getNextToken(tokens, previousTokens);
			output.append(token).append(" ");

			previousTokens.add(token);
			if (previousTokens.size() == Driver.NUMBER_OF_PREVIOUS_TOKENS + 1)
			{
				previousTokens.remove(0);
			}

			numberOfTokens++;
			if (output.toString().endsWith(". ") || numberOfTokens >= 25)
			{
				break;
			}
		}

		System.out.println(output.toString());
	}

	protected List<Token> getTokensFromFile(String filePath) throws IOException
	{
		List<Token> tokens = new ArrayList<>();
		String content = new String(Files.readAllBytes(Paths.get(filePath)));
		Document doc = Jsoup.parse(content);
		Elements paragraphs = doc.select("p");
		for (Element paragraph : paragraphs)
		{
			String text = paragraph.text();
			List<String> strings = Arrays.asList(text.split(" "));
			tokens.addAll(getTokensFromStrings(strings, Driver.NUMBER_OF_PREVIOUS_TOKENS));
		}
		return tokens;
	}

	protected List<Token> getTokensFromStrings(List<String> strings, int numberOfPreviousTokens)
	{
		List<Token> tokens = new ArrayList<>();

		List<String> previousTokens = new ArrayList<>();

		for (String string : strings)
		{
			Token token = new Token();
			token.setTokenValue(string);
			token.setPreviousTokens(new ArrayList<>(previousTokens));

			previousTokens.add(string);
			if (previousTokens.size() == numberOfPreviousTokens + 1)
			{
				previousTokens.remove(0);
			}

			tokens.add(token);
		}
		return tokens;
	}

	protected String getNextToken(List<Token> tokens, List<String> previousTokens)
	{
		List<Token> availableTokens = new ArrayList<>();

		for (Token token : tokens)
		{
			//Same number of previous tokens, proceed
			if (token.getPreviousTokens().size() == previousTokens.size())
			{
				boolean previousTokensMatch = true;
				for (int i = 0; i < previousTokens.size(); i++)
				{
					if (!StringUtils.equalsIgnoreCase(token.getPreviousTokens().get(i), previousTokens.get(i)))
					{
						previousTokensMatch = false;
					}
				}

				//If all the previous tokens match, add this to available tokens;
				if (previousTokensMatch)
				{
					availableTokens.add(token);
				}
			}
		}

		if (availableTokens.size() > 0)
		{
			return availableTokens.get(random.nextInt(availableTokens.size())).getTokenValue();
		} else
		{
			return "";
		}
	}

	protected void debugTokenList(List<Token> tokens)
	{
		for (Token token : tokens)
		{
			debugToken(token);
		}
	}

	protected void debugToken(Token token)
	{
		StringBuilder output = new StringBuilder();
		output.append(token.getTokenValue()).append(" (");
		for (String previousToken : token.getPreviousTokens())
		{
			output.append(previousToken).append(" ");
		}
		output.append(")");
		System.out.println(output.toString());
	}*/

}
