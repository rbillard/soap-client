package fr.rbillard.soap_client.dto;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class MovieClientDTO {

	private Long id;
	
	@NotEmpty
	private String title;
	
	private List<RoleClientDTO> roles;
	
	
	public Long getId() {
		return id;
	}
	public void setId( Long id ) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle( String title ) {
		this.title = title;
	}
	
	
	public List<RoleClientDTO> getRoles() {
		return roles;
	}
	public void setRoles( List<RoleClientDTO> roles ) {
		this.roles = roles;
	}
	
	
}
