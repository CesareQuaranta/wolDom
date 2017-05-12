package edu.wol.dom.shape;

import edu.wol.dom.space.Position;

public class AsteroidShape implements iShape {

	@Override
	public boolean checkInterseption(Position position, iShape otherShape,
			Position otherPosition) {
		return false;
	}

}
