package edu.wol.dom.phisycs;

import javax.persistence.Entity;

import edu.wol.dom.WolEntity;
/**
 * Created with IntelliJ IDEA.
 * User: cesare
 * Date: 14/08/13
 * Time: 10.00
 * To change this template use File | Settings | File Templates.
 */
@Entity
public abstract class MassEntity extends WolEntity{
	protected double mass;
    public double getMass(){
    	return mass;
    }
    public void setMass(double mass){
    	this.mass = mass;
    }
}
