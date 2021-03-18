package com.qa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.demo.dto.ItemDTO;
import com.qa.demo.persistence.domain.Item;
import com.qa.demo.persistence.repo.ItemRepo;

@Service
public class ItemService {

	private ItemRepo repo;

	private ModelMapper mapper;

	private Mapper<Item, ItemDTO> mapToDTO = item -> this.mapper.map(item, ItemDTO.class);
	private Mapper<ItemDTO, Item> mapFromDTO = itemDTO -> this.mapper.map(itemDTO, Item.class);

	public ItemService(ItemRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public ItemDTO create(Item item) {
		Item saved = this.repo.save(item);
		ItemDTO savedAsDTO = this.mapToDTO.map(saved);
		return savedAsDTO;
	}

	public List<ItemDTO> readAll() {
		return this.repo.findAll().stream().map(this.mapToDTO::map).collect(Collectors.toList());
	}

	public Item update(Long id, Item newLib) {
		Item found = this.repo.findById(id).orElseThrow(ThreadDeath::new);
		found.setDescription(newLib.getDescription());

		return this.repo.save(found);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
