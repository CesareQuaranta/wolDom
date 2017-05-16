package edu.wol.dom.phisycs;

import javax.persistence.Entity;

import edu.wol.dom.Power;
import edu.wol.dom.space.Vector;

@Entity
public class Force extends Power{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2732542351134968687L;
	protected Double mass;
	protected Acceleration acceleration;
	
	public Force() {
		this(0D,new Acceleration());
	}
	
	public Force(Double mass) {
		this(mass,new Acceleration());
	}
	public Force(Double mass, Acceleration acceleration) {
		super();
		this.mass = mass;
		this.acceleration = acceleration;
	}

	public void sum(Force force){//TODO da veriicare con casistiche note
		Acceleration newAcceleration=null;
		if(this.isEmpty() || force.isEmpty()){
			newAcceleration=new Acceleration(acceleration.sum(force.acceleration));
		}else{
			newAcceleration=new Acceleration(acceleration.sum(force.acceleration,force.mass/mass));
		}
		double sumComponent=newAcceleration.getComponentsSum();//TODO Rinominare
		double massX=Math.abs(newAcceleration.getX()==0?0:((mass*acceleration.getX())+(force.mass*force.acceleration.getX()))/sumComponent);
		double massY=Math.abs(newAcceleration.getY()==0?0:((mass*acceleration.getY())+(force.mass*force.acceleration.getY()))/sumComponent);
		double massZ=Math.abs(newAcceleration.getZ()==0?0:((mass*acceleration.getZ())+(force.mass*force.acceleration.getZ()))/sumComponent);
		mass=massX+massY+massZ;
		acceleration=newAcceleration;
	}


	public Double getMass() {
		return mass;
	}


	public void setMass(Double mass) {
		this.mass = mass;
	}


	public Acceleration getAcceleration() {
		return acceleration;
	}


	public void setAcceleration(Acceleration acceleration) {
		this.acceleration = acceleration;
	}
	
	public boolean isEmpty(){
		return acceleration.isEmpty() || mass==0;
		
	}

	@Override
	public String toString() {
		return "F "+mass*acceleration.getLenght()+"N";
	}

}
