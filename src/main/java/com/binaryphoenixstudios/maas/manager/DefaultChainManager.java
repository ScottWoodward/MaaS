package com.binaryphoenixstudios.maas.manager;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultChainManager implements ChainManager
{
	@Autowired protected TokenManager tokenManager;
	
	public String generateChain(List<TokenDTO> tokens, int coherence)
	{
		StringBuilder builder = new StringBuilder();
		List<String> previousTokens = new ArrayList<>();

		for(int i = 0 ; i < 100 ; i++)
		{
			String token = tokenManager.getNextToken(tokens, previousTokens);
			previousTokens.add(token);
			if(previousTokens.size() > coherence)
			{
				previousTokens.remove(0);
			}
			builder.append(token).append(" ");

			//If we completed a sentence, call it quits.
			if(builder.toString().endsWith("."))
			{
				break;
			}
		}

		//punctuation gets translated into tokens separately, so this should clean a bit of it up.
		String output = builder.toString();
		output.replace(" .", ".");
		output.replace(" ,", ",");
		output.replace(" '", " '");
		return builder.toString();
	}
}
