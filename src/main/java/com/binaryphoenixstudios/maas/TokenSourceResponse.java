package com.binaryphoenixstudios.maas;

import com.binaryphoenixstudios.maas.enumeration.TokenSource;

import java.util.Arrays;
import java.util.List;

public class TokenSourceResponse
{
	List<TokenSource> tokenSource = Arrays.asList(TokenSource.values());

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Getters & Setters
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List<TokenSource> getTokenSource()
	{
		return tokenSource;
	}

	public void setTokenSource(List<TokenSource> tokenSource)
	{
		this.tokenSource = tokenSource;
	}
}
