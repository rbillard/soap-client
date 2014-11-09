package fr.rbillard.soap_client.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.rbillard.soap_client.dto.ActorClientDTO;
import fr.rbillard.soap_server.ws.ActorDTO;

@Component
public final class ActorMapper {

	@Autowired
	private Mapper mapper;
	
	private ActorMapper() {
		
	}
	
	public ActorClientDTO map(ActorDTO actor) {
		return mapper.map( actor, ActorClientDTO.class );
	}

	public List<ActorClientDTO> map( List<ActorDTO> actors ) {
		
		List<ActorClientDTO> dtos = new ArrayList<>( actors.size() );
		
		for ( ActorDTO actor : actors ) {
			dtos.add( map( actor ) );
		}
		
		return dtos;
		
	}
	
}
