package edu.wol.dom.phisycs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import edu.wol.dom.WolEntity;
import edu.wol.dom.ExternalCause;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 07/10/11
 * Time: 0.19
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Forces<E extends WolEntity> extends ExternalCause<E> implements Iterable<Force>{

	private static final long serialVersionUID = -3071172948426998469L;
	@Id
	@GeneratedValue
	private long ID;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Collection<Force> forces;

	public Forces(){
		forces=new ArrayList<Force>();
	}
	
    public Forces(Collection<Force> forces){
        this.forces=forces;
    }

	public Collection<Force> getForces() {
		return forces;
	}
	public boolean isEmpty() {
		return this.forces==null ||this.forces.isEmpty();
	}

	@Override
	public Iterator<Force> iterator() {
		return this.forces.iterator();
	}

	public boolean add(Force e) {
		return this.forces.add(e);
	}

	public boolean remove(Force e) {
		return this.forces.remove(e);
	}
}
