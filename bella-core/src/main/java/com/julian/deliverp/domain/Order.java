package com.julian.deliverp.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_MAIN")
public class Order	 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(value = EnumType.STRING)
	private OrderStatus actualStatus;

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderStatusHistory> statusHistory = new LinkedList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private OrderFinances finances;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Route route;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Parcel> parcels = new HashSet<>();

	@ManyToMany
	@JoinTable(name="ORDER_CLIENT", joinColumns=@JoinColumn(name="order_id"), 
	inverseJoinColumns=@JoinColumn(name="client_id"))
	private Set<Client> clients = new HashSet<>();
	
	@Lob
	private String notes;

	public Order() {
		this.finances = new OrderFinances(this);
		updateStatus(OrderStatus.CREATED);
	}

	public Long getId() {
		return id;
	}

	public OrderStatus getActualStatus() {
		return actualStatus;
	}

	public void updateStatus(OrderStatus status) {
		// after setting the final status, it can't be change
		if(this.actualStatus == OrderStatus.SUCCESSFULLY_FINISHED) {
			return;
		}
		this.actualStatus = status;
		statusHistory.add(new OrderStatusHistory(status, this));
		notifyClientsAboutOrderStatus();
	}
	
	public void notifyClientsAboutOrderStatus() {
		for(Client c : clients) {
			c.updateOrderStatus(this);
		}
	}

	public List<OrderStatusHistory> getStatusHistoryCopy() {
		return new LinkedList<>(statusHistory);
	}
	
	public OrderFinances getFinances() {
		return finances;
	}

	public void recalculateFinances() {
		finances.recalculate(this);
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	public void addParcel(Parcel parcel) {
		this.parcels.add(parcel);
	}

	public Set<Parcel> getParcelsCopy() {
		return new HashSet<>(parcels);
	}

	public Set<Client> getClientsCopy() { // becuz it shouldn't be change outside the class.
		return new HashSet<>(clients);
	}

	public void addClient(Client client) {
		client.addOrder(this);
		clients.add(client);
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
