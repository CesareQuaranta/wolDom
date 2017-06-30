package edu.wol.dom;

import edu.wol.dom.space.Position;



/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 10/10/11
 * Time: 23.08
 * To change this template use File | Settings | File Templates.
 */
public class Phenomen<E extends WolEntity> {
	private E entity;//Who
	private Position position;//Where
	private Effect<E> effect;//What/When?
	
	public E getEntity() {
		return entity;
	}
	public void setEntity(E entity) {
		this.entity = entity;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Effect<E> getEffect() {
		return effect;
	}
	public void setEffect(Effect<E> effect) {
		this.effect = effect;
	}
}
