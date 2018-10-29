package com.julian.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.pl.NIP;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@NIP
	@Column(length = 10, unique = true, updatable = false)
	private final String nip;

	private String companyName;

	@OneToOne
	private Address contactAddress;

	@OneToOne
	private Address registrationAddress;

	@OneToOne
	private User user;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "clients")
	Set<Order> orders = new HashSet<>();

	// only for calculating numberOfFinishedOrders and profitFromFinishedOrders
	// that's why don't put it into db
	@Transient
	Set<Order> successfullyfinishedOrders = new HashSet<>();

	@Min(value = 0)
	private long numberOfFinishedOrders;

	@DecimalMin(value = "0.0")
	@Column(scale = 2)
	private BigDecimal profitFromFinishedOrders;

	/**
	 * Arguments of the class are immutable but JPA always needs a default
	 * constructor. Documentation of the Hibernate says: "The entity class must have
	 * a public or protected no-argument constructor."
	 */
	protected Client() {
		this.nip = "0";
		this.profitFromFinishedOrders = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	}

	public Client(String nip) {
		this.nip = nip;
		this.numberOfFinishedOrders = 0;
		this.profitFromFinishedOrders = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
	}

	public Long getId() {
		return id;
	}

	public String getNip() {
		return nip;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(Address address) {
		this.contactAddress = address;
	}

	public Address getRegistrationAddress() {
		return registrationAddress;
	}

	public void setRegistrationAddress(Address address) {
		this.registrationAddress = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// it should be add via Order.addClient()
	protected void addOrder(Order order) {
		orders.add(order);
	}

	public Set<Order> getOrdersCopy() {
		return new HashSet<>(orders);
	}

	public long getFinishedOrdersNumber() {
		return numberOfFinishedOrders;
	}

	public BigDecimal getFinishedOrdersProfit() {
		return profitFromFinishedOrders;
	}

	public void updateOrderStatus(Order order) {
		if (order.getActualStatus() == OrderStatus.SUCCESSFULLY_FINISHED) {
			successfullyfinishedOrders.add(order);
			updateNumberOfFinishedOrders();
			updateProfitFromFinishedOrders();
		}
	}

	private void updateNumberOfFinishedOrders() {
		numberOfFinishedOrders = successfullyfinishedOrders.size();
	}

	private void updateProfitFromFinishedOrders() {
		for (Order order : successfullyfinishedOrders) {
			OrderFinances finances = order.getFinances();
			BigDecimal profit = finances.getFinalPrice().subtract(finances.getFinalExpense());
			this.profitFromFinishedOrders = profitFromFinishedOrders.add(profit);
		}
	}
}