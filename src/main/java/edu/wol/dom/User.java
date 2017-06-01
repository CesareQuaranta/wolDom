package edu.wol.dom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {
@Id
@Column(name = "USERNAME",unique=true,columnDefinition="VARCHAR(64)")
private String username;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "prospectiveId", referencedColumnName = "ID")
private Prospective prospective;

public User() {
	this.username = null;
	this.prospective = null;
}
public User(String username, Prospective prospective) {
	super();
	this.username = username;
	this.prospective = prospective;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Prospective getProspective() {
	return prospective;
}
public void setProspective(Prospective prospective) {
	this.prospective = prospective;
}
}
