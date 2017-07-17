package edu.wol.dom.space;

import javax.persistence.Entity;

import edu.wol.dom.Effect;
import edu.wol.dom.WolEntity;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 07/10/11
 * Time: 0.20
 * Rappresenta un moto regalare uniforme
 */
@Entity
public class Movement<E extends WolEntity> extends Effect<E> {
	private static final long serialVersionUID = -3053579265734463310L;
	private Vector3f vector;
	
	private Movement(){
    	super(null);
        this.vector=null;
    }
	
    public Movement(E entity,Vector3f vector){
    	super(entity);
        this.vector=vector;
    }
    
	public Vector3f getVector() {
		return vector;
	}

	public void setVector(Vector3f vector) {
		this.vector = vector;
	}

}
