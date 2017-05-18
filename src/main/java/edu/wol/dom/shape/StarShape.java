package edu.wol.dom.shape;

import javax.persistence.Entity;

@Entity
public class StarShape extends SphericalShape {
	public StarShape() {
		super();
	}
	public StarShape(double radius) {
		super(radius);
	}

}
