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

import com.qa.demo.dto.ItemDTO;
import com.qa.demo.persistence.domain.Item;
import com.qa.demo.service.ItemService;

@RestController // automatically adds @ResponseBody
//@Controller // enables request mappings 
@RequestMapping("/item")
public class ItemController {

	private ItemService service;

	public ItemController(ItemService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO item) {
		return new ResponseEntity<ItemDTO>(this.service.create(item), HttpStatus.CREATED);
	}

	@GetMapping("/readAll")
	public List<ItemDTO> readAll() {
		return this.service.readAll();
	}

	@PutMapping("/update/{id}")
	public Item update(@PathVariable Long id, @RequestBody Item newLib) {
		return this.service.update(id, newLib);
	}

	@DeleteMapping("/delete")
	public boolean delete(@PathParam("id") Long id) {
		return this.service.delete(id);
	}

}
