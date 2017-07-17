package edu.wol.dom;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Transient;

import edu.wol.dom.phisycs.MassEntity;
import edu.wol.dom.phisycs.iPhisycs;
import edu.wol.dom.space.Space;
import edu.wol.dom.space.Tuple3f;
import edu.wol.dom.space.iCoordinate;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.50.16
 * To change this template use File | Settings | File Templates.
 */
@Entity
public abstract class WorldContainer<E extends WolEntity,V extends Tuple3f> extends MassEntity implements iEventObserver<E>,Runnable  {
	
	protected String nodeID;//Node identifier
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	
	@Transient
	protected Collection<iEventObserver<E>> observers=new ArrayList<iEventObserver<E>>();
	public abstract void init(float spacePrecision, float timePrecision);
	public abstract void insertEntity(V coordinate,E entity);
	public abstract void processEvent(iEvent event);
	public abstract void addEventObserver(iEventObserver<E> observer);
	public abstract Space<E,V> getSpace();
	public abstract iPhisycs<E> getPhisycs();
	public abstract boolean isEmpty();
	
}
