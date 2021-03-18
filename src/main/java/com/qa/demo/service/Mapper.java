package com.qa.demo.service;

@FunctionalInterface
public interface Mapper<S, T> {

	T map(S source);

}
