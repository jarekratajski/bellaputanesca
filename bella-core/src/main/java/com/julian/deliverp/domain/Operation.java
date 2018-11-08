package com.julian.deliverp.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Immutable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class should be final but JPA does not allow the entities class to be
 * final. Documentation of the Hibernate says: "The entity class must not be
 * final.", "The entity class must be a top-level class."
 */
@Entity
@Immutable
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable=false)
	public final String url;
	
	@Column(updatable=false)
	@Enumerated(EnumType.STRING)
	public final RequestMethod requestMethod;
	
	@Column(updatable=false)
	public final LocalDateTime dateTime;

	@ManyToOne(fetch = FetchType.EAGER)
	public final User user;

	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Operation() {
		this.dateTime = LocalDateTime.now();
		this.requestMethod = null;
		this.url = null;
		this.user = null;
	}

	public Operation(String url, RequestMethod requestMethod, User user) {
		this.dateTime = LocalDateTime.now();
		this.url = url;
		this.requestMethod = requestMethod;
		this.user = user;
	}

	public Long getId() {
		return id;
	}
}
