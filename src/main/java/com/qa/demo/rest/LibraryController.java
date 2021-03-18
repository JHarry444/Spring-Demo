package com.qa.demo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.dto.LibraryDTO;
import com.qa.demo.persistence.domain.Library;
import com.qa.demo.service.LibraryService;

@RestController // automatically adds @ResponseBody
//@Controller // enables request mappings 
@RequestMapping("/lib")
public class LibraryController {

	private LibraryService service;

	public LibraryController(LibraryService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<LibraryDTO> create(@RequestBody LibraryDTO lib) {
		return new ResponseEntity<LibraryDTO>(this.service.create(lib), HttpStatus.CREATED);
	}

	@GetMapping("/readAll")
	public List<LibraryDTO> readAll() {
		return this.service.readAll();
	}

	@PutMapping("/update/{id}")
	public Library update(@PathVariable Long id, @RequestBody Library newLib) {
		return this.service.update(id, newLib);
	}

	@DeleteMapping("/delete")
	public boolean delete(@PathParam("id") Long id) {
		return this.service.delete(id);
	}

}
