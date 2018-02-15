package com.binaryphoenixstudios.maas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController
{
	@RequestMapping("/what")
	public String getHome(Map<String, Object> model)
	{
		model.put("message", "Scott");
		return "index";
	}
}
