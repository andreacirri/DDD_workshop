package com.ddd.workshop.ex1;

import java.util.Objects;

public class Seat {
	
	public Long id;

	public Seat(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Seat seat = (Seat) o;
		return Objects.equals(id, seat.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
