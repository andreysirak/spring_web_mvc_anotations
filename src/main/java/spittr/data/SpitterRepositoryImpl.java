package spittr.data;

import org.springframework.stereotype.Component;

import spittr.Spitter;

//no example in the book
@Component
public class SpitterRepositoryImpl implements SpitterRepository{

	@Override
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		return spitter;
		
	}

	@Override
	public Spitter findByUsername(String spitter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
