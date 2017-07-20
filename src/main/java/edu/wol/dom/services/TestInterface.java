package edu.wol.dom.services;

import java.io.IOException;

import edu.wol.dom.shape.AsteroidShape;

public interface TestInterface {
	public AsteroidShape generateAsteroidShape() throws IOException, Exception;
}
