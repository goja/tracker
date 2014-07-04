package org.goja.tracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.goja.tracker.framework.AbstractEntity;

@Entity
public class Address extends AbstractEntity {

	private static final long serialVersionUID = 9134511702624535526L;

	private String postal;

	@ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Person> persons;

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
