package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "no_user")
@Table(name = "JPA_USER")
@NamedQueries({
	@NamedQuery(name="user.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name="user.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name="user.findByName", query = "SELECT u FROM User u WHERE u.firstname LIKE :name OR u.lastname LIKE :name OR CONCAT(u.firstname, ' ', u.lastname) LIKE :name"),
})
public class User {

	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="username")
	@Size(min = 3, max = 25, message = "\"${validatedValue}\" is ${validatedValue.length() < 1 ? 'way' : ''} too short.")
	@NotEmpty
	private String username;
	
	@Column(name="password")
	@NotEmpty
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Transient
	private String fullname;
	
	@OneToMany(mappedBy = "user")
	private List<Notification> notifications;
 
	public User() {
		super();
	}
	
	public User(String username, String password, String firstname,
			String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User(int id, String username, String password, String firstname,
			String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFullname() {
		return firstname + " " + lastname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
