package com.ddd.workshop.cqrs.domain.command;

import com.ddd.workshop.cqrs.domain.obj.Seat;

import java.util.List;
import java.util.Objects;

public class Reserve_Seats {

	public List<Seat> seats;

	public Reserve_Seats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Reserve_Seats that = (Reserve_Seats) o;
		return Objects.equals(seats, that.seats);
	}

	@Override
	public int hashCode() {
		return Objects.hash(seats);
	}

}

