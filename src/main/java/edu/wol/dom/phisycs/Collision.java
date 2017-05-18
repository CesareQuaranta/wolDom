package edu.wol.dom.phisycs;

import javax.persistence.Entity;

import edu.wol.dom.Effect;
import edu.wol.dom.WolEntity;
@Entity
public class Collision<E extends WolEntity> extends Effect<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6011658638891963136L;
	private WolEntity object;
	private WolEntity subject;
	public Collision() {
		super(null);
		this.object = null;
		this.subject = null;
	}
	public Collision(E object, E subject) {
		super(object);
		this.object = object;
		this.subject = subject;
	}
	
	public E getObject() {
		return (E)object;
	}
	public void setObject(E object) {
		this.object = object;
	}
	public E getSubject() {
		return (E)subject;
	}
	public void setSubject(E subject) {
		this.subject = subject;
	}
}
