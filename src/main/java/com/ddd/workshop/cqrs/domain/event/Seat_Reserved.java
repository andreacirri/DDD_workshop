package com.ddd.workshop.cqrs.domain.event;

import com.ddd.workshop.cqrs.domain.obj.Seat;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Seat_Reserved {

	public List<Seat> seats;

	public Seat_Reserved(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Seat_Reserved that = (Seat_Reserved) o;
		return Objects.equals(seats, that.seats);
	}

	@Override
	public int hashCode() {
		return Objects.hash(seats);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Seat_Reserved.class.getSimpleName() + "[", "]").add("seats=" + seats).toString();
	}

}

