package edu.wol.dom.phisycs;

import java.util.Collection;

import edu.wol.dom.WolEntity;
import edu.wol.dom.iExternalCause;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 07/10/11
 * Time: 0.19
 * To change this template use File | Settings | File Templates.
 */
public class Forces<E extends WolEntity> implements iExternalCause<E>{
	private static final long serialVersionUID = 1L;
	private Collection<Force> forces;

    public Forces(Collection<Force> forces){
        this.forces=forces;
    }

	public Collection<Force> getForces() {
		return forces;
	}
}
