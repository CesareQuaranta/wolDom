package edu.wol.dom.space;

import java.io.Serializable;
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
 * A 3-element vector that is represented by single-precision floating point
 * x,y,z coordinates.  If this value represents a normal, then it should
 * be normalized.
 */
public class Vector3f extends Tuple3f implements Comparable<Vector3f>,Serializable{

	private static final long serialVersionUID = 5708277775794648551L;
	
	/**
     * Constructs and initializes a Vector3f from the specified xyz coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Vector3f(float x, float y, float z){
    	 super(x,y,z);
    }
    
	
	 /**
     * Constructs and initializes a Vector3f from the array of length 3.
     * @param v the array of length 3 containing xyz in order
     */
    public Vector3f(float[] v)
    {
       super(v);
    }


    /**
     * Constructs and initializes a Vector3f from the specified Vector3f.
     * @param v1 the Vector3f containing the initialization x y z data
     */
    public Vector3f(Vector3f v1)
    {
       super(v1);
    }


    /**
     * Constructs and initializes a Vector3f from the specified Vector3d.
     * @param v1 the Vector3d containing the initialization x y z data
     *
    public Vector3f(Vector3d v1)
    {
       super(v1);
    }*/


    /**
     * Constructs and initializes a Vector3f from the specified Tuple3f.
     * @param t1 the Tuple3f containing the initialization x y z data
     */
    public Vector3f(Tuple3f t1) {
       super(t1);
    }


    /**
     * Constructs and initializes a Vector3f from the specified Tuple3d.
     * @param t1 the Tuple3d containing the initialization x y z data
     */
    public Vector3f(Tuple3d t1) {
       super(t1);
    }
    
    /**
     * Constructs and initializes a Vector3f to (0,0,0).
     */
    public Vector3f()
    {
        super();
    }
    
    /**
     * Returns the squared length of this vector.
     * @return the squared length of this vector
     */
    public final float lengthSquared()
    {
        return (this.x*this.x + this.y*this.y + this.z*this.z);
    }

    /**
     * Returns the length of this vector.
     * @return the length of this vector
     */
    public final float length()
    {
        return (float)
             Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
    }

	/**
	   * Computes the square of the distance between this point and
	   * point v1.
	   * @param v1 the other point
	   * @return  the square of the distance
	   */
	  public final float distanceSquared(Vector3f v1)
	    {
	      float dx, dy, dz;

	      dx = this.x-v1.x;
	      dy = this.y-v1.y;
	      dz = this.z-v1.z;
	      return dx*dx+dy*dy+dz*dz;
	    }


	  /**
	   * Computes the distance between this point and point v1.
	   * @param v1 the other point
	   * @return the distance
	   */
	  public final float distance(Vector3f v1)
	    {
	      float  dx, dy, dz;

	      dx = this.x-v1.x;
	      dy = this.y-v1.y;
	      dz = this.z-v1.z;
	      return (float) Math.sqrt(dx*dx+dy*dy+dz*dz);
	    }


	  /**
	    * Computes the L-1 (Manhattan) distance between this point and
	    * point v1.  The L-1 distance is equal to:
	    *  abs(x1-x2) + abs(y1-y2) + abs(z1-z2).
	    * @param v1 the other point
	    * @return  the L-1 distance
	    */
	  public final float distanceL1(Vector3f v1)
	    {
	       return( Math.abs(this.x-v1.x) + Math.abs(this.y-v1.y) + Math.abs(this.z-v1.z));
	    }


	  /**
	    * Computes the L-infinite distance between this point and
	    * point p1.  The L-infinite distance is equal to
	    * MAX[abs(x1-x2), abs(y1-y2), abs(z1-z2)].
	    * @param p1 the other point
	    * @return  the L-infinite distance
	    */
	  public final float distanceLinf(Vector3f v1)
	    {
	       float tmp;
	       tmp = Math.max( Math.abs(this.x-v1.x), Math.abs(this.y-v1.y));
	       return(Math.max(tmp,Math.abs(this.z-v1.z)));

	    }
  /**
     * Sets this vector to be the vector cross product of vectors v1 and v2.
     * @param v1 the first vector
     * @param v2 the second vector
     */
    public final void cross(Vector3f v1, Vector3f v2)
    {
        float x,y;

        x = v1.y*v2.z - v1.z*v2.y;
        y = v2.x*v1.z - v2.z*v1.x;
        this.z = v1.x*v2.y - v1.y*v2.x;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Computes the dot product of this vector and vector v1.
     * @param v1 the other vector
     * @return the dot product of this vector and v1
     */
    public final float dot(Vector3f v1)
      {
        return (this.x*v1.x + this.y*v1.y + this.z*v1.z);
      }

     /**
       * Sets the value of this vector to the normalization of vector v1.
       * @param v1 the un-normalized vector
       */
      public final void normalize(Vector3f v1)
      {
          float norm;

          norm = (float) (1.0/Math.sqrt(v1.x*v1.x + v1.y*v1.y + v1.z*v1.z));
          this.x = v1.x*norm;
          this.y = v1.y*norm;
          this.z = v1.z*norm;
      }

      /**
       * Normalizes this vector in place.
       */
      public final void normalize()
      {
          float norm;

          norm = (float)
                 (1.0/Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z));
          this.x *= norm;
          this.y *= norm;
          this.z *= norm;
      }


    /**
      *   Returns the angle in radians between this vector and the vector
      *   parameter; the return value is constrained to the range [0,PI].
      *   @param v1    the other vector
      *   @return   the angle in radians in the range [0,PI]
      */
     public final float angle(Vector3f v1)
     {
        double vDot = this.dot(v1) / ( this.length()*v1.length() );
        if( vDot < -1.0) vDot = -1.0;
        if( vDot >  1.0) vDot =  1.0;
        return((float) (Math.acos( vDot )));
     }
     
	public void minimize(){
		float max=Math.max(Math.abs(x), Math.abs(y));
		max=Math.max(max, Math.abs(z));
		x=x/max;
		y=y/max;
		z=z/max;	
	}
	/*Deprecated
	public Vector3f sum(Vector3f addend){
		return sum(addend,1);
	}
	
	public Vector3f sum(Vector3f addend,double d){
		return new Vector3f((float)(this.x+(addend.x*d)),(float)(this.y+(addend.y*d)),(float)(this.z+(addend.z*d)));
		
	}
	public Vector3f multiply(long multiplier){
		return new Vector3f(x*multiplier,y*multiplier,z*multiplier);
	}
    public Vector3f multiply(float multiplier){
        return new Vector3f(x*multiplier,y*multiplier,z*multiplier);
    }
    
    public Vector3f div(float divisor){
        return new Vector3f(x/divisor,y/divisor,z/divisor);
    }
*/
	
	@Override
	public int compareTo(Vector3f comp) {//TODO Migliorare
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
	/*
	@Override
	public int hashCode(){
		return Objects.hash(x,y,z);
	}
	@Override
	public boolean equals(Object comp){
		if(comp instanceof Vector3f){
			return compareTo((Vector3f)comp)==0;
		}else{
			return false;
		}
		
	}
	*/
	@Override 
	public Vector3f clone(){
		return (Vector3f) super.clone();
	}
	
	@Override
	public String toString(){
		return "v < x:"+String.format("%.3f",x)+" y:"+String.format("%.3f",y)+" z:"+String.format("%.3f",z)+" >";
	}

}
