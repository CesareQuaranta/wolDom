package edu.wol.dom.phisycs;

import edu.wol.dom.Effect;
import edu.wol.dom.WolEntity;

public class Collision<E extends WolEntity> extends Effect<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6011658638891963136L;
	private E object;
	private E subject;
	
	public Collision(E object, E subject) {
		super(object);
		this.object = object;
		this.subject = subject;
	}
	
	public E getObject() {
		return object;
	}
	public void setObject(E object) {
		this.object = object;
	}
	public E getSubject() {
		return subject;
	}
	public void setSubject(E subject) {
		this.subject = subject;
	}
}
