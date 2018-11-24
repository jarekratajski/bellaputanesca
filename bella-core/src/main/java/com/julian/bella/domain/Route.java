package com.julian.bella.domain;

import java.io.Serializable;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Route implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	public final Order order;
	
	@ManyToOne(optional = false)
	public final Location from;
	
	@ManyToOne(optional = false)
	public final Location destination;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;
	
	@Transient
	private Queue<Location> stops = new PriorityQueue<>();
	
	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Route() {
		this.order = null;
		this.from = null;
		this.destination = null;
	}
	
	public Route(Order order, Location from, Location destination) {
		order.setRoute(this);
		this.order = order;
		this.from = from;
		this.destination = destination;
	}
	
	public Long getId() {
		return id;
	}

	public Location nextStop() {
		return stops.poll();
	}
	
	public void addStop(Location area) {
		stops.add(area);
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
