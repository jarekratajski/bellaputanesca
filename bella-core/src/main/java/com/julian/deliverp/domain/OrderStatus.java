package com.julian.deliverp.domain;

import javax.persistence.Id;


public enum OrderStatus {

	CREATED(0, true), 
	DRIVER_ASSIGNED(2, false), 
	ROUTE_ASSIGNED(4, false), 
	SHIPPER_PROCESSING(6, false),
	READY_FOR_REALIZATION(8, true),
	CONVEYED_BY_DRIVER(10, true),
	FINALIZATION_OF_DELIVER(12, true),
	
	SUCCESSFULLY_FINISHED(20, true),
	
	CANCELLED(100, true),
	REJECTED_BY_SHIPPER(102, true),
	REJECTED_BY_CLIENT(104, true),
	PAUSED(90, true),
	PAUSED_REQUIRE_CLIENTS_ACTION(92, true),
	OTHER(99, true),
	DEFAULT(98, false);
	
	@Id
	final int id;
	final boolean visibleForClient;
	
	OrderStatus(int id, boolean visibleForClient) {
		this.id = id;
		this.visibleForClient = visibleForClient;
	}
}
