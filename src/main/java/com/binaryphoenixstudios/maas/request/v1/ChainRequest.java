package com.binaryphoenixstudios.maas.request.v1;

import com.binaryphoenixstudios.maas.dto.SourceDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChainRequest implements Serializable
{
	protected List<SourceDTO> sources = new ArrayList<>();
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Getters & Setters
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<SourceDTO> getSources()
	{
		return sources;
	}
	
	public void setSources(List<SourceDTO> sources)
	{
		this.sources = sources;
	}
}
