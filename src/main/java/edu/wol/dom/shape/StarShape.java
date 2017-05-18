package edu.wol.dom.shape;

import javax.persistence.Entity;

@Entity
public class StarShape extends SphericalShape {

	public StarShape(double radius) {
		super(radius);
	}

}
