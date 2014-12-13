package pl.hackerspaceDev.webApp.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
