package edu.wol.dom.space;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Transient//FIXME
    protected Shape shape;
    protected Collection<String> materia;
    
	public double getRadius(){
		return radius;
	}
    public Shape getShape(){
    	return shape;
    }
	@Override
	public int compareTo(Planetoid o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Collection<String> getMateria() {
		return materia;
	}
	public void setMateria(Collection<String> materia) {
		this.materia = materia;
	}
	public void addMateria(String materia) {
		this.materia.add(materia);
	}
}
