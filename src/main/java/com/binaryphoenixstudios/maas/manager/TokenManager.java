package com.binaryphoenixstudios.maas.manager;

import com.binaryphoenixstudios.maas.handler.TokenSourceHandler;
import com.binaryphoenixstudios.maas.dto.TokenDTO;
import com.binaryphoenixstudios.maas.enumeration.TokenSource;

import java.util.List;

public interface TokenManager
{
	String getNextToken(List<TokenDTO> tokens, List<String> previousTokens);
	
	TokenSourceHandler getTokenSourceHandlerForTokenSource(TokenSource tokenSource);
}
