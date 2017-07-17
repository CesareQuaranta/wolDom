package edu.wol.dom;

import java.util.ArrayList;
import java.util.Collection;

import edu.wol.dom.space.Position;
import edu.wol.dom.space.Vector3f;



/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 10/10/11
 * Time: 23.08
 * To change this template use File | Settings | File Templates.
 */
public class Phenomen<E extends WolEntity> {
	private E entity;//Who
	private Vector3f position;//Where
	private Collection<Effect<E>> effects=new ArrayList<Effect<E>>();//What/When?
	
	public E getEntity() {
		return entity;
	}
	public void setEntity(E entity) {
		this.entity = entity;
	}
	public Vector3f getPosition() {
		return position;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public Collection<Effect<E>> getEffects() {
		return effects;
	}
	public void addEffect(Effect<E> effect) {
		this.effects.add(effect);
	}
}
