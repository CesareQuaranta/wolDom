package edu.wol.dom.shape;

import javax.persistence.Entity;
import javax.persistence.Id;

import edu.wol.dom.space.Position;

@Entity
public class AsteroidShape extends Shape {
	
	protected String vertex;
	
	@Override
	public boolean checkInterseption(Position position, Shape otherShape,
			Position otherPosition) {
		return false;
	}

}
