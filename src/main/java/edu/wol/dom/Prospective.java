package edu.wol.dom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.wol.dom.space.Position;

/*
 
 */
@Entity
public class Prospective {
@Id
@GeneratedValue
private long ID;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "posId", referencedColumnName = "ID")
private Position position;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "hrzId", referencedColumnName = "ID")
private Position horizon;

private int fov;//Field of View (0-360)
private float nearRatio;//Near vision percentage
private float farRatio;//Far vision percentage

/*@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "wolId", referencedColumnName = "ID")
private WorldContainer<WolEntity,Position> wol; //Wol relative Prospective
*/

public Prospective(){
	position=null;
	horizon=position;
	//wol=null;
	fov=50;//Default
	nearRatio=1/100;
	farRatio=1;
}

public Position getPosition() {
	return position;
}
public void setPosition(Position position) {
	this.position = position;
}
public Position getHorizon() {
	return horizon;
}
public void setHorizon(Position horizon) {
	this.horizon = horizon;
}
public int getFov() {
	return fov;
}
public void setFov(int fov) {
	this.fov = fov;
}
public float getNearRatio() {
	return nearRatio;
}
public void setNearRatio(float nearRatio) {
	this.nearRatio = nearRatio;
}
public float getFarRatio() {
	return farRatio;
}
public void setFarRatio(float farRatio) {
	this.farRatio = farRatio;
}
/*
public WorldContainer<WolEntity,Position> getWol() {
	return wol;
}
public void setWol(WorldContainer<WolEntity,Position> wol) {
	this.wol = wol;
}*/
}
