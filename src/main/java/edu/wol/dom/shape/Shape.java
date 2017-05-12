package edu.wol.dom.shape;

import edu.wol.dom.space.Position;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 06/10/11
 * Time: 23.53
 * To change this template use File | Settings | File Templates.
 */
public abstract class Shape {
	abstract boolean checkInterseption(Position position,Shape otherShape,Position otherPosition);
}
