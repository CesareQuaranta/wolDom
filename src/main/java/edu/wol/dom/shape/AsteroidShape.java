package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import edu.wol.dom.space.Position;
import edu.wol.dom.space.Vector3f;

@Entity
public class AsteroidShape extends AbstractCustomShape {
	
	public AsteroidShape(){
		faces=new ArrayList<Triangle>();
	}
	
	@Override
	public boolean checkInterseption(Position position, Shape otherShape,
			Position otherPosition) {
		return false;
	}
	
}
