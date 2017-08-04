package edu.wol.dom.space;

import edu.wol.dom.Effect;
import edu.wol.dom.WolEntity;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 07/10/11
 * Time: 0.20
 * Rappresenta rotazione uniforme di n radianti attorno ad un asse dato in una data quantità temporale
 */

public class Rotation<E extends WolEntity> extends Effect<E> {
	private static final long serialVersionUID = -3053579265734463310L;
	private Vector3f axis;
	private double radians;
	private long time;
	
	private Rotation(){
    	super(null);
        this.axis=null;
        this.radians=0;
        this.time=1000;//1 secondo
    }
	public Rotation(E entity,Vector3f axis,double radians){
		this(entity,axis,radians,1000);//default rotazione al secondo
	}
	
    public Rotation(E entity,Vector3f axis,double radians,long time){
    	super(entity);
        this.axis=axis;
        this.radians=radians;
        this.time=time;
    }
    
	public Vector3f getAxis() {
		return axis;
	}

	public void setAxis(Vector3f axis) {
		this.axis = axis;
	}

	public double getRadians() {
		return radians;
	}

	public void setRadians(double radians) {
		this.radians = radians;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}

}
