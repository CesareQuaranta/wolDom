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
@JoinColumn(name = "focus", referencedColumnName = "ID")
private Position focus;

private int fov;//Field of View (0-360)
private float near;//Near vision 
private float far;//Far vision

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "wolId", referencedColumnName = "ID")
private WorldContainer<WolEntity,Position> wol; //Wol relative Prospective


public Prospective(WorldContainer<WolEntity,Position> wol){
	position=new Position(0,0,5);
	focus=new Position(0,0,0);
	this.wol=wol;
	fov=50;//Default
	near=1;
	far=1000;
}

public Position getPosition() {
	return position;
}
public void setPosition(Position position) {
	this.position = position;
}
public Position getFocus() {
	return focus;
}
public void setFocus(Position focus) {
	this.focus = focus;
}
public int getFov() {
	return fov;
}
public void setFov(int fov) {
	this.fov = fov;
}
public float getNear() {
	return near;
}
public void setNear(float near) {
	this.near = near;
}
public float getFar() {
	return far;
}
public void setFar(float far) {
	this.far = far;
}

public WorldContainer<WolEntity,Position> getWol() {
	return wol;
}
public void setWol(WorldContainer<WolEntity,Position> wol) {
	this.wol = wol;
}
}
