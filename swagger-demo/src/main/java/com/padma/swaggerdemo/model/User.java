package com.padma.swaggerdemo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity
@ApiModel(description = "All detailed information about user")
public class User {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	@NotNull
	@NotEmpty
	@Length(min = 1,max = 100)
	@ApiModelProperty(notes = "firstName should not be null")
	private String firstName;
	
	@NotNull
	@NotEmpty
	@Length(min = 1,max = 100)
	@ApiModelProperty(notes = "lastName should not be null")
	private String lastName;
	
	@NotNull
	@Length(min = 1,max = 100)
	@ApiModelProperty(notes = "email should not be null")
	private String email;
	
	@JsonIgnore
	private String username;
	
	@JsonIgnore
	private String password;
	
	@ApiModelProperty(notes = "Date of birth should be in past")
	@Past
	private Date dob;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user" )
	private List<Address> addresses;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}

