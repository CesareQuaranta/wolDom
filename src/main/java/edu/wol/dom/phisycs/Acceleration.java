package edu.wol.dom.phisycs;

import javax.persistence.Entity;

import edu.wol.dom.Power;
import edu.wol.dom.space.Vector3f;

@Entity
public class Acceleration extends Velocity  {
	private static final long serialVersionUID = -8543988811101335479L;
	public Acceleration() {
		super(0);
	}
	
	public Acceleration(float x, float y, float z) {
		super(1,x,y,z);
	}

	public Acceleration(Vector3f vector) {
		this(1, vector);
	}
	public Acceleration(float time, Vector3f vector) {
		super(time, vector);
	}
	
	public double getComponentsSum(){
		return Math.abs(this.vector.getX())+Math.abs(this.vector.getY())+Math.abs(this.vector.getZ());
	}
	public Acceleration sum(Acceleration addend){
		if(this.vector.isEmpty() && addend!=null){
			return addend.clone();
		}else if (!addend.vector.isEmpty()){
			Acceleration result=(Acceleration) getMaximized4Time();;
			Acceleration resultAddend=(Acceleration) addend.getMaximized4Time();
			result.time*=resultAddend.time;
			return result.sum(resultAddend);
		}else 
			return new Acceleration();
	}
	public Acceleration clone(){
		return new Acceleration(time,this.vector);
	}

	public Acceleration sum(Acceleration acceleration, double d) {
		Vector3f vA=this.vector.clone();
		vA.scaleAdd((float)d,acceleration.vector);
		return new Acceleration(this.time,vA);
	}
}
