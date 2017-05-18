package edu.wol.dom.shape;

import javax.persistence.Entity;

@Entity
public class PlanetShape extends SphericalShape {

	public PlanetShape(double radius) {
		super(radius);
	}


}
