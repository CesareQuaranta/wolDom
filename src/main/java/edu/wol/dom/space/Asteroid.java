package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.Id;

import edu.wol.dom.shape.AsteroidShape;
import edu.wol.dom.shape.iShape;

@Entity
public class Asteroid implements iPlanetoid {
	private static final long serialVersionUID = 1L;
	
	@Id
	protected String UID;
    protected double mass;
    protected double radius;


    protected iShape shape;


    public Asteroid(double mass,double radius){
        this(mass,radius,new AsteroidShape());
        
    }
    
    protected Asteroid(double mass,double radius,iShape shape){
    	UID=String.valueOf(System.currentTimeMillis());
        this.mass=mass;
        this.radius=radius;
        this.shape=shape;
        
    }


    public iShape getShape() {
        return shape;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setShape(iShape shape) {
        this.shape = shape;
    }

    @Override
    public String getUID() {
        return UID;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public double getRadius() {
        return radius;

    }


    public int compareTo(iPlanetoid o) {
    	if(o==null){
    		return -1;
    	}else{
    		return this.UID.compareTo(o.getUID());
    	}
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
		return "Asteroid:{ id:" + UID + ", mass:"
				+ mass + ", radius:" + radius + "}";
	}
}
