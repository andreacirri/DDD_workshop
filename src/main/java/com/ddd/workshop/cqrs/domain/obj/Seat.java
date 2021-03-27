package com.ddd.workshop.cqrs.domain.obj;

import jdk.jfr.DataAmount;

import java.util.Objects;
import java.util.StringJoiner;

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

	@Override
	public String toString() {
		return new StringJoiner(", ", Seat.class.getSimpleName() + "[", "]").add("id=" + id).toString();
	}
}
