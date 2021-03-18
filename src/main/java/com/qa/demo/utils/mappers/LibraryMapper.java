package com.qa.demo.utils.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.qa.demo.dto.ItemDTO;
import com.qa.demo.dto.LibraryDTO;
import com.qa.demo.persistence.domain.Library;

@Component
public class LibraryMapper implements Mapper<Library, LibraryDTO> {

	@Override
	public LibraryDTO mapTo(Library lib) {
		Set<ItemDTO> itemDTOs = new HashSet<>();
		if (lib.getItems() != null) {
			itemDTOs = lib.getItems().stream()
					.map(item -> new ItemDTO(item.getId(), item.getDescription(), lib.getId()))
					.collect(Collectors.toSet());
		}
		return new LibraryDTO(lib.getId(), lib.getName(), itemDTOs);
	}

	@Override
	public Library mapFrom(LibraryDTO dto) {
		return new Library(dto.getId(), dto.getName());
	}

}
