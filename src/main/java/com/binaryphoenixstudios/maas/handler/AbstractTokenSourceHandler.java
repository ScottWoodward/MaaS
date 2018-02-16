package com.binaryphoenixstudios.maas.handler;

import com.binaryphoenixstudios.maas.dto.TokenDTO;

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
}
