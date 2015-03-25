package wol.dom.space;

import wol.dom.phisycs.iMassEntity;
import wol.dom.shape.iShape;

public interface iPlanetoid extends iMassEntity,Comparable<iPlanetoid>{
    public double getRadius();
    public iShape getShape();
}
