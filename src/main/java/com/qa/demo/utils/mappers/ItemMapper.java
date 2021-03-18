package com.qa.demo.utils.mappers;

import org.springframework.stereotype.Component;

import com.qa.demo.dto.ItemDTO;
import com.qa.demo.persistence.domain.Item;
import com.qa.demo.persistence.domain.Library;

@Component
public class ItemMapper implements Mapper<Item, ItemDTO> {

	@Override
	public ItemDTO mapTo(Item item) {
		return new ItemDTO(item.getId(), item.getDescription(), item.getLibrary().getId());
	}

	@Override
	public Item mapFrom(ItemDTO dto) {
		return new Item(dto.getId(), dto.getDescription(), new Library(dto.getLibraryId()));
	}

}
