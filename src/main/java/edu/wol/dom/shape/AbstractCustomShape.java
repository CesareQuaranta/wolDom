package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import edu.wol.dom.space.Vector3f;

@MappedSuperclass
public abstract class AbstractCustomShape extends Shape {

	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@OrderColumn(name="faces_seq", nullable=false)
	protected List<Triangle> faces;
	
	public void addFace(Triangle f){
		faces.add(f);
	}
	public void addFaces(List<Triangle> f){
		faces.addAll(f);
	}
	
	public List<Triangle> getFaces() {
		return faces;
	}

	public List<Vector3f> getVertices() {
		Set<Vector3f> vectorSet=new LinkedHashSet<Vector3f>();
		for(Triangle curFace:faces){
			vectorSet.add(curFace.getV1());
			vectorSet.add(curFace.getV2());
			vectorSet.add(curFace.getV3());
		}
		List<Vector3f> vectors=new ArrayList<Vector3f>();
		vectors.addAll(vectorSet);
		return vectors;
	}
	public List<Vector3f> getNormals() {//TODO
		return null;
	}
}
