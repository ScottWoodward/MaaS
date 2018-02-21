package com.binaryphoenixstudios.maas.bean;

import javax.persistence.*;

@Entity
@Table(name = "TokenSourceType")
public class TokenSourceType
{
	@Id
	@Column(name = "tokenSourceTypeID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long tokenSourceTypeID;

	@Column(name = "Name")
	protected String name;

	@Column(name = "TokenSourceHandlerName")
	protected String tokenSourceHandlerName;

	@Column(name = "ExampleText")
	protected String exampleText;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Getters & Setters
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public long getTokenSourceTypeID()
	{
		return tokenSourceTypeID;
	}

	public void setTokenSourceTypeID(long tokenSourceTypeID)
	{
		this.tokenSourceTypeID = tokenSourceTypeID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTokenSourceHandlerName()
	{
		return tokenSourceHandlerName;
	}

	public void setTokenSourceHandlerName(String tokenSourceHandlerName)
	{
		this.tokenSourceHandlerName = tokenSourceHandlerName;
	}

	public String getExampleText()
	{
		return exampleText;
	}

	public void setExampleText(String exampleText)
	{
		this.exampleText = exampleText;
	}
}
