package pl.hackerspaceDev.webApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="roles")
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(length=64)
	private String role;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(referencedColumnName="name", name="name")
	private User user;

	public Role() {
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	@Override
	public String toString() {
		return getUser().getName();
	}


	
	
	

}