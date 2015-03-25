package wol.dom.space;

import wol.dom.shape.StarShape;

public class Star extends Planet {
	private static final long serialVersionUID = 1L;

	public Star(double mass, double radius) {
        super(mass, radius, new StarShape(radius));
    }
}
