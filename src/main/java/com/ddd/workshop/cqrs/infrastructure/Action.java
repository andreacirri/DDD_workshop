package com.ddd.workshop.cqrs.infrastructure;

@FunctionalInterface
public interface Action<T> {
	void publish(T object);
}
