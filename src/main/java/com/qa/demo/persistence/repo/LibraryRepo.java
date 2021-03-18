package com.qa.demo.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.persistence.domain.Library;

@Repository // converts all the noddy exceptions to DataAccessException
public interface LibraryRepo extends JpaRepository<Library, Long> {

}
