package com.ddd.workshop.ex1.handler;

import com.ddd.workshop.ex1.aggregate.Screening;
import com.ddd.workshop.ex1.command.ReservationCommand;
import com.ddd.workshop.ex1.repository.ReservationRepositoryInterface;

public class ReservationHandler {

	private ReservationRepositoryInterface repository;

	public ReservationHandler(ReservationRepositoryInterface repository) {
		this.repository = repository;
	}

	public void handle(ReservationCommand reservationCommand) {

		Screening screening = repository.get();
		screening.reserveSeats(reservationCommand.seats);

	}
}
