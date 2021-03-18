package com.qa.demo.dto;

public class ItemDTO {

	private Long id;

	private String description;

	private Long libraryId;

	public ItemDTO() {
		super();
	}

	public ItemDTO(Long id, String description, Long libraryId) {
		super();
		this.id = id;
		this.description = description;
		this.libraryId = libraryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}

}
