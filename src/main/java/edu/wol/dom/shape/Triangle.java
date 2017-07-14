package edu.wol.dom.shape;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import edu.wol.dom.space.Vector3f;
@Entity
public class Triangle implements Cloneable{
	@Id
	@GeneratedValue
	private long ID;
	@Lob
	private Vector3f v1;
	@Lob
	private Vector3f v2;
	@Lob
	private Vector3f v3;
	
	public Triangle(){
		
	}
	public Triangle(Vector3f v1, Vector3f v2, Vector3f v3) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public Vector3f getV1() {
		return v1;
	}

	public void setV1(Vector3f v1) {
		this.v1 = v1;
	}

	public Vector3f getV2() {
		return v2;
	}

	public void setV2(Vector3f v2) {
		this.v2 = v2;
	}

	public Vector3f getV3() {
		return v3;
	}

	public void setV3(Vector3f v3) {
		this.v3 = v3;
	}
	
	public Triangle clone(){
		return new Triangle(v1.clone(),v2.clone(),v3.clone());
	}
	
	
}
