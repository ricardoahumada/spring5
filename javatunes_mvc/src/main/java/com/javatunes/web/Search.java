/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.web;

import java.util.Collection;

import com.javatunes.domain.MusicItem;

public class Search {
	private String keyword;
	private Collection<MusicItem> matches;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Collection<MusicItem> getMatches() {
		return matches;
	}
	public void setMatches(Collection<MusicItem> matches) {
		this.matches = matches;
	}
	
	

}
