package com.ddd.workshop.cqrs.domain.query;

import com.ddd.workshop.cqrs.domain.aggregate.Screening;
import com.ddd.workshop.cqrs.domain.obj.Person;

import java.util.Objects;
import java.util.StringJoiner;

public class ReservationAmountQuery {
	
	private Person person;
	private Long screeningId;

	public ReservationAmountQuery(Person person, Long screeningId) {
		this.person = person;
		this.screeningId = screeningId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ReservationAmountQuery that = (ReservationAmountQuery) o;
		return Objects.equals(person, that.person) && Objects.equals(screeningId, that.screeningId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(person, screeningId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", ReservationAmountQuery.class.getSimpleName() + "[", "]").add("person=" + person)
				.add("screeningId=" + screeningId)
				.toString();
	}

}
