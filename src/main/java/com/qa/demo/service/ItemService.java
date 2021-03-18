package com.qa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.demo.dto.ItemDTO;
import com.qa.demo.exceptions.ItemNotFoundException;
import com.qa.demo.persistence.domain.Item;
import com.qa.demo.persistence.repo.ItemRepo;
import com.qa.demo.utils.mappers.ItemMapper;

@Service
public class ItemService {

	private ItemRepo repo;

	private ItemMapper mapper;

	public ItemService(ItemRepo repo, ItemMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public ItemDTO create(ItemDTO item) {
		Item toSave = this.mapper.mapFrom(item);
		Item saved = this.repo.save(toSave);
		ItemDTO savedAsDTO = this.mapper.mapTo(saved);
		return savedAsDTO;
	}

	public List<ItemDTO> readAll() {
		return this.repo.findAll().stream().map(this.mapper::mapTo).collect(Collectors.toList());
	}

	public Item update(Long id, Item newLib) {
		Item found = this.repo.findById(id).orElseThrow(ItemNotFoundException::new);
		found.setDescription(newLib.getDescription());

		return this.repo.save(found);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
