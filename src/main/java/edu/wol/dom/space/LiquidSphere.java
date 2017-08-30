package edu.wol.dom.space;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import edu.wol.dom.shape.SphericalShape;

@Entity
public class LiquidSphere extends Planetoid {
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private SphericalShape persistenceShape;
	
	protected LiquidSphere(){
        this.mass=0;
        this.radius=0;
        this.shape = null;
        
    }
    
    public LiquidSphere(Collection<String> materia,double mass,double radius){
    	this.materia=new ArrayList<String>(materia);
        this.mass=mass;
        this.radius=radius;
        setShape(new SphericalShape(radius));
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    private void setShape(SphericalShape shape){
    	this.shape = shape;
    	this.persistenceShape = shape;
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
		return "Liquid Sphere:{ id:" + ID + ", mass:"
				+ mass + ", radius:" + radius + "}";
	}
}
