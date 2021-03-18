package com.qa.demo.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.persistence.domain.Item;

@Repository // converts all the noddy exceptions to DataAccessException
public interface ItemRepo extends JpaRepository<Item, Long> {

}
