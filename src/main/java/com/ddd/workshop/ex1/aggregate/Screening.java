package com.ddd.workshop.ex1.aggregate;

import java.util.Objects;

public class Screening {

	int availableSeats;

	public static Screening of(int availableSeats) {
		return new Screening(availableSeats);
	}

	private Screening(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public void reserveSeats(int seats) {
		if(availableSeats >= seats) {
			availableSeats -= seats;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Screening screening = (Screening) o;
		return availableSeats == screening.availableSeats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableSeats);
	}
}
