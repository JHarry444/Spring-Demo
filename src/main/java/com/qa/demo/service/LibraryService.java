package com.qa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.demo.dto.LibraryDTO;
import com.qa.demo.exceptions.LibraryNotFoundException;
import com.qa.demo.persistence.domain.Library;
import com.qa.demo.persistence.repo.LibraryRepo;
import com.qa.demo.utils.mappers.LibraryMapper;

@Service
public class LibraryService {

	private LibraryRepo repo;

	private LibraryMapper mapper;

	public LibraryService(LibraryRepo repo, LibraryMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public LibraryDTO create(LibraryDTO lib) {
		return this.mapper.mapTo(this.repo.save(this.mapper.mapFrom(lib)));
	}

	public List<LibraryDTO> readAll() {
		return this.repo.findAll().stream().map(this.mapper::mapTo).collect(Collectors.toList());
	}

	public Library update(Long id, Library newLib) {
		Library found = this.repo.findById(id).orElseThrow(LibraryNotFoundException::new);
		found.setName(newLib.getName());

		return this.repo.save(found);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
