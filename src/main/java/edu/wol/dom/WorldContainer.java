package edu.wol.dom;

import javax.persistence.Entity;

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
	public abstract void init(float spacePrecision, float timePrecision);
	public abstract void processEvent(iEvent event);
	public abstract Space<E,C> getSpace();
	public abstract boolean isEmpty();
}
