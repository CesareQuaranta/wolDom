package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 05/10/11
 * Time: 23.49
 * Persistent vector
 */
@Entity
public class Position extends Vector3f {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5130651281630047189L;
	@Id
	@GeneratedValue
	private long ID;
	
	
    public Position(){
    	super();
    }
    public Position(float x, float y, float z){
    	super(x,y,z);
    }
	
	public Position(Vector3f v) {
		super(v);
	}
	public BigVector distanceVector(Position point){
        double distX=x-point.x;
        double distY=y-point.y;
        double distZ=z-point.z;
		return new BigVector(distX,distY,distZ);
	}

	public Position clone(){
		return (Position) super.clone();
	}
/*
	public Vector3f getDirectionVector(Position point){
		BigVector result=getDistanceVector(point);
		return result.minimize();
	}
	public void sum(Vector3f addend) {
		double xFractionSum=addend.x+fx;
		fx=xFractionSum-Math.round(xFractionSum);
		x+=Math.round(xFractionSum);
		
		double yFractionSum=addend.y+fy;
		fy=yFractionSum-Math.round(yFractionSum);
		y+=Math.round(yFractionSum);
		
		double zFractionSum=addend.z+fz;
		fz=zFractionSum-Math.round(zFractionSum);
		z+=Math.round(zFractionSum);
	}
	public boolean equals(Position comp){
		return compareTo(comp)==0;
	}
	public int compareTo(Position comp) {
		if(x==comp.x && y==comp.y && z==comp.z){
			return 0;
		}else 
			return new Float(getLenght()).compareTo(comp.getLenght());
	}*/
	public static Position  parse(String serializedPosition) {
		String[] components=serializedPosition.split(":");
		//return new Position(Long.parseLong(components[0]),Long.parseLong(components[1]),Long.parseLong(components[2]));
		return new Position(Float.parseFloat(components[0]),Float.parseFloat(components[1]),Float.parseFloat(components[2]));
	}
	
	public String toString(){
		return "x:"+x+" y:"+y+" z:"+z;
	}
	
	public String serialize(){
		return String.valueOf(x)+":"+String.valueOf(y)+":"+String.valueOf(z);
	}
	

}
