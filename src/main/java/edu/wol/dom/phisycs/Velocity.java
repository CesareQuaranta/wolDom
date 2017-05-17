package edu.wol.dom.phisycs;

import javax.persistence.Entity;

import edu.wol.dom.Power;
import edu.wol.dom.iAction;
import edu.wol.dom.iLatentEffect;
import edu.wol.dom.space.Vector;
@Entity
public class Velocity extends Power implements iAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8543988811101335479L;
	protected Vector vector;
	protected float time;
	
	private Velocity() {
		super();
		time=0;
		this.vector = new Vector();
	}
	public Velocity(float time) {
		super();
		this.time=time;
		this.vector = new Vector();
	}
	
	public Velocity(Vector vector) {
		this(1,vector);
	}
	
	public Velocity(float time,Vector vector) {
		this.time=time;
		this.vector=vector;
	}
	
	public Velocity(float time,float x,float y,float z) {
		this.vector = new Vector(x,y,z);
		this.time=time;
	}
	protected void copy(Velocity source){
		this.vector = source.vector.clone();
		this.time=source.time;
		
	}

	public float getTime() {
		return time;
	}
	
	public Vector getVector() {
		return vector;
	}
	
	public Velocity getMinimized4Space(){
		
		float max=Math.max(Math.abs(this.vector.getX()), Math.abs(this.vector.getY()));
		max=Math.max(max, Math.abs(this.vector.getZ()));
		float minX=this.vector.getX()/max;
		float minY=this.vector.getY()/max;
		float minZ=this.vector.getZ()/max;
		float minT=time/max;
		Velocity minimized=new Velocity(minX,minY,minZ,minT);
		return minimized;
	}
	
	public Velocity getMaximized4Time(){
		
		if(time>0 && time<1){
			Velocity maximized=new Velocity(1/time,this.vector.div(time));
			return maximized;
		}
		return clone();
	}
	public Velocity sum(Velocity addend){
		if(this.vector.isEmpty() && addend!=null){
			return addend.clone();
		}else if (!addend.vector.isEmpty()){
			Velocity result=getMaximized4Time();;
			Velocity resultAddend=addend.getMaximized4Time();
			result.time*=resultAddend.time;
			return result.sum(resultAddend);
		}else 
			return new Velocity();
	}
	
	public float getIntensity(){
		return(time*this.vector.getLenght());
	}
	
	public Velocity clone(){
		return new Velocity(time,this.vector);
	}
	
	public boolean isEmpty() {
		return this.vector.isEmpty();
	}

}
