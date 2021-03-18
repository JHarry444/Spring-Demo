package com.qa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.demo.dto.LibraryDTO;
import com.qa.demo.persistence.domain.Library;
import com.qa.demo.persistence.repo.LibraryRepo;

@Service
public class LibraryService {

	private LibraryRepo repo;

	private ModelMapper mapper;

	public LibraryService(LibraryRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private LibraryDTO mapToDTO(Library lib) {
		return this.mapper.map(lib, LibraryDTO.class);

	}

	private Library mapFromDTO(LibraryDTO libDTO) {
		return this.mapper.map(libDTO, Library.class);

	}

	public LibraryDTO create(LibraryDTO lib) {
		return this.mapToDTO(this.repo.save(this.mapFromDTO(lib)));
	}

	public List<LibraryDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public Library update(Long id, Library newLib) {
		Library found = this.repo.findById(id).orElseThrow(ThreadDeath::new);
		found.setName(newLib.getName());

		return this.repo.save(found);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
