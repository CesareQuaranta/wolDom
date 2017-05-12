package edu.wol.dom.space;

import edu.wol.dom.WolEntity;
import edu.wol.dom.iEvent;

public class NewPosition<E extends WolEntity> implements iEvent {
	private static final long serialVersionUID = 1L;
	private E entity;
	private Position newPosition;
	
	public NewPosition(E entity,Position newPosition) {
		this.entity=entity;
		this.newPosition=newPosition;
	}

	public E getEntity() {
		return entity;
	}

	public Position getNewPosition() {
		return newPosition;
	}

}
