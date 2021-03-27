package com.ddd.workshop.ex.handler;

import com.ddd.workshop.ex.aggregate.Screening;
import com.ddd.workshop.ex.command.ReservationCommand;
import com.ddd.workshop.ex.model.ReservationResult;
import com.ddd.workshop.ex.repository.ReservationRepositoryInterface;

import static com.ddd.workshop.ex.model.ReservationResult.*;

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
