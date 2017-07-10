package edu.wol.dom.space;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 05/10/11
 * Time: 23.49
 * To change this template use File | Settings | File Templates.
 */
public class Vector implements Comparable<Vector>,iCoordinate,Cloneable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5130651281630047189L;
	protected float x;
	protected float y;
	protected float z;

    public Vector(){
    	this(0,0,0);
    }
    public Vector(float x, float y, float z){
    	this.x=x;
    	this.y=y;
    	this.z=z;
    }
    
	public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

	public int getDimensions() {
		return 3;
	}
	
	public double getDistance(Position point){
		double rValue=0;
        double distX=x-point.x;
        double distY=y-point.y;
        double distZ=z-point.z;
		double sum=Math.pow(distX, 2)+Math.pow(distY, 2)+Math.pow(distZ, 2);
		rValue=Math.sqrt(sum);
		return rValue;
	}

	public float getLenght(){
		float rValue=0;
		Double sum=Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2);
		rValue=(float)Math.sqrt(sum);
		return rValue;
	}
	public void minimize(){
		float max=Math.max(Math.abs(x), Math.abs(y));
		max=Math.max(max, Math.abs(z));
		x=x/max;
		y=y/max;
		z=z/max;	
	}
	
	public Vector sum(Vector addend){
		return sum(addend,1);
	}
	
	public Vector sum(Vector addend,double d){
		return new Vector((float)(this.x+(addend.x*d)),(float)(this.y+(addend.y*d)),(float)(this.z+(addend.z*d)));
		
	}
	public Vector multiply(long multiplier){
		return new Vector(x*multiplier,y*multiplier,z*multiplier);
	}
    public Vector multiply(float multiplier){
        return new Vector(x*multiplier,y*multiplier,z*multiplier);
    }
    
    public Vector div(float divisor){
        return new Vector(x/divisor,y/divisor,z/divisor);
    }
    
	public Vector clone(){
		return new Vector(x,y,z);
	}

	public boolean equals(Object comp){
		if(comp instanceof Vector){
			return compareTo((Vector)comp)==0;
		}else{
			return false;
		}
		
	}
	public int compareTo(Vector comp) {//TODO Migliorare
		if(x==comp.x && y == comp.y && z == comp.z)
			return 0;
		else{
			if(y == comp.y && z == comp.z){
				return Float.compare(x, comp.x);
			}else if(x==comp.x && y == comp.y){
				return Float.compare(z, comp.z);
			}else if(x==comp.x && z == comp.z){
				return Float.compare(y, comp.y);
			}else if(x == comp.x){
				return Float.compare(y, comp.y);
			}else if(y == comp.y || z== comp.z){
				return Float.compare(x, comp.x);	
			}else{
				return Float.compare(x, comp.x);
			}
		}
	}
	public int hashCode(){
		return Objects.hash(x,y,z);
	}
	
	public boolean isEmpty(){
		return x==0 && y==0 && z==0;
	}
	
	public String toString(){
		return "v < x:"+String.format("%.2f",x)+" y:"+String.format("%.2f",y)+" z:"+String.format("%.2f",z)+" >";
	}

}
