package com.ddd.workshop.cqrs.domain.command;

import com.ddd.workshop.cqrs.domain.obj.Person;
import com.ddd.workshop.cqrs.domain.obj.Seat;

import java.util.List;

public class ReserveSeats {

	private List<Seat> seats;
	private Person person;

	public ReserveSeats(List<Seat> seats, Person customer) {
		this.seats = seats;
		this.person = customer;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public Person getPerson() {
		return person;
	}
}
