package com.julian.bella.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderStatusHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;

	@Column(updatable = false)
	@Enumerated(EnumType.STRING)
	public final OrderStatus status;

	@Column(updatable = false)
	public final LocalDateTime dateTime;

	@ManyToOne
	public final Order order;

	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected OrderStatusHistory() {
		this.dateTime = LocalDateTime.now();
		this.status = OrderStatus.DEFAULT;
		this.order = new Order();
	}

	/**
	 * only for Order.class
	 */
	protected OrderStatusHistory(OrderStatus status, Order order) {
		this.dateTime = LocalDateTime.now();
		this.status = status;
		this.order = order;
	}

	public Long getId() {
		return id;
	}
}
