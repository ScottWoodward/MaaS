package com.binaryphoenixstudios.maas.controller.v1;

import com.binaryphoenixstudios.maas.dto.SourceDTO;
import com.binaryphoenixstudios.maas.dto.TokenDTO;
import com.binaryphoenixstudios.maas.handler.TokenSourceHandler;
import com.binaryphoenixstudios.maas.manager.ChainManager;
import com.binaryphoenixstudios.maas.manager.TokenManager;
import com.binaryphoenixstudios.maas.request.v1.ChainRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for serving up a Markov Chain from the provided sources.
 *
 * @author Scott Woodward
 * @since 1.0
 */
@RestController
@RequestMapping("/v1/")
public class ChainController
{
	protected static final int COHERENCE = 2;
	
	@Autowired protected TokenManager tokenManager;
	@Autowired protected ChainManager chainManager;
	
	@RequestMapping(value = "chain", method = RequestMethod.POST)
	public ResponseEntity<String> getChain(@RequestBody ChainRequest request)
	{
		List<TokenDTO> tokens = new ArrayList<>();
		for (SourceDTO source : request.getSources())
		{
			TokenSourceHandler handler = tokenManager.getTokenSourceHandlerForTokenSource(source.getTokenSource());
			tokens.addAll(handler.getTokens(source.getSourceValue(), COHERENCE));
		}
		
		return new ResponseEntity<>(chainManager.generateChain(tokens, COHERENCE), HttpStatus.OK);
	}
}
