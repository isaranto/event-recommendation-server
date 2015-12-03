package model;

public class Category {
	private Integer id;
	private String name, shortname;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortname() {
		return shortname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

}
