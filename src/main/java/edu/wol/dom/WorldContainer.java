package edu.wol.dom;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Transient;

import edu.wol.dom.phisycs.MassEntity;
import edu.wol.dom.space.Space;
import edu.wol.dom.space.iCoordinate;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.50.16
 * To change this template use File | Settings | File Templates.
 */
@Entity
public abstract class WorldContainer<E extends WolEntity,C extends iCoordinate> extends MassEntity implements iEventObserver<E>,Runnable  {
	@Transient
	protected Collection<iEventObserver<E>> observers=new ArrayList<iEventObserver<E>>();
	public abstract void init(float spacePrecision, float timePrecision);
	public abstract void insertEntity(C coordinate,E entity);
	public abstract void processEvent(iEvent event);
	public abstract void addEventObserver(iEventObserver<E> observer);
	public abstract Space<E,C> getSpace();
	public abstract boolean isEmpty();
}
