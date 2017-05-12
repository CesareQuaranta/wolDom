package edu.wol.dom.space;

import edu.wol.dom.shape.StarShape;

public class Star extends Planet {
	private static final long serialVersionUID = 1L;

	public Star(double mass, double radius) {
        super(mass, radius, new StarShape(radius));
    }
}
