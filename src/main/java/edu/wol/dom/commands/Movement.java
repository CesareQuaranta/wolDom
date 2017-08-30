package edu.wol.dom.commands;

import edu.wol.dom.space.Position;

public class Movement implements Command{
	private Position position;
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

	public String toString() {
		return position.toString();
	}
}
