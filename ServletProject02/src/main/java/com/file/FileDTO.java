package com.file;

public class FileDTO {
	private String name;
	private String title;
	private String image; // �̹��� �̸��� ���ڿ��� ���۹޾� �Է��Ѵ�.
	
	// ������, ������ ������ getter�� ������ ��.	
	public FileDTO(String name, String title, String image) {
		super();
		this.name = name;
		this.title = title;
		this.image = image;
	}
	
	// getter setter
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title == null ? "" : title.trim();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image == null ? "" : image.trim();
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
