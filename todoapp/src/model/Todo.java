package model;

import java.io.Serializable;

public class Todo implements Serializable{
	private int id;
	private String title;
	private int importance;

	public Todo(){}

	public Todo(int id, String title, int importance) {
		super();
		this.id = id;
		this.title = title;
		this.importance = importance;
	}

	public Todo(String title, int importance) {
		super();
		this.title = title;
		this.importance = importance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getImportance() {
		String stars="";
		for(int i=0;i<this.importance;i++) {
			stars+="★";
		}
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}


}