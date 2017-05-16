package edu.wol.dom;

import java.io.Serializable;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import edu.wol.dom.space.iCoordinate;
import edu.wol.dom.space.iSpace;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.50.16
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class WorldContainer<E extends WolEntity,C extends iCoordinate> implements iEventObserver<E>,Runnable, Serializable {
	public abstract void init(float spacePrecision, float timePrecision);
	public abstract void processEvent(iEvent event);
	public abstract iSpace<E,C> getSpace();
}
