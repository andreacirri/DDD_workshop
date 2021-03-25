package com.ddd.workshop.ex1.handler;

import com.ddd.workshop.ex1.aggregate.Screening;
import com.ddd.workshop.ex1.command.ReservationCommand;
import com.ddd.workshop.ex1.model.ReservationResult;
import com.ddd.workshop.ex1.repository.ReservationRepositoryInterface;

import static com.ddd.workshop.ex1.model.ReservationResult.*;

public class ReservationHandler {

	private ReservationRepositoryInterface repository;

	public static ReservationHandler of(ReservationRepositoryInterface repository) {
		return new ReservationHandler(repository);
	}

	private ReservationHandler(ReservationRepositoryInterface repository) {
		this.repository = repository;
	}

	public ReservationResult handle(ReservationCommand reservationCommand) {
		Screening screening = repository.get();
		boolean reservationResult = screening.reserveSeats(reservationCommand.seats);
		return reservationResult ? SUCCESS : FAIL;
	}
}
