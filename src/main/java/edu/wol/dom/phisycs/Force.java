package edu.wol.dom.phisycs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import edu.wol.dom.Power;
import edu.wol.dom.space.Vector;

@Entity
public class Force extends Power{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2732542351134968687L;
	@Id
	@GeneratedValue
	private long ID;
	
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
			newAcceleration=acceleration.sum(force.acceleration);
		}else{
			newAcceleration=acceleration.sum(force.acceleration,force.mass/mass);
		}
		double sumComponent=newAcceleration.getComponentsSum();//TODO Rinominare
		
		//TODO Da spostare in acceleration
		double massX=Math.abs(newAcceleration.getVector().getX()==0?0:((mass*acceleration.getVector().getX())+(force.mass*force.acceleration.getVector().getX()))/sumComponent);
		double massY=Math.abs(newAcceleration.getVector().getY()==0?0:((mass*acceleration.getVector().getY())+(force.mass*force.acceleration.getVector().getY()))/sumComponent);
		double massZ=Math.abs(newAcceleration.getVector().getZ()==0?0:((mass*acceleration.getVector().getZ())+(force.mass*force.acceleration.getVector().getZ()))/sumComponent);
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
		return "F "+mass*acceleration.getVector().getLenght()+"N";
	}

}
