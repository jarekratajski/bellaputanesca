package com.julian.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;

@Entity
public class Parcel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	public final ParcelType type;

	@DecimalMin(value="0.0")
	public final double weightKg;
	
	@DecimalMin(value="0.0")
	public final double sizeDm3;
	
	public final boolean fragile;
	
	@Lob
	private String description;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public final Order order;
	
	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Parcel() {
		this.type = ParcelType.DEFAULT;
		this.weightKg = 0;
		this.sizeDm3 = 0;
		this.fragile = false;
		this.order = new Order();
	}
	
	public Parcel(ParcelType parcelType, double weightKg, double sizeDm3, boolean fragile, Order order) {
		this.type = parcelType;
		this.weightKg = weightKg;
		this.sizeDm3 = sizeDm3;
		this.fragile = fragile;
		order.addParcel(this);
		this.order = order;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}