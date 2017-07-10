package edu.wol.dom.shape;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import edu.wol.dom.space.Vector;
@Entity
public class Triangle {
	@Id
	@GeneratedValue
	private long ID;
	@Lob
	private Vector v1;
	@Lob
	private Vector v2;
	@Lob
	private Vector v3;
	
	public Triangle(){
		
	}
	public Triangle(Vector v1, Vector v2, Vector v3) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public Vector getV1() {
		return v1;
	}

	public void setV1(Vector v1) {
		this.v1 = v1;
	}

	public Vector getV2() {
		return v2;
	}

	public void setV2(Vector v2) {
		this.v2 = v2;
	}

	public Vector getV3() {
		return v3;
	}

	public void setV3(Vector v3) {
		this.v3 = v3;
	}
	
	
}
