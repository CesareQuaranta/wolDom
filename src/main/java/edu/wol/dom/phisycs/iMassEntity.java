package edu.wol.dom.phisycs;

import edu.wol.dom.WolEntity;
/**
 * Created with IntelliJ IDEA.
 * User: cesare
 * Date: 14/08/13
 * Time: 10.00
 * To change this template use File | Settings | File Templates.
 */
public interface iMassEntity extends WolEntity{
    public double getMass();
    public void setMass(double mass);
}