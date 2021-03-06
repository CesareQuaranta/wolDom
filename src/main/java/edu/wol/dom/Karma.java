package edu.wol.dom;

import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * Created with IntelliJ IDEA.
 * User: cesare
 * Date: 19/08/12
 * Time: 20.29
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Karma {
	@Id
	@GeneratedValue
	private long ID;
	//@OneToMany(cascade=CascadeType.ALL)
	@Transient//TODO
	private LinkedList<Phenomen<WolEntity>> current=new LinkedList<Phenomen<WolEntity>>();
	//@OneToMany(cascade=CascadeType.ALL)
	@Transient//TODO
	private LinkedList<Phenomen<WolEntity>> past=new LinkedList<Phenomen<WolEntity>>();
	
	public Karma() {
	}

	public LinkedList<Phenomen<WolEntity>> getCurrent() {
		return current;
	}

	public void setCurrent(LinkedList<Phenomen<WolEntity>> current) {
		this.current = current;
	}
	
	/*
    protected Map<iInternalCause<E>,Effect<E>> karmaSingleton=new HashMap<iInternalCause<E>,Effect<E>>();
    protected Map<iInternalCause<E>,Collection<Effect<E>>> karmaCollection=new HashMap<iInternalCause<E>,Collection<Effect<E>>>();

    public void add(iInternalCause<E> cause,Effect<E> effect){
        if(cause.isSingleton()){
            karmaSingleton.put(cause,effect);
        }else{
            Collection<Effect<E>> curEffects=karmaCollection.get(cause);
            if(curEffects==null){
                curEffects=new LinkedList<Effect<E>>();
                karmaCollection.put(cause,curEffects);
            }
            curEffects.add(effect);
        }
    }

    public Effect<E> getEffect(Phenomen<E> cause){
        return  karmaSingleton.get(cause);
    }

    public Collection<Effect<E>> getEffects(Phenomen<E> cause){
        return  karmaCollection.get(cause);
    }
*/
}
