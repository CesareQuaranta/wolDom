package edu.wol.dom.space;

import java.io.Serializable;
import java.util.Collection;

import edu.wol.dom.WolEntity;
import edu.wol.dom.iEventGenerator;
import edu.wol.dom.iEventObserver;
import edu.wol.dom.phisycs.Force;
import edu.wol.dom.phisycs.ForceFactory;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.53.19
 * To change this template use File | Settings | File Templates.
 */
public interface iSpace<E extends WolEntity,C extends iCoordinate> extends iEventGenerator<E>,iEventObserver<E>,Serializable{
    public E getEntity(C position);
    public Collection<E> getAllEntities();
    public C getPosition(E entity);//?? necessaria??
    public boolean process(Movement<E> movement);
    public void addObserver(iEventObserver<E> observer);
    public boolean insertEntity(C coordinate,E entity);
    public void insertForceFactory(ForceFactory f);
    //public Collection<Force> getAllForces(E entity);
}
