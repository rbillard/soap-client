package fr.rbillard.soap_client.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class AbstractController {

	@ModelAttribute( "title" )
	public abstract String getTitle();
	
	public abstract String getMenuCss();
	
}
