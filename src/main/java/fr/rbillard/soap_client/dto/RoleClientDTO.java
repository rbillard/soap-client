package fr.rbillard.soap_client.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RoleClientDTO {
	
	private Long id;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotNull
	private ActorClientDTO actor;

	@NotNull
	private MovieClientDTO movie;
	
	
	public Long getId() {
		return id;
	}
	public void setId( Long id ) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}
	
	
	public ActorClientDTO getActor() {
		return actor;
	}
	public void setActor( ActorClientDTO actor ) {
		this.actor = actor;
	}
	
	
	public MovieClientDTO getMovie() {
		return movie;
	}
	public void setMovie( MovieClientDTO movie ) {
		this.movie = movie;
	}
	
	
}
