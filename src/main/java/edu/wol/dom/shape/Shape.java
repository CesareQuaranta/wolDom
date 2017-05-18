package edu.wol.dom.shape;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import edu.wol.dom.space.Position;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 06/10/11
 * Time: 23.53
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Shape {
	@Id
	@GeneratedValue
	private long ID;
	
	abstract boolean checkInterseption(Position position,Shape otherShape,Position otherPosition);
}
