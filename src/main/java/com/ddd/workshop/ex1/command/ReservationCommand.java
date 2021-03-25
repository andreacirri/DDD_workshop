package com.ddd.workshop.ex1.command;

public class ReservationCommand {
	public int seats;

	public static ReservationCommand of(int seats) {
		return new ReservationCommand(seats);
	}

	private ReservationCommand(int seats) {
		this.seats = seats;
	}
}
