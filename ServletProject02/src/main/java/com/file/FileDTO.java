package com.file;

public class FileDTO {
	private String name;
	private String title;
	private String image; // 이미지 이름을 문자열로 전송받아 입력한다.
	
	// 생성자, 생성자 있으면 getter만 있으면 됨.	
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
