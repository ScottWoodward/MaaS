package com.binaryphoenixstudios.maas.controller.v1;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import com.binaryphoenixstudios.maas.enumeration.TokenSource;
import com.binaryphoenixstudios.maas.handler.TokenSourceHandler;
import com.binaryphoenixstudios.maas.manager.ChainManager;
import com.binaryphoenixstudios.maas.manager.TokenManager;
import com.binaryphoenixstudios.maas.request.v1.ChainRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1/")
public class ChainController
{
	protected static final int COHERENCE = 3;
	
	@Autowired protected TokenManager tokenManager;
	@Autowired protected ChainManager chainManager;
	
	@RequestMapping(value = "chain", method = RequestMethod.POST)
	public String getChain(Map<String, Object> model, @ModelAttribute("request")ChainRequest request)
	{
		//sources.add("=batman");
		TokenSourceHandler handler = tokenManager.getTokenSourceHandlerForTokenSource(TokenSource.WIKIPEDIA);
		List<TokenDTO> tokens = handler.getTokens(request.getSources(), COHERENCE);
		model.put("message", chainManager.generateChain(tokens, COHERENCE));
		return "index";
	}
	
	@RequestMapping("chain")
	public ModelAndView getHome(Map<String, Object> model)
	{
		return new ModelAndView("index", "request", new ChainRequest());
	}
}
