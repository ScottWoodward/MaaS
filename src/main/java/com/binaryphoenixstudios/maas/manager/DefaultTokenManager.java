package com.binaryphoenixstudios.maas.manager;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import com.binaryphoenixstudios.maas.enumeration.TokenSource;
import com.binaryphoenixstudios.maas.handler.TokenSourceHandler;
import com.binaryphoenixstudios.maas.handler.WikipediaTokenSourceHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTokenManager implements TokenManager
{
	protected static final SecureRandom random = new SecureRandom();
	
	@Override
	public String getNextToken(List<TokenDTO> tokens, List<String> previousTokens)
	{
		List<TokenDTO> availableTokens = new ArrayList<>();
		
		for (TokenDTO token : tokens)
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
		
		//Now that we have all tokens which can be next, pick one at random.
		if (availableTokens.size() > 0)
		{
			return availableTokens.get(random.nextInt(availableTokens.size())).getTokenValue();
		}
		else
		{
			return "";
		}
	}
	
	@Override
	public TokenSourceHandler getTokenSourceHandlerForTokenSource(TokenSource tokenSource)
	{
		TokenSourceHandler handler = null;
		switch(tokenSource)
		{
			case WIKIPEDIA: handler = new WikipediaTokenSourceHandler();
		}
		
		return handler;
	}
}
