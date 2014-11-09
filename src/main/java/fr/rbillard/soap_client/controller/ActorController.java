package fr.rbillard.soap_client.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.rbillard.soap_client.dto.ActorClientDTO;
import fr.rbillard.soap_client.mapper.ActorMapper;
import fr.rbillard.soap_client.utils.DateUtils;
import fr.rbillard.soap_server.ws.ActorDTO;
import fr.rbillard.soap_server.ws.ActorNotFoundException_Exception;
import fr.rbillard.soap_server.ws.CinemaWebService;

@Controller
@RequestMapping( "/actor" )
public class ActorController extends AbstractController {
	
	@Autowired
	private CinemaWebService cinemaWS;
	
	@Autowired
	private ActorMapper actorMapper;
	
	@RequestMapping( "/actors" )
	public ModelAndView getActors() throws ActorNotFoundException_Exception {
	
		List<ActorDTO> actors = cinemaWS.findAllActors();
		
		ModelAndView modelAndView = new ModelAndView( "actor/actors" );
		modelAndView.addObject( "actors", actorMapper.map( actors ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/{actorId}" )
	public ModelAndView getOne( @PathVariable Long actorId ) throws ActorNotFoundException_Exception {
		
		ActorDTO actor = cinemaWS.findOneActor( actorId );
		
		ModelAndView modelAndView = new ModelAndView( "actor/actor" );
		modelAndView.addObject( "actor", actorMapper.map( actor ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/delete/{actorId}" )
	public String delete( @PathVariable Long actorId ) {
		
		cinemaWS.deleteActor( actorId );
		
		return "redirect:/actor/actors";
		
	}
	
	@RequestMapping( "/update/{actorId}" )
	public ModelAndView update( @PathVariable Long actorId ) throws ActorNotFoundException_Exception {
		
		ActorDTO actor = cinemaWS.findOneActor( actorId );
		
		ModelAndView modelAndView = new ModelAndView( "actor/actor-form" );
		modelAndView.addObject( "actor", actorMapper.map( actor ) );
		populateSubmitLabel( modelAndView.getModelMap(), actorId );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/add" )
	public ModelAndView add() {
		
		ModelAndView modelAndView = new ModelAndView( "actor/actor-form" );
		modelAndView.addObject( "actor", new ActorClientDTO() );
		populateSubmitLabel( modelAndView.getModelMap(), null );
		
		return modelAndView;
		
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public String add( @Valid @ModelAttribute( "actor" ) ActorClientDTO actorDTO, BindingResult result, ModelMap model ) throws ActorNotFoundException_Exception {
		
		if ( result.hasErrors() ) {
			populateSubmitLabel( model, actorDTO.getId() );
            return "actor/actor-form";
        }
		
		ActorDTO actor = null;
		if ( actorDTO.getId() == null ) {
			actor = cinemaWS.createActor( actorDTO.getFirstName(), actorDTO.getLastName(), DateUtils.getXMLGregorianCalendar( actorDTO.getBirthDate() ) );
		} else {
			actor = cinemaWS.updateActor( actorDTO.getId(), actorDTO.getFirstName(), actorDTO.getLastName(), DateUtils.getXMLGregorianCalendar( actorDTO.getBirthDate() ) );
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
