package com.binaryphoenixstudios.maas.manager;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import edu.stanford.nlp.simple.Sentence;
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
			if(previousTokens.size() > 3)
			{
				previousTokens.remove(0);
			}
			builder.append(token).append(" ");
		}
		
		return builder.toString();
	}
}
