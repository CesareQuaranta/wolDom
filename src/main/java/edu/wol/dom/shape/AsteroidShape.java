package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import edu.wol.dom.space.Position;
import edu.wol.dom.space.Vector;

@Entity
public class AsteroidShape extends Shape {
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	protected List<Vector> vertices;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	protected List<Triangle> faces;
	
	public AsteroidShape(){
		vertices=new ArrayList<Vector>();
		faces=new ArrayList<Triangle>();
	}
	
	public void addVertice(Vector v){
		vertices.add(v);
	}
	public void addVertices(List<Vector> v){
		vertices.addAll(v);
	}
	
	public List<Vector> getVertices() {
		return vertices;
	}
	
	public void addFace(Triangle f){
		faces.add(f);
	}
	public void addFaces(List<Triangle> f){
		faces.addAll(f);
	}
	
	public List<Triangle> getFaces() {
		return faces;
	}

	@Override
	public boolean checkInterseption(Position position, Shape otherShape,
			Position otherPosition) {
		return false;
	}
	
}
