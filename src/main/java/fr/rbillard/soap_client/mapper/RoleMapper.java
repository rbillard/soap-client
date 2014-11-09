package fr.rbillard.soap_client.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.rbillard.soap_client.dto.RoleClientDTO;
import fr.rbillard.soap_server.ws.RoleDTO;

@Component
public class RoleMapper {
	
	@Autowired
	private Mapper mapper;

	public List<RoleClientDTO> map( List<RoleDTO> roles ) {
		
		List<RoleClientDTO> dtos = new ArrayList<>( roles.size() );
		
		for ( RoleDTO role : roles ) {
			dtos.add( map( role ) );
		}

		return dtos;
		
	}

	public RoleClientDTO map( RoleDTO role ) {
		return mapper.map( role, RoleClientDTO.class );
	}

}
