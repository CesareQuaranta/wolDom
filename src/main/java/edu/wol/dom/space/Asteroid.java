package edu.wol.dom.space;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
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


    //@OneToOne(fetch=FetchType.LAZY, targetEntity=AsteroidShape.class)
	//@JoinColumn(name="SHAPE_ID")
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private AsteroidShape persistenceShape;
	
	protected Asteroid(){
        this.mass=0;
        this.radius=0;
        this.setShape(null);
        
    }
    public Asteroid(Collection<String> materia,double mass,double radius){
        this(materia,mass,radius,new AsteroidShape());
        
    }
    
    protected Asteroid(Collection<String> materia,double mass,double radius,AsteroidShape shape){
    	this.materia=new ArrayList<String>(materia);
        this.mass=mass;
        this.radius=radius;
        this.setShape(shape);
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setShape(AsteroidShape shape) {
        this.shape = shape;
        this.persistenceShape=shape;
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
