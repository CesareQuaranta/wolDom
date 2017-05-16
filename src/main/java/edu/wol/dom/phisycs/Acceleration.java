package edu.wol.dom.phisycs;

import javax.persistence.Entity;

import edu.wol.dom.Power;
import edu.wol.dom.space.Vector;

@Entity
public class Acceleration extends Power  {
	private static final long serialVersionUID = -8543988811101335479L;
	private Velocity velocity;
	public Acceleration() {
		this.velocity=new Velocity(0);
	}
	
	public Acceleration(float x, float y, float z) {
		this.velocity=new Velocity(1,x,y,z);
	}

	public Acceleration(Vector vector) {
		this(1, vector);
	}
	public Acceleration(float time, Vector vector) {
		this.velocity=new Velocity(time, vector);
	}
	
	
	public Acceleration clone(){
		return new Acceleration(this.velocity.time,this.velocity);
	}

	public boolean isEmpty() {
		return this.velocity.isEmpty();
	}

	public Double getLenght() {
		return (double) this.velocity.getLenght();
	}

	public Vector sum(Acceleration acceleration) {
		return this.velocity.sum(acceleration.velocity);
	}

	public Vector sum(Acceleration acceleration, double d) {
		return this.velocity.sum(acceleration.velocity,d);
	}
	
	public double getComponentsSum(){
		return Math.abs(this.velocity.getX())+Math.abs(this.velocity.getY())+Math.abs(this.velocity.getZ());
	}

	public float getX() {
		return this.velocity.getX();
	}
	
	public float getY() {
		return this.velocity.getY();
	}
	
	public float getZ() {
		return this.velocity.getZ();
	}
	

}
