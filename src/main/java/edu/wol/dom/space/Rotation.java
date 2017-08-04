package edu.wol.dom.space;

import edu.wol.dom.Effect;
import edu.wol.dom.WolEntity;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 07/10/11
 * Time: 0.20
 * Rappresenta rotazione uniforme di x radianti attorno ad un asse dato in una singola unità temporale
 */

public class Rotation<E extends WolEntity> extends Effect<E> {
	private static final long serialVersionUID = -3053579265734463310L;
	private Vector3f axis;
	private double radians;
	
	private Rotation(){
    	super(null);
        this.axis=null;
        this.radians=0;
    }
	
    public Rotation(E entity,Vector3f axis,double radians){
    	super(entity);
        this.axis=axis;
        this.radians=radians;
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

}
