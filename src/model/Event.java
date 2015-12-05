package model;


public class Event {
	private String urlname;
	private int id, utc_offset;
	private double lat, lon;
	private long time;

	public int getId() {
		return id;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public long getTime() {
		return time;
	}

	public String getUrlname() {
		return urlname;
	}

	public int getUtc_offset() {
		return utc_offset;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}

	public void setUtc_offset(int utc_offset) {
		this.utc_offset = utc_offset;
	}

}
