package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.InheritanceType;

import edu.wol.dom.shape.AsteroidShape;
import edu.wol.dom.shape.Shape;

@Entity
public class Asteroid extends Planetoid {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long ID;


    //@OneToOne(fetch=FetchType.LAZY, targetEntity=AsteroidShape.class)
	//@JoinColumn(name="SHAPE_ID")


    public Asteroid(double mass,double radius){
        this(mass,radius,new AsteroidShape());
        
    }
    
    protected Asteroid(double mass,double radius,AsteroidShape shape){
        this.mass=mass;
        this.radius=radius;
        this.shape=shape;
        
    }


    public Shape getShape() {
        return shape;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setShape(AsteroidShape shape) {
        this.shape = shape;
    }

    public double getRadius() {
        return radius;

    }


    public int compareTo(Planetoid o) {
    	if(o==null){
    		return -1;
    	}else{
    		if( this == o)
    			return 0;
    	}
		return -1;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public void setMass(double mass) {
        this.mass=mass;

    }

	@Override
	public String toString() {
		return "Asteroid:{ id:" + ID + ", mass:"
				+ mass + ", radius:" + radius + "}";
	}
}
