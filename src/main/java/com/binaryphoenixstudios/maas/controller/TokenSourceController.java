package com.binaryphoenixstudios.maas.controller;

import com.binaryphoenixstudios.maas.TokenSourceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tokensource")
public class TokenSourceController
{
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<TokenSourceResponse> getTokenSources()
	{
		return new ResponseEntity(new TokenSourceResponse(), HttpStatus.OK);
	}
}
