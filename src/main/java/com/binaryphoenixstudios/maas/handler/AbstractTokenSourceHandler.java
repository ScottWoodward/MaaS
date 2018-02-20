package com.binaryphoenixstudios.maas.handler;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTokenSourceHandler implements TokenSourceHandler
{
	protected List<TokenDTO> convertStringsToTokens(List<String> strings, int numberOfPreviousDependantTokens)
	{
		List<TokenDTO> tokens = new ArrayList<>();

		List<String> previousTokens = new ArrayList<>();

		for (String string : strings)
		{
			TokenDTO token = new TokenDTO();
			token.setTokenValue(string);
			token.setPreviousTokens(new ArrayList<>(previousTokens));

			previousTokens.add(string);
			if (previousTokens.size() == numberOfPreviousDependantTokens + 1)
			{
				previousTokens.remove(0);
			}

			tokens.add(token);
		}

		return tokens;
	}

	@Override
	public List<TokenDTO> getTokens(String source, int numberOfPreviousDependantTokens)
	{
		List<TokenDTO> tokens = new ArrayList<>();

		List<String> strings = getStringsFromSource(source);

		for (String string : strings)
		{
			List<Sentence> sentences = new ArrayList<>(new Document(string).sentences());

			for (Sentence sentence : sentences)
			{
				tokens.addAll(convertStringsToTokens(sentence.words(), numberOfPreviousDependantTokens));
			}
		}

		return tokens;
	}

	protected abstract List<String> getStringsFromSource(String source);
}
