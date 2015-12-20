package model;

public class Event {
	private String urlname;
	private Integer id, utc_offset;
	private Double lat, lon;
	private Long time;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(Integer id, String urlname, Long time, Integer utc_offset, Double lat, Double lon) {
		super();
		this.urlname = urlname;
		this.id = id;
		this.utc_offset = utc_offset;
		this.lat = lat;
		this.lon = lon;
		this.time = time;
	}

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

	@Override
	public String toString() {
		return "Event [urlname=" + urlname + ", id=" + id + ", utc_offset=" + utc_offset + ", lat=" + lat + ", lon="
				+ lon + ", time=" + time + "]";
	}

}
