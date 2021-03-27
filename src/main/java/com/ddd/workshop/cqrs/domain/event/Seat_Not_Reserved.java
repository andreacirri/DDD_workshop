package com.ddd.workshop.cqrs.domain.event;

import java.util.Objects;

public class Seat_Not_Reserved {
	long id = 1;

	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Seat_Not_Reserved that = (Seat_Not_Reserved) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
