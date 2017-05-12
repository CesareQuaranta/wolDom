package edu.wol.dom.shape;

import edu.wol.dom.space.Position;

public class SphericalShape extends Shape {

	private double radius;
	
	public SphericalShape(double radius) {
		this.radius=radius;
	}

	@Override
	public boolean checkInterseption(Position position,Shape otherShape,Position otherPosition) {
		boolean collision=false;
		if(otherShape instanceof SphericalShape){
			double minDistance=radius+((SphericalShape)otherShape).radius;
			collision=collision|position.getDistance(otherPosition)<minDistance;
		}
		return collision;
	}

	public double getRadius() {
		return radius;
	}

}
