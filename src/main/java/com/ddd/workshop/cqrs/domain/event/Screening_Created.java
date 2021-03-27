package com.ddd.workshop.cqrs.domain.event;

import com.ddd.workshop.cqrs.domain.obj.Seat;

import java.util.List;

public class Screening_Created {
	public List<Seat> availableSeats;

	public Screening_Created(List<Seat> availableSeats) {
		this.availableSeats = availableSeats;
	}
}
