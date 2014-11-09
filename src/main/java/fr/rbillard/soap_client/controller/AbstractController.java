package fr.rbillard.soap_client.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class AbstractController {
	
	private static final String LABEL_ADD = "Add";
	private static final String LABEL_UPDATE = "Update";

	@ModelAttribute( "title" )
	public abstract String getTitle();
	
	public abstract String getMenuCss();
	
	protected ModelMap populateSubmitLabel( ModelMap model, Long id ) {
		return model.addAttribute( "submit", id == null ? LABEL_ADD : LABEL_UPDATE );
	}
	
}
