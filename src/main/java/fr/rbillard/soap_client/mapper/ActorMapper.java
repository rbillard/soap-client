package fr.rbillard.soap_client.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.rbillard.soap_client.form.ActorForm;
import fr.rbillard.soap_client.utils.DateUtils;
import fr.rbillard.soap_server.ws.Actor;

public final class ActorMapper {

	private ActorMapper() {
		
	}
	
	public static ActorForm map(Actor actor) {
		
		ActorForm form = new ActorForm();
		form.setId( actor.getId() );
		form.setFirstName( actor.getFirstName() );
		form.setLastName( actor.getLastName() );
		form.setBirthDate( DateUtils.getDate( actor.getBirthDate() ) );
		
		return form;
		
	}

	public static List<ActorForm> map( List<Actor> actors ) {
		
		List<ActorForm> forms = new ArrayList<>( actors.size() );
		
		for ( Actor actor : actors ) {
			forms.add( map( actor ) );
		}
		
		return forms;
		
	}
	
}
