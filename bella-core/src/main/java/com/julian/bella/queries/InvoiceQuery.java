package com.julian.bella.queries;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.julian.bella.domain.Invoice;
import com.julian.bella.domain.Order;

public interface InvoiceQuery extends JpaRepository<Order, Long> {

	//@Query("select count(*), sum(price), month from order_main o where o.nip = ?1 and o.month between ?2 and ?2 + 30 ");
	//List<Invoice> generateInvoiceForMonth(Long nip, LocalDate date);
	
}
