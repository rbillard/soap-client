package fr.rbillard.soap_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/" )
public class HomeController extends AbstractController {
	
	@RequestMapping( "/" )
	public String home() {
		return "home";
	}
	
	@Override
	public String getTitle() {
		return "Home";
	}

	@Override
	@ModelAttribute( "homeMenuCss" )
	public String getMenuCss() {
		return "active";
	}
	
}
