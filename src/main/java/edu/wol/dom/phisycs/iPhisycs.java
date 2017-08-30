package edu.wol.dom.phisycs;


import java.io.Serializable;

import edu.wol.dom.WolEntity;
import edu.wol.dom.iEventGenerator;
import edu.wol.dom.iEventObserver;
import edu.wol.dom.space.Position;
import edu.wol.dom.space.Rotation;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.51.52
 * To change this template use File | Settings | File Templates.
 */
public interface iPhisycs<E extends WolEntity> extends iEventGenerator<E>,iEventObserver<E>,Runnable,Serializable{
    public void insert(E entity,Position coordinate);
    public void castAwayEntities(Position coordinate,long radius);//Cast away all entities in thre radius near the position
    //public Acceleration calcAcceleration(E entity,Collection<Force> forces);
    public void applyForce(E entity,Force force);
    public void removeForce(E entity,Force force);
    public Velocity getVelocity(E entity);
    public Rotation<E> getAngularVelocity(E entity);
}
