package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import edu.wol.dom.space.Position;
import edu.wol.dom.space.Vector;

@Entity
public class AsteroidShape extends Shape {
	
	protected List<Vector> vertices;
	protected List<Triangle> faces;
	protected String materiaID;
	
	public AsteroidShape(){
		vertices=new ArrayList<Vector>();
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

	public String getMateriaID() {
		return materiaID;
	}

	public void setMateriaID(String materiaID) {
		this.materiaID = materiaID;
	}

	@Override
	public boolean checkInterseption(Position position, Shape otherShape,
			Position otherPosition) {
		return false;
	}
	
}
