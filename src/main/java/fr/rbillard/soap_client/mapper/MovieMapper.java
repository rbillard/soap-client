package fr.rbillard.soap_client.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.rbillard.soap_client.dto.MovieClientDTO;
import fr.rbillard.soap_server.ws.MovieDTO;

@Component
public final class MovieMapper {
	
	@Autowired
	private Mapper mapper;
	
	private MovieMapper() {
		
	}

	public MovieClientDTO map( MovieDTO movie ) {
		return mapper.map( movie, MovieClientDTO.class );
	}
	
	public List<MovieClientDTO> map( List<MovieDTO> movies ) {
		
		List<MovieClientDTO> dtos = new ArrayList<>( movies.size() );
		
		for ( MovieDTO movie : movies ) {
			dtos.add( map( movie) );
		}

		return dtos;
		
	}

}
