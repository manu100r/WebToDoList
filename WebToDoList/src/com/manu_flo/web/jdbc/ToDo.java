package com.manu_flo.web.jdbc;

public class ToDo {
	//define attributes of a todo
	private int id;
	private String description;
	
	//getter and setter of the attributes
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	//constructors of todo with and without the id attributes
	public ToDo(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public ToDo(String description) {
		super();
		this.description = description;
	}

	//toString method
	@Override
	public String toString() {
		return "To do [id=" + id + ", description=" + description + "]";
	}
}
