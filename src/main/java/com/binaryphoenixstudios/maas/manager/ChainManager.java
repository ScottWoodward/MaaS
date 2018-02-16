package com.binaryphoenixstudios.maas.manager;

import com.binaryphoenixstudios.maas.dto.TokenDTO;

import java.util.List;

public interface ChainManager
{
	String generateChain(List<TokenDTO> tokens, int coherence);
}
