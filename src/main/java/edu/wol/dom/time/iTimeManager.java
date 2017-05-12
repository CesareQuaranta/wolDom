package edu.wol.dom.time;

import java.io.Serializable;
import java.util.List;

import edu.wol.dom.WolEntity;
import edu.wol.dom.iEventGenerator;
import edu.wol.dom.iEventObserver;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.51.26
 * To change this template use File | Settings | File Templates.
 */
public interface iTimeManager<E extends WolEntity> extends iEventGenerator<E>,iEventObserver<E>,Runnable,Serializable{
	 public void addFuture(Ichinen<E> ichinen,long delay);
	 public void removeIchinen(Ichinen<E> ichinen);
	 public List<Ichinen<E>> getPresent();
     public void addObserver(iEventObserver<E> observer);
     public Time getTime(long time);
}
