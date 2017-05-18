package edu.wol.dom.space;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

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
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Space<E extends WolEntity,C extends iCoordinate> implements iEventGenerator<E>,iEventObserver<E>,Serializable{
	@Id
	@GeneratedValue
	private long ID;
	
	public abstract E getEntity(C position);
    public abstract Collection<E> getAllEntities();
    public abstract C getPosition(E entity);//?? necessaria??
    public abstract boolean process(Movement<E> movement);
    public abstract void addObserver(iEventObserver<E> observer);
    public abstract boolean insertEntity(C coordinate,E entity);
    public abstract void insertForceFactory(ForceFactory f);
    public abstract boolean isEmpty();
    //public Collection<Force> getAllForces(E entity);
}
