package com.ddd.workshop.cqrs.domain.event;

import java.util.Objects;

public class ScreeningChosen {
	
	Long screeningId;

	public ScreeningChosen(Long screeningId) {
		this.screeningId = screeningId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ScreeningChosen that = (ScreeningChosen) o;
		return Objects.equals(screeningId, that.screeningId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(screeningId);
	}
}
