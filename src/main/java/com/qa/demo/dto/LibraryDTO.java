package com.qa.demo.dto;

import java.util.Set;

// POJO -> Plain Old Java Object
// DTO -> Data Transfer Object
public class LibraryDTO {

	private Long id;

	private String name;

	private Set<ItemDTO> ItemDTOs;

	public LibraryDTO() {
		super();
	}

	public LibraryDTO(Long id, String name, Set<ItemDTO> ItemDTOs) {
		super();
		this.id = id;
		this.name = name;
		this.ItemDTOs = ItemDTOs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ItemDTO> getItemDTOs() {
		return ItemDTOs;
	}

	public void setItemDTOs(Set<ItemDTO> ItemDTOs) {
		this.ItemDTOs = ItemDTOs;
	}

}
