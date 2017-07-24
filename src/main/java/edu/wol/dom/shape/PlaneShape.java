package edu.wol.dom.shape;

import java.util.ArrayList;

import edu.wol.dom.space.Position;

public class PlaneShape extends AbstractCustomShape {

	
	public PlaneShape(){
		faces=new ArrayList<Triangle>();
	}
	
	@Override
	boolean checkInterseption(Position position, Shape otherShape,
			Position otherPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
