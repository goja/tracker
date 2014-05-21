package org.goja.tracker.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket implements Serializable {

	private static final long serialVersionUID = 6232235360983944420L;

	@Id
	@GeneratedValue
	private Long id;
}
