package com.binaryphoenixstudios.maas.dto;

import com.binaryphoenixstudios.maas.enumeration.TokenSource;

/**
 * DTO which encompasses a source location and a source type.
 *
 * @author Scott Woodward
 * @since 1.0
 */
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
