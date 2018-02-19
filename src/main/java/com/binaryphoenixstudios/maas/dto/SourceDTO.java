package com.binaryphoenixstudios.maas.dto;

import com.binaryphoenixstudios.maas.enumeration.TokenSource;

public class SourceDTO
{
	protected String sourceValue;
	protected TokenSource tokenSource;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Getters & Setters
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getSourceValue()
	{
		return sourceValue;
	}
	
	public void setSourceValue(String sourceValue)
	{
		this.sourceValue = sourceValue;
	}
	
	public TokenSource getTokenSource()
	{
		return tokenSource;
	}
	
	public void setTokenSource(TokenSource tokenSource)
	{
		this.tokenSource = tokenSource;
	}
}
