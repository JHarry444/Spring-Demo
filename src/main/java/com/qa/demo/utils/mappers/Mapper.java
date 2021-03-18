package com.qa.demo.utils.mappers;

public interface Mapper<E, D> {

	D mapTo(E entity);

	E mapFrom(D dto);

}
