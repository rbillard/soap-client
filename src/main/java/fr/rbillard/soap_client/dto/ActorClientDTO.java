package fr.rbillard.soap_client.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ActorClientDTO {

	private Long id;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotNull
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date birthDate;
	
	private List<RoleClientDTO> roles;
	
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
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate( Date birthDate ) {
		this.birthDate = birthDate;
	}
	
	
	public List<RoleClientDTO> getRoles() {
		return roles;
	}
	public void setRoles( List<RoleClientDTO> roles ) {
		this.roles = roles;
	}
	
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
}
