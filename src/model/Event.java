package model;

public class Event {
	private String urlname;
	private Integer id, utc_offset;
	private Double lat, lon;
	private Long time;

	public Integer getId() {
		return id;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLon() {
		return lon;
	}

	public Long getTime() {
		return time;
	}

	public String getUrlname() {
		return urlname;
	}

	public Integer getUtc_offset() {
		return utc_offset;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}

	public void setUtc_offset(Integer utc_offset) {
		this.utc_offset = utc_offset;
	}

}
