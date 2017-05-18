package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import edu.wol.dom.phisycs.MassEntity;
import edu.wol.dom.shape.Shape;
@Entity
public class Planetoid extends MassEntity implements Comparable<Planetoid>{
    protected double radius;
    @Transient//FIXME
    protected Shape shape;
    
	public double getRadius(){
		return radius;
	}
    public Shape getShape(){
    	return shape;
    }
	@Override
	public int compareTo(Planetoid o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
