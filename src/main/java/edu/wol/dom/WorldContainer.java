package edu.wol.dom;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Transient;

import edu.wol.dom.phisycs.MassEntity;
import edu.wol.dom.phisycs.iPhisycs;
import edu.wol.dom.space.Space;
import edu.wol.dom.space.Tuple3f;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.50.16
 * To change this template use File | Settings | File Templates.
 */
@Entity
public abstract class WorldContainer<E extends WolEntity,V extends Tuple3f, S extends Space<E,V>, P extends iPhisycs<E>> extends MassEntity implements iEventObserver<E>,Runnable  {
	
	protected String nodeID;//Node identifier
	protected String wolID;//Wol identifier
	
	@Transient
	protected Collection<iEventObserver<E>> observers=new ArrayList<iEventObserver<E>>();
	

	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getWolID() {
		return wolID;
	}
	public void setWolID(String wolID) {
		this.wolID = wolID;
	}
	
	public abstract void init(float spacePrecision, float timePrecision);
	public abstract void insertEntity(V coordinate,E entity);
	public abstract void processEvent(iEvent event);
	public abstract void addEventObserver(iEventObserver<E> observer);
	public abstract S getSpace();
	public abstract P getPhisycs();
	public abstract boolean isEmpty();
	
}
