package model;

public class Profile {
	private String name, bio, country, city, state, email, gender, hometown, lang, link, flickr, tumblr, twitter,
			linkedin, fb_name, fb_gender, facebook;
	private int id, birth_day, birth_month, birth_year;
	private long joined;
	private double lon, lat;

	public Profile(String name, String bio, String country, String city, String state, String email, String gender,
			String hometown, String lang, String link, String flickr, String tumblr, String twitter, String linkedin,
			String fb_name, String fb_gender, String facebook, int id, int birth_day, int birth_month, int birth_year,
			long joined, double lon, double lat) {
		super();
		this.name = name;
		this.bio = bio;
		this.country = country;
		this.city = city;
		this.state = state;
		this.email = email;
		this.gender = gender;
		this.hometown = hometown;
		this.lang = lang;
		this.link = link;
		this.flickr = flickr;
		this.tumblr = tumblr;
		this.twitter = twitter;
		this.linkedin = linkedin;
		this.fb_name = fb_name;
		this.fb_gender = fb_gender;
		this.facebook = facebook;
		this.id = id;
		this.birth_day = birth_day;
		this.birth_month = birth_month;
		this.birth_year = birth_year;
		this.joined = joined;
		this.lon = lon;
		this.lat = lat;
	}

	public String getBio() {
		return bio;
	}

	public int getBirth_day() {
		return birth_day;
	}

	public int getBirth_month() {
		return birth_month;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getFb_gender() {
		return fb_gender;
	}

	public String getFb_name() {
		return fb_name;
	}

	public String getFlickr() {
		return flickr;
	}

	public String getGender() {
		return gender;
	}

	public String getHometown() {
		return hometown;
	}

	public int getId() {
		return id;
	}

	public long getJoined() {
		return joined;
	}

	public String getlang() {
		return lang;
	}

	public double getLat() {
		return lat;
	}

	public String getLink() {
		return link;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public double getLon() {
		return lon;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public String getTumblr() {
		return tumblr;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}

	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setFb_gender(String fb_gender) {
		this.fb_gender = fb_gender;
	}

	public void setFb_name(String fb_name) {
		this.fb_name = fb_name;
	}

	public void setFlickr(String flickr) {
		this.flickr = flickr;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setJoined(long joined) {
		this.joined = joined;
	}

	public void setlang(String lang) {
		this.lang = lang;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public void setLon(double lon) {
		// this.lon = lon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTumblr(String tumblr) {
		this.tumblr = tumblr;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Override
	public String toString() {
		return "Profile [name=" + name + ", bio=" + bio + ", country=" + country + ", city=" + city + ", state=" + state
				+ ", email=" + email + ", gender=" + gender + ", hometown=" + hometown + ", lang=" + lang + ", link="
				+ link + ", flickr=" + flickr + ", tumblr=" + tumblr + ", twitter=" + twitter + ", linkedin=" + linkedin
				+ ", fb_name=" + fb_name + ", fb_gender=" + fb_gender + ", id=" + id + ", facebook=" + facebook
				+ ", birth_day=" + birth_day + ", birth_month=" + birth_month + ", birth_year=" + birth_year
				+ ", joined=" + joined + ", lon=" + lon + ", lat=" + lat + "]";
	}

}
