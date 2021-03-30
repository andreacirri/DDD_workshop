package com.ddd.workshop.cqrs.domain.event;

import com.ddd.workshop.cqrs.domain.obj.Movie;
import com.ddd.workshop.cqrs.domain.obj.Seat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScreeningScheduled {

	private Long id;
	private Movie movie;
	private BigDecimal price;
	private LocalDateTime time;
	private Set<Seat> seats;

	public ScreeningScheduled(Long id, Movie movie, BigDecimal price, LocalDateTime time, List<Seat> seats) {
		this.id = id;
		this.movie = movie;
		this.price = price;
		this.time = time;
		this.seats = new HashSet<>();
		this.seats.addAll(seats);
	}

	public Long id() {
		return id;
	}

	public Movie movie() {
		return movie;
	}

	public BigDecimal price() {
		return price;
	}

	public LocalDateTime time() {
		return time;
	}

	public Set<Seat> getSeats() {
		return seats;
	}
}
