package com.julian.bella.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;

/**
 * 
 * this should be a private class of `Order` but then JPA would not create
 * entity. According to Hibernate documentation: "The entity class must be a
 * top-level class"
 * 
 */
@Entity
public class OrderFinances {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	public final Order order;

	@DecimalMin(value = "0.0")
	private BigDecimal finalPrice = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	
	@DecimalMin(value = "0.0")
	private BigDecimal estimatedPrice = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	
	@DecimalMin(value = "0.0")
	private BigDecimal finalExpense = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	
	@DecimalMin(value = "0.0")
	private BigDecimal estimatedExpense = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

	
	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected OrderFinances() {
		this.order = null;
	}
	
	/**
	 * only for Order class
	 */
	protected OrderFinances(Order order) {
		this.order = order;
		recalculate(order);
	}

	public void recalculate(Order order) {
		// TODO Auto-generated method stub

	}

	public Long getId() {
		return id;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public BigDecimal getEstimatedPrice() {
		return estimatedPrice;
	}

	public void calculateEstimatedPrice() {
		// TODO
	}

	public BigDecimal getFinalExpense() {
		return finalExpense;
	}

	public void setFinalExpense(BigDecimal expense) {
		this.finalExpense = expense;
	}

	public BigDecimal getEstimatedExpense() {
		return estimatedExpense;
	}

	public void calculateEstimatedExpense(BigDecimal estimatedExpense) {
		this.estimatedExpense = estimatedExpense;
	}
}
