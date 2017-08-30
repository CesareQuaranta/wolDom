package edu.wol.dom.commands;

import edu.wol.dom.space.Position;

public class GravityPower implements Command{
	private Long magnitudo;
	private Position position;
	
	public Long getMagnitudo() {
		return magnitudo;
	}
	public void setMagnitudo(Long magnitudo) {
		this.magnitudo = magnitudo;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String toString() {
		return position.toString() + ", M:" + magnitudo.toString();
	}

}
