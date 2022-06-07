/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import java.util.Collection;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

public class CatalogImpl implements Catalog {

	private ItemRepository itemRepository;

	public CatalogImpl() {}
	
	public CatalogImpl(ItemRepository itemRepository) {
		this.itemRepository=itemRepository;
	}
	public void persistBatch(Collection<MusicItem> items) {
		for (MusicItem musicItem : items) {
			itemRepository.persist(musicItem);	
		}
		System.out.println("If you are seeing this, persistBatch ended normally!");
	}
	
	public void persist(MusicItem item) {
		itemRepository.persist(item);
	}
	public void remove(MusicItem item) {
		itemRepository.remove(item);
	}
	
	public MusicItem findById(Long id) {
		return itemRepository.get(id);
	}

	public Collection<MusicItem> findByKeyword(String keyword) {
		return itemRepository.searchByArtistTitle(keyword);
	}
	
	public Collection<MusicItem> findByCategory(String categoryString) {
		MusicCategory category = MusicCategory.valueOf(categoryString);
		return itemRepository.searchByCategory(category);
	}

	@Override
	public int size() {
		return itemRepository.size();
	}
	
	@Override
	public String toString() {
		return "I am a shiny new " + getClass().getName() + " brought to you from Spring" + " but you can just call me " + getClass().getInterfaces()[0] + ".  My itemRepository is " + itemRepository;
	}



}
