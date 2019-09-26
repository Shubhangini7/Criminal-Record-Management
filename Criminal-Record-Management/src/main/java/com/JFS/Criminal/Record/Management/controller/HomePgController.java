package com.JFS.Criminal.Record.Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller					// @Controller : indicates that the annotated class is a controller.
							// It is a specialization of @Component and is auto detected through class path scanning
							
@RequestMapping("/")		//@RequestMapping is used for mapping web requests

public class HomePgController
{
	@GetMapping()			//specific handler methods, get is by default
	public String homePg()	
	{
		return "homePg";	//return front end pages
	}
	
}
