package com.binaryphoenixstudios.maas.controller;

import com.binaryphoenixstudios.maas.handler.WikipediaTokenSourceHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController
{
	@RequestMapping("/what")
	public String getHome(Map<String, Object> model)
	{
		List<String> strings = new ArrayList<>();
		strings.add("1");
		WikipediaTokenSourceHandler handler = new WikipediaTokenSourceHandler();
		handler.getTokens(strings, 1);
		
		model.put("message", "Scott");
		return "index";
	}
}
