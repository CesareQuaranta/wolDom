package edu.wol.dom.space;

import edu.wol.dom.phisycs.iMassEntity;
import edu.wol.dom.shape.iShape;

public interface iPlanetoid extends iMassEntity,Comparable<iPlanetoid>{
    public double getRadius();
    public iShape getShape();
}
