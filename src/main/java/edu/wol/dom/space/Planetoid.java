package edu.wol.dom.space;

import edu.wol.dom.phisycs.MassEntity;
import edu.wol.dom.shape.Shape;

public abstract class Planetoid extends MassEntity implements Comparable<Planetoid>{
    protected double radius;
    protected Shape shape;
	public double getRadius(){
		return radius;
	}
    public Shape getShape(){
    	return shape;
    }
}
