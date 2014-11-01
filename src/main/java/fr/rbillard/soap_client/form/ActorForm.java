package fr.rbillard.soap_client.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ActorForm {

	private Long id;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotNull
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date birthDate;
	
	
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
	
	
}
