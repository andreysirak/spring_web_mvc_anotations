package spittr.data;

import spittr.Spitter;

// no example in the book
public interface SpitterRepository {
	
	public Spitter save (Spitter spitter);
	
	public Spitter findByUsername (String spitter);
	
	

}
