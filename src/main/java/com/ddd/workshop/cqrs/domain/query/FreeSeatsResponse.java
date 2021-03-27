package com.ddd.workshop.cqrs.domain.query;

import com.ddd.workshop.cqrs.domain.obj.Seat;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class FreeSeatsResponse {

	List<Seat> seats;

	public FreeSeatsResponse(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FreeSeatsResponse that = (FreeSeatsResponse) o;
		return Objects.equals(seats, that.seats);
	}

	@Override
	public int hashCode() {
		return Objects.hash(seats);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", FreeSeatsResponse.class.getSimpleName() + "[", "]").add("seats=" + seats)
				.toString();
	}

}
