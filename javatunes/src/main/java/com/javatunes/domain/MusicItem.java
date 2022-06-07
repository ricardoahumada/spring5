/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicItem {

	private Long id;
	private String title, artist;
	private Date releaseDate;
	private BigDecimal price;
	private MusicCategory musicCategory;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public MusicItem() {
	}

	public MusicItem(Long id) {
		setId(id);
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public MusicItem(String title, String artist, String releaseDate,
			BigDecimal price, MusicCategory musicCategory) {
		this.setTitle(title);
		this.setArtist(artist);
		this.setReleaseDateString(releaseDate);
		this.setPrice(price);
		this.setMusicCategory(musicCategory);
	}
	
	// For InMemory Usage
	public MusicItem(Long id, String title, String artist, String releaseDate,
			BigDecimal price, MusicCategory musicCategory) {
		this.setId(id);
		this.setTitle(title);
		this.setArtist(artist);
		this.setReleaseDateString(releaseDate);
		this.setPrice(price);
		this.setMusicCategory(musicCategory);
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public SimpleDateFormat getDf() {
		return df;
	}

	public void setDf(SimpleDateFormat df) {
		this.df = df;
	}

	public void setReleaseDateString(String releaseDateString) {
		try {
			releaseDate = df.parse(releaseDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean equals(Object compare) {
		boolean result = false;
		MusicItem other = null;

		if (compare instanceof MusicItem) {
			other = (MusicItem) compare;
			result = other.getId().equals(this.getId());
		}
		return result;
	}

	public MusicCategory getMusicCategory() {
		return musicCategory;
	}

	public void setMusicCategory(MusicCategory musicCategory) {
		this.musicCategory = musicCategory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MusicItem [id=" + id + ", title=" + title + ", artist="
				+ artist + ", releaseDate=" + releaseDate + ", price=" + price
				+ ", musicCategory=" + musicCategory + "]";
	}

}
