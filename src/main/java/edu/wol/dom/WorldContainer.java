package edu.wol.dom;

import java.io.Serializable;

import edu.wol.dom.space.iCoordinate;
import edu.wol.dom.space.iSpace;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.50.16
 * To change this template use File | Settings | File Templates.
 */
public interface WorldContainer<E extends WolEntity,C extends iCoordinate> extends iEventObserver<E>,Runnable, Serializable {
	public void init(float spacePrecision, float timePrecision);
	public void processEvent(iEvent event);
	public iSpace<E,C> getSpace();
}