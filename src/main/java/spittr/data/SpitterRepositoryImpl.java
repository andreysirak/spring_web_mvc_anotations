package spittr.data;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import spittr.Spitter;

//no example in the book
@Component
public class SpitterRepositoryImpl implements SpitterRepository{
	
	ArrayList<Spitter> listOfSpitters = new ArrayList<Spitter>();

	@Override
	public Spitter save(Spitter spitter) {
		listOfSpitters.add(spitter);
		System.out.println("saved: "+spitter.toString());
		return spitter;
		
	}

	@Override
	public Spitter findByUsername(String spitter) {
		System.out.println("start looking for spitter..."+spitter);
		for (Spitter s: listOfSpitters) {
			System.out.println(s.getUsername());
			if (s.getUsername().equals(spitter)) {
				System.out.println("found: "+s.getUsername());
				return s;				
			}
		}
		return null;
	}
	
	

}
