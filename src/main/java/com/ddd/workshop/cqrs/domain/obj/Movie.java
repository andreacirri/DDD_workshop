package com.ddd.workshop.cqrs.domain.obj;

import java.util.Objects;
import java.util.StringJoiner;

public class Movie {
	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public String title() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Movie movie = (Movie) o;
		return Objects.equals(title, movie.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Movie.class.getSimpleName() + "[", "]").add("title='" + title + "'").toString();
	}

}
