package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import edu.wol.dom.Karma;
import edu.wol.dom.shape.PlanetShape;
import edu.wol.dom.shape.Shape;
@Entity
public class Planet extends Planetoid {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	protected Karma karma;


    public Planet(double mass,double radius){
        this(mass,radius,new PlanetShape(radius));
        
    }
    
    protected Planet(double mass,double radius,PlanetShape shape){
        this.mass=mass;
        this.radius=radius;
        this.shape=shape;
        karma=new Karma();
        
    }


    public Shape getShape() {
        return shape;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getRadius() {
        return radius;

    }

    public int compareTo(Planetoid o) {
    	if(o==null){
    		return -1;
    	}else if (this == o){
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
/*
	@Override
	public Karma<Planet> getKarma() {
		// TODO Auto-generated method stub
		return karma;
	}*/

	@Override
	public String toString() {
		return "Planet [" + ID + ", mass="
				+ mass + ", radius=" + radius + "]";
	}
}
