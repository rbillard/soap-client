package fr.rbillard.soap_client.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.rbillard.soap_client.form.ActorForm;
import fr.rbillard.soap_client.mapper.ActorMapper;
import fr.rbillard.soap_client.utils.DateUtils;
import fr.rbillard.soap_server.ws.Actor;
import fr.rbillard.soap_server.ws.ActorNotFoundException_Exception;
import fr.rbillard.soap_server.ws.ActorWebService;

@Controller
@RequestMapping( "/actor" )
public class ActorController extends AbstractController {
	
	@Autowired
	private ActorWebService actorWS;
	
	@RequestMapping( "/actors" )
	public ModelAndView getActors() throws ActorNotFoundException_Exception {
	
		List<Actor> actors = actorWS.findAll();
		
		ModelAndView modelAndView = new ModelAndView( "actor/actors" );
		modelAndView.addObject( "actors", ActorMapper.map( actors ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/{actorId}" )
	public ModelAndView getOne( @PathVariable Long actorId ) throws ActorNotFoundException_Exception {
		
		Actor actor = actorWS.findOne( actorId );
		
		ModelAndView modelAndView = new ModelAndView( "actor/actor" );
		modelAndView.addObject( "actor", ActorMapper.map( actor ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/delete/{actorId}" )
	public String delete( @PathVariable Long actorId ) {
		
		actorWS.delete( actorId );
		
		return "redirect:/actor/actors";
		
	}
	
	@RequestMapping( "/update/{actorId}" )
	public ModelAndView update( @PathVariable Long actorId ) throws ActorNotFoundException_Exception {
		
		Actor actor = actorWS.findOne( actorId );
		
		ModelAndView modelAndView = new ModelAndView( "actor/actor-form" );
		modelAndView.addObject( "actor", ActorMapper.map( actor ) );
		modelAndView.addObject( "submit", "Update" );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/add" )
	public ModelAndView add() {
		
		ModelAndView modelAndView = new ModelAndView( "actor/actor-form" );
		modelAndView.addObject( "actor", new ActorForm() );
		modelAndView.addObject( "submit", "Add" );
		
		return modelAndView;
		
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public String add( @Valid @ModelAttribute( "actor" ) ActorForm actorForm, BindingResult result ) throws ActorNotFoundException_Exception {
		
		if ( result.hasErrors() ) {
            return "actor/actor-form";
        }
		
		Actor actor = null;
		if ( actorForm.getId() == null ) {
			actor = actorWS.create( actorForm.getFirstName(), actorForm.getLastName(), DateUtils.getXMLGregorianCalendar( actorForm.getBirthDate() ) );
		} else {
			actor = actorWS.update( actorForm.getId(), actorForm.getFirstName(), actorForm.getLastName(), DateUtils.getXMLGregorianCalendar( actorForm.getBirthDate() ) );
		}
		return "redirect:/actor/" + actor.getId();
		
	}
	
	@Override
	@ModelAttribute( "actorMenuCss" )
	public String getMenuCss() {
		return "active";
	}
	
	@Override
	public String getTitle() {
		return "Actor";
	}
	
}
