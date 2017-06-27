package edu.wol.dom.shape;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.wol.dom.space.Vector;
@Entity
public class Triangle {
	@Id
	@GeneratedValue
	private long ID;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "v1Id", referencedColumnName = "ID")
	private Vector v1;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "v2Id", referencedColumnName = "ID")
	private Vector v2;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "v3Id", referencedColumnName = "ID")
	private Vector v3;
	
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
