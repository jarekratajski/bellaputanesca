package com.julian.bella.domain;

import java.time.LocalDate;

public class Invoice {
	public final Long nip;
	public final double priceSum;
	public final double countN;
	public final LocalDate month;
	
	public Invoice(Long nip, double priceSum, double countN, LocalDate month) {
		this.nip = nip;
		this.priceSum = priceSum;
		this.countN = countN;
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "" + nip + 
				"\n deliverp company sp. z o.o. \n nip 11111111 \n" +
				"faktura vat \n" +
				"miesiac \t usluga \t szt. \t wartosc \t vat \n" +
				month + "\t uslugi kurierskie \t" + countN + " \t " + 
				priceSum + " \t " + priceSum * 0.23;
	
	}
}
