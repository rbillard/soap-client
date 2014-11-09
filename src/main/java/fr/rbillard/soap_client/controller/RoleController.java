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

import fr.rbillard.soap_client.dto.RoleClientDTO;
import fr.rbillard.soap_client.mapper.ActorMapper;
import fr.rbillard.soap_client.mapper.MovieMapper;
import fr.rbillard.soap_client.mapper.RoleMapper;
import fr.rbillard.soap_server.ws.ActorNotFoundException_Exception;
import fr.rbillard.soap_server.ws.CinemaWebService;
import fr.rbillard.soap_server.ws.MovieNotFoundException_Exception;
import fr.rbillard.soap_server.ws.RoleDTO;
import fr.rbillard.soap_server.ws.RoleNotFoundException_Exception;


@Controller
@RequestMapping( "/role" )
public class RoleController extends AbstractController {
	
	@Autowired
	private CinemaWebService cinemaWS;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private ActorMapper actorMapper;
	
	@Autowired
	private MovieMapper movieMapper;
	
	@RequestMapping( "/roles" )
	public ModelAndView getRoles() {
	
		List<RoleDTO> roles = cinemaWS.findAllRoles();
		
		ModelAndView modelAndView = new ModelAndView( "role/roles" );
		modelAndView.addObject( "roles", roleMapper.map( roles ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/{roleId}" )
	public ModelAndView getOne( @PathVariable Long roleId ) throws RoleNotFoundException_Exception {
		
		RoleDTO movie = cinemaWS.findOneRole( roleId );
		
		ModelAndView modelAndView = new ModelAndView( "role/role" );
		modelAndView.addObject( "role", roleMapper.map( movie ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/delete/{roleId}" )
	public String delete( @PathVariable Long roleId ) throws RoleNotFoundException_Exception {
		
		cinemaWS.deleteRole( roleId );
		return "redirect:/role/roles";
		
	}
	
	@RequestMapping( "/update/{roleId}" )
	public ModelAndView update( @PathVariable Long roleId ) throws RoleNotFoundException_Exception {
		
		RoleDTO role = cinemaWS.findOneRole( roleId );
		
		ModelAndView modelAndView = new ModelAndView( "role/role-form" );
		modelAndView.addObject( "role", roleMapper.map( role ) );
		populateModel( modelAndView.getModelMap(), roleId );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/add" )
	public ModelAndView add() {
		
		ModelAndView modelAndView = new ModelAndView( "role/role-form" );
		modelAndView.addObject( "role", new RoleClientDTO() );
		populateModel( modelAndView.getModelMap(), null );
		
		return modelAndView;
		
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public String add( @Valid @ModelAttribute( "role" ) RoleClientDTO roleDTO, BindingResult result, ModelMap model ) throws MovieNotFoundException_Exception, ActorNotFoundException_Exception, RoleNotFoundException_Exception {
		
		if ( result.hasErrors() ) {
			populateModel( model, roleDTO.getId() );
            return "role/role-form";
        }
		
		RoleDTO role = null;
		if ( roleDTO.getId() == null ) {
			role = cinemaWS.createRole( roleDTO.getActor().getId(), roleDTO.getMovie().getId(), roleDTO.getFirstName(), roleDTO.getLastName() );
		} else {
			role = cinemaWS.updateRole( roleDTO.getId(), roleDTO.getActor().getId(), roleDTO.getMovie().getId(), roleDTO.getFirstName(), roleDTO.getLastName() );
		}
		return "redirect:/role/" + role.getId();
		
	}
	
	private void populateModel( ModelMap model, Long roleId ) {
		
		populateSubmitLabel( model, roleId );
		model.addAttribute( "actors", actorMapper.map( cinemaWS.findAllActors() ) );
		model.addAttribute( "movies", movieMapper.map( cinemaWS.findAllMovies() ) );
		
	}

	@Override
	public String getTitle() {
		return "Role";
	}

	@Override
	@ModelAttribute( "roleMenuCss" )
	public String getMenuCss() {
		return "active";
	}

}
