package edu.wol.dom.commands;

import edu.wol.dom.space.iCoordinate;

public class GravityPower implements Command{
	private Long magnitudo;
	private iCoordinate position;
	
	public Long getMagnitudo() {
		return magnitudo;
	}
	public void setMagnitudo(Long magnitudo) {
		this.magnitudo = magnitudo;
	}
	public iCoordinate getPosition() {
		return position;
	}
	public void setPosition(iCoordinate position) {
		this.position = position;
	}

}
