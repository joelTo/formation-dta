package fr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@Column(name = "lastname", length = 30, nullable = false)
	private String lastname;

	@Column(name = "EMAIL", length = 30, nullable = false, unique = true)
	private String email;

	@Column(name = "mdp", length = 30, nullable = false)
	private String mdp;

	public Client() {
	}

	public Client(String name, String lastname, String email, String mdp) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.mdp = mdp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
