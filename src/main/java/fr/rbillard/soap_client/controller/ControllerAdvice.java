package fr.rbillard.soap_client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import fr.rbillard.soap_server.ws.ActorNotFoundException_Exception;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
	@Value( "${soap-server.address}" )
	private String soapServerAddress;
	
	@ModelAttribute( "context" )
	public String getContext() {
		return "soap-client";
	}
	
	@ExceptionHandler( WebServiceException.class )
	public ModelAndView handleWebServiceException() {
		
		ModelAndView modelAndView = newModelAndView( "error/web-service-error", "Soap Server Error" );
		modelAndView.addObject( "soapServerAddress", soapServerAddress );
		
		return modelAndView;
		
	}
	
	@ExceptionHandler( ActorNotFoundException_Exception.class )
	public ModelAndView handleActorNotFoundException( ActorNotFoundException_Exception e ) {
		
		ModelAndView modelAndView = newModelAndView( "actor/actor-not-found", "Actor not found" );
		modelAndView.addObject( "actorId", e.getFaultInfo().getActorId() );
		
		return modelAndView;
		
	}
	
	@ExceptionHandler( HttpRequestMethodNotSupportedException.class )
	public ModelAndView handleHttpRequestMethodNotSupportedException() {
		
		ModelAndView modelAndView = newModelAndView( "error/404", "Page not found" );
		
		return modelAndView;

	}
	
	@ExceptionHandler( Exception.class )
	public ModelAndView handleException(HttpServletRequest request, Exception exception) {

	    ModelAndView modelAndVew = newModelAndView( "error/exception", "Unexpected error" );
	    modelAndVew.addObject( "exception", exception );
	    modelAndVew.addObject( "url", request.getRequestURL() );

	    return modelAndVew;
	    
	}

	private ModelAndView newModelAndView( String view, String title ) {
		
		ModelAndView modelAndView = new ModelAndView( view );
		modelAndView.addObject( "title", title );
		modelAndView.addObject( "context", getContext() );
		
		return modelAndView;
		
	}
	
}
