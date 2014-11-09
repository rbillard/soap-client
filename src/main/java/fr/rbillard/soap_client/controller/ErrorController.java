package fr.rbillard.soap_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/error" )
public class ErrorController {

	@ModelAttribute( "title" )
	public String getTitle() {
		return "Error";
	}

	@RequestMapping( "/404" )
	public String error404() {
		return "error/404";
	}
	
}
