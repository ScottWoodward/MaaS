package com.binaryphoenixstudios.maas.controller;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import com.binaryphoenixstudios.maas.enumeration.TokenSource;
import com.binaryphoenixstudios.maas.handler.TokenSourceHandler;
import com.binaryphoenixstudios.maas.handler.WikipediaTokenSourceHandler;
import com.binaryphoenixstudios.maas.manager.ChainManager;
import com.binaryphoenixstudios.maas.manager.TokenManager;
import edu.stanford.nlp.simple.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController
{
	protected static final int COHERENCE = 2;
	@Autowired protected TokenManager tokenManager;
	@Autowired protected ChainManager chainManager;
	
	@RequestMapping("/what")
	public String getHome(Map<String, Object> model)
	{
		List<String> sources = new ArrayList<>();
		sources.add("https://en.wikipedia.org/w/api.php?action=parse&format=json&page=batman");
		TokenSourceHandler handler = tokenManager.getTokenSourceHandlerForTokenSource(TokenSource.WIKIPEDIA);
		List<TokenDTO> tokens = handler.getTokens(sources, COHERENCE);
		model.put("message", chainManager.generateChain(tokens, COHERENCE));
		return "index";
	}
}
