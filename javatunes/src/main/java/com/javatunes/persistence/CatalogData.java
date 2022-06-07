/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

public class CatalogData extends ArrayList<MusicItem>{

	private static final long serialVersionUID = 1L;

	{
	      add(1, "Diva", "Annie Lennox", "1992-01-04", "13.99", MusicCategory.Pop);
	      add(2,"Dream of the Blue Turtles", "Sting", "1985-02-05", "14.99", MusicCategory.Pop);
	      add(3,"Trouble is...", "Kenny Wayne Shepherd Band", "1997-08-08", "14.99", MusicCategory.Blues);
	      add(4,"Lie to Me", "Jonny Lang", "1997-08-26", "17.97", MusicCategory.Blues);
	      add(5,"Little Earthquakes", "Tori Amos", "1992-01-18", "14.99", MusicCategory.Alternative);
	      add(6,"Seal", "Seal", "1991-08-18", "17.97", MusicCategory.Pop);
	      add(7,"Ian Moore", "Ian Moore", "1993-12-05", "9.97", MusicCategory.Classical);
	      add(8,"So Much for the Afterglow", "Everclear", "1997-01-19", "13.99", MusicCategory.Rock);
	      add(9,"Surfacing", "Sarah McLachlan", "1997-12-04", "17.97", MusicCategory.Alternative);
	      add(10,"Hysteria", "Def Leppard", "1987-06-20", "17.97", MusicCategory.Rock);
	      add(11,"A Life of Saturdays", "Dexter Freebish", "2000-12-06", "16.97", MusicCategory.Rap);
	      add(12,"Human Clay", "Creed", "1999-10-21", "18.97", MusicCategory.Rock);
	      add(13,"My, I'm Large", "Bobs", "1987-02-20", "11.97", MusicCategory.Country);
	      add(14,"So", "Peter Gabriel", "1986-10-03", "17.97", MusicCategory.Pop);
	      add(15,"Big Ones", "Aerosmith", "1994-05-08", "18.97",MusicCategory.Rock);
	      add(16,"90125", "Yes", "1983-10-16", "11.97",MusicCategory.Rock);
	      add(17,"1984", "Van Halen", "1984-08-19", "11.97", MusicCategory.Rock);
	      add(18,"Escape", "Journey", "1981-02-25", "11.97", MusicCategory.Classic_Rock);  
	}

	   private void add(Integer id,String title, String artist,String releaseDate, String price, MusicCategory musicCategory){
	     this.add(new MusicItem((long)id, title, artist, releaseDate, new BigDecimal(price), musicCategory ));
	   }
}
