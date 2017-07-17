package edu.wol.dom.space;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Transient;

import edu.wol.dom.phisycs.MassEntity;
import edu.wol.dom.shape.Shape;
@Entity
public class Planetoid extends MassEntity implements Comparable<Planetoid>{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3824869428455182143L;
	protected double radius;
	
	@Transient
    protected Shape shape;
    @Basic
    protected ArrayList<String> materia;
    
	public double getRadius(){
		return radius;
	}
    public Shape getShape(){
    	return shape;
    }
	@Override
	public int compareTo(Planetoid o) {
		return Double.compare(this.mass, o.mass);
	}

	public Collection<String> getMateria() {
		return materia;
	}
	public void setMateria(Collection<String> materia) {
		this.materia = new ArrayList<String>(materia);
	}
	public void addMateria(String materia) {
		this.materia.add(materia);
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
