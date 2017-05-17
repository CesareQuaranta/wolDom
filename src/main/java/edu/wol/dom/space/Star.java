package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.Id;

import edu.wol.dom.shape.StarShape;
@Entity
public class Star extends Planetoid {
	private static final long serialVersionUID = 1L;

	public Star(double mass, double radius) {
        this(mass, radius, new StarShape(radius));
    }

	public Star(double mass, double radius, StarShape starShape) {
		this.mass=mass;
        this.radius=radius;
        this.shape=starShape;
	}

	@Override
	public int compareTo(Planetoid o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
