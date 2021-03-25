package com.ddd.workshop.ex1.handler;

import com.ddd.workshop.ex1.aggregate.Screening;
import com.ddd.workshop.ex1.command.ReservationCommand;
import com.ddd.workshop.ex1.repository.ReservationRepositoryInterface;

public class ReservationHandler {

	private ReservationRepositoryInterface repository;

	public static ReservationHandler of(ReservationRepositoryInterface repository) {
		return new ReservationHandler(repository);
	}

	private ReservationHandler(ReservationRepositoryInterface repository) {
		this.repository = repository;
	}

	public void handle(ReservationCommand reservationCommand) {

		Screening screening = repository.get();
		screening.reserveSeats(reservationCommand.seats);

	}
}
