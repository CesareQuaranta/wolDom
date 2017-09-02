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
 * A 3-element vector that is represented by single-precision doubleing point
 * x,y,z coordinates.  If this value represents a normal, then it should
 * be normalized.
 */
public class Vector3d extends Tuple3d implements Comparable<Vector3d>,Serializable{
	
	/**
     * Constructs and initializes a Vector3d from the specified xyz coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Vector3d(double x, double y, double z){
    	 super(x,y,z);
    }
    
	
	 /**
     * Constructs and initializes a Vector3d from the array of length 3.
     * @param v the array of length 3 containing xyz in order
     */
    public Vector3d(double[] v)
    {
       super(v);
    }


    /**
     * Constructs and initializes a Vector3d from the specified Vector3d.
     * @param v1 the Vector3d containing the initialization x y z data
     */
    public Vector3d(Vector3d v1)
    {
       super(v1);
    }


    /**
     * Constructs and initializes a Vector3d from the specified Vector3d.
     * @param v1 the Vector3d containing the initialization x y z data
     *
    public Vector3d(Vector3d v1)
    {
       super(v1);
    }*/


    /**
     * Constructs and initializes a Vector3d from the specified Tuple3f.
     * @param t1 the Tuple3f containing the initialization x y z data
     */
    public Vector3d(Tuple3f t1) {
       super(t1);
    }


    /**
     * Constructs and initializes a Vector3d from the specified Tuple3d.
     * @param t1 the Tuple3d containing the initialization x y z data
     */
    public Vector3d(Tuple3d t1) {
       super(t1);
    }
    
    /**
     * Constructs and initializes a Vector3d to (0,0,0).
     */
    public Vector3d()
    {
        super();
    }
    
    /**
     * Returns the squared length of this vector.
     * @return the squared length of this vector
     */
    public final double lengthSquared()
    {
        return (this.x*this.x + this.y*this.y + this.z*this.z);
    }

    /**
     * Returns the length of this vector.
     * @return the length of this vector
     */
    public final double length()
    {
        return (double)
             Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
    }

	/**
	   * Computes the square of the distance between this point and
	   * point v1.
	   * @param v1 the other point
	   * @return  the square of the distance
	   */
	  public final double distanceSquared(Vector3d v1)
	    {
	      double dx, dy, dz;

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
	  public final double distance(Vector3d v1)
	    {
	      double  dx, dy, dz;

	      dx = this.x-v1.x;
	      dy = this.y-v1.y;
	      dz = this.z-v1.z;
	      return (double) Math.sqrt(dx*dx+dy*dy+dz*dz);
	    }


	  /**
	    * Computes the L-1 (Manhattan) distance between this point and
	    * point v1.  The L-1 distance is equal to:
	    *  abs(x1-x2) + abs(y1-y2) + abs(z1-z2).
	    * @param v1 the other point
	    * @return  the L-1 distance
	    */
	  public final double distanceL1(Vector3d v1)
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
	  public final double distanceLinf(Vector3d v1)
	    {
	       double tmp;
	       tmp = Math.max( Math.abs(this.x-v1.x), Math.abs(this.y-v1.y));
	       return(Math.max(tmp,Math.abs(this.z-v1.z)));

	    }
	  
	  /*
	   * Multiply in place this vector with multiplier vector return this for convenience
	   */
	  public Vector3d multiply(Vector3d multiplier){
		  	this.x *= multiplier.x;
		  	this.y *= multiplier.y;
		  	this.z *= multiplier.z;
	        return this;
	    }
	  
	  
  /**
     * Sets this vector to be the vector cross product of vectors v1 and v2.
     * @param v1 the first vector
     * @param v2 the second vector
     */
    public final void cross(Vector3d v1, Vector3d v2)
    {
        double x,y;

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
    public final double dot(Vector3d v1)
      {
        return (this.x*v1.x + this.y*v1.y + this.z*v1.z);
      }

     /**
       * Sets the value of this vector to the normalization of vector v1.
       * @param v1 the un-normalized vector
       */
      public final void normalize(Vector3d v1)
      {
          double norm;

          norm = (double) (1.0/Math.sqrt(v1.x*v1.x + v1.y*v1.y + v1.z*v1.z));
          this.x = v1.x*norm;
          this.y = v1.y*norm;
          this.z = v1.z*norm;
      }

      /**
       * Normalizes this vector in place.
       */
      public final void normalize()
      {
          double norm;

          norm = (double)
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
     public final double angle(Vector3d v1)
     {
        double vDot = this.dot(v1) / ( this.length()*v1.length() );
        if( vDot < -1.0) vDot = -1.0;
        if( vDot >  1.0) vDot =  1.0;
        return((double) (Math.acos( vDot )));
     }
     
	public void minimize(){
		double max=Math.max(Math.abs(x), Math.abs(y));
		max=Math.max(max, Math.abs(z));
		x=x/max;
		y=y/max;
		z=z/max;	
	}
	
	@Override
	public int compareTo(Vector3d comp) {//TODO Migliorare
		if(x==comp.x && y == comp.y && z == comp.z)
			return 0;
		else{
			if(y == comp.y && z == comp.z){
				return Double.compare(x, comp.x);
			}else if(x==comp.x && y == comp.y){
				return Double.compare(z, comp.z);
			}else if(x==comp.x && z == comp.z){
				return Double.compare(y, comp.y);
			}else if(x == comp.x){
				return Double.compare(y, comp.y);
			}else if(y == comp.y || z== comp.z){
				return Double.compare(x, comp.x);	
			}else{
				return Double.compare(x, comp.x);
			}
		}
	}

	@Override 
	public Vector3d clone(){
		return (Vector3d) super.clone();
	}
	
	@Override
	public String toString(){
		return "v < x:"+String.format("%.3d",x)+" y:"+String.format("%.3d",y)+" z:"+String.format("%.3d",z)+" >";
	}
	

}
