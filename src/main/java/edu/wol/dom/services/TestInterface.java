package edu.wol.dom.services;

import java.io.IOException;

import edu.wol.dom.shape.AsteroidShape;

public interface TestInterface {
	public AsteroidShape generateHidrogenGemShape(float length1,float length2,float length3, float length4,double angoloX,double angolo3X,double angolo1Y,double angolo2Y,double angolo3Y,double angoloZ,float correctXZ,float correctY) throws IOException, Exception;
}
