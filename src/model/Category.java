package model;

public class Category {
	private int id;
	private String name, shortname;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

}
