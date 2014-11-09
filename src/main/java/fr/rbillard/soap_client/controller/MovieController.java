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

import fr.rbillard.soap_client.dto.MovieClientDTO;
import fr.rbillard.soap_client.mapper.MovieMapper;
import fr.rbillard.soap_server.ws.CinemaWebService;
import fr.rbillard.soap_server.ws.MovieDTO;
import fr.rbillard.soap_server.ws.MovieNotFoundException_Exception;

@Controller
@RequestMapping( "/movie" )
public class MovieController extends AbstractController {

	@Autowired
	private CinemaWebService cinemaWS;
	
	@Autowired
	private MovieMapper movieMapper;
	
	@RequestMapping( "/movies" )
	public ModelAndView getMovies() throws MovieNotFoundException_Exception {
	
		List<MovieDTO> movies = cinemaWS.findAllMovies();
		
		ModelAndView modelAndView = new ModelAndView( "movie/movies" );
		modelAndView.addObject( "movies", movieMapper.map( movies ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/{movieId}" )
	public ModelAndView getOne( @PathVariable Long movieId ) throws MovieNotFoundException_Exception {
		
		MovieDTO movie = cinemaWS.findOneMovie( movieId );
		
		ModelAndView modelAndView = new ModelAndView( "movie/movie" );
		modelAndView.addObject( "movie", movieMapper.map( movie ) );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/delete/{movieId}" )
	public String delete( @PathVariable Long movieId ) {
		
		cinemaWS.deleteMovie( movieId );
		return "redirect:/movie/movies";
		
	}
	
	@RequestMapping( "/update/{movieId}" )
	public ModelAndView update( @PathVariable Long movieId ) throws MovieNotFoundException_Exception {
		
		MovieDTO movie = cinemaWS.findOneMovie( movieId );
		
		ModelAndView modelAndView = new ModelAndView( "movie/movie-form" );
		modelAndView.addObject( "movie", movieMapper.map( movie ) );
		populateSubmitLabel( modelAndView.getModelMap(), movieId );
		
		return modelAndView;
		
	}
	
	@RequestMapping( "/add" )
	public ModelAndView add() {
		
		ModelAndView modelAndView = new ModelAndView( "movie/movie-form" );
		modelAndView.addObject( "movie", new MovieClientDTO() );
		populateSubmitLabel( modelAndView.getModelMap(), null );
		
		return modelAndView;
		
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public String add( @Valid @ModelAttribute( "movie" ) MovieClientDTO movieDTO, BindingResult result, ModelMap model ) throws MovieNotFoundException_Exception {
		
		if ( result.hasErrors() ) {
			populateSubmitLabel( model, movieDTO.getId() );
            return "movie/movie-form";
        }
		
		MovieDTO movie = null;
		if ( movieDTO.getId() == null ) {
			movie = cinemaWS.createMovie( movieDTO.getTitle() );
		} else {
			movie = cinemaWS.updateMovie( movieDTO.getId(), movieDTO.getTitle() );
		}
		return "redirect:/movie/" + movie.getId();
		
	}

	@Override
	public String getTitle() {
		return "Movie";
	}
	
	@Override
	@ModelAttribute( "movieMenuCss" )
	public String getMenuCss() {
		return "active";
	}
	
}
