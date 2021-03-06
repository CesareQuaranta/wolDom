package edu.wol.dom.phisycs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import edu.wol.dom.Action;
import edu.wol.dom.space.Vector3f;
@Entity
public class Velocity extends Action{
	private static final long serialVersionUID = -8543988811101335479L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long ID;
	@Lob
	protected Vector3f vector;
	protected long time;
	
	private Velocity() {
		super();
		time=0;
		this.vector = new Vector3f();
	}
	public Velocity(long time) {
		super();
		this.time=time;
		this.vector = new Vector3f();
	}
	
	public Velocity(Vector3f vector) {
		this(1,vector);
	}
	
	public Velocity(long time,Vector3f vector) {
		this.time=time;
		this.vector=vector;
	}
	
	public Velocity(long time,float x,float y,float z) {
		this.vector = new Vector3f(x,y,z);
		this.time=time;
	}
	protected void copy(Velocity source){
		this.vector = source.vector.clone();
		this.time=source.time;
		
	}

	public long getTime() {
		return time;
	}
	
	public Vector3f getVector() {
		return vector;
	}
	
	public Velocity getMinimized4Space(){
		
		float max=Math.max(Math.abs(this.vector.getX()), Math.abs(this.vector.getY()));
		max=Math.max(max, Math.abs(this.vector.getZ()));
		float minX=this.vector.getX()/max;
		float minY=this.vector.getY()/max;
		float minZ=this.vector.getZ()/max;
		long minT=Math.round(time/max);
		Velocity minimized=new Velocity(minT,minX,minY,minZ);
		return minimized;
	}
	
	public Velocity getMaximized4Time(){
		
		if(time>0 && time<1){
			Vector3f v=this.vector.clone();
			v.scale(time);
			Velocity maximized=new Velocity(1/time,v);
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
			result.vector.add(addend.vector);
			return result;
		}else 
			return new Velocity();
	}
	
	public float getIntensity(){
		return(time*this.vector.length());
	}
	
	public Velocity clone(){
		return new Velocity(time,this.vector);
	}
	
	public boolean isEmpty() {
		return this.vector.isEmpty();
	}

}
