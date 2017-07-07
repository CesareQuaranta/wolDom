package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import edu.wol.dom.space.Position;
import edu.wol.dom.space.Vector;

@Entity
public class AsteroidShape extends Shape {
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@OrderColumn(name="faces_seq", nullable=false)
	protected List<Triangle> faces;
	
	public AsteroidShape(){
		faces=new ArrayList<Triangle>();
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

	public List<Vector> getVertices() {
		Set<Vector> vectorSet=new HashSet<Vector>();
		for(Triangle curFace:faces){
			vectorSet.add(curFace.getV1());
			vectorSet.add(curFace.getV2());
			vectorSet.add(curFace.getV3());
		}
		List<Vector> vectors=new ArrayList<Vector>();
		vectors.addAll(vectorSet);
		return vectors;
	}
	public List<Vector> getNormals() {//TODO
		return null;
	}
	@Override
	public boolean checkInterseption(Position position, Shape otherShape,
			Position otherPosition) {
		return false;
	}
	
}
