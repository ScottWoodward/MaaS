package com.binaryphoenixstudios.maas.handler;

import com.binaryphoenixstudios.maas.dto.TokenDTO;

import java.util.List;

public interface TokenSourceHandler
{
	List<TokenDTO> getTokens(String source, int numberOfPreviousDependantTokens);
}
