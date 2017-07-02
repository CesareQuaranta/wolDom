package edu.wol.dom;

import org.junit.Test;
import org.springframework.util.Assert;

import edu.wol.dom.shape.AsteroidShape;
import edu.wol.dom.shape.AsteroidShapeFactory;

public class GeometryTest {
	
	@Test
	public void testAsteroidShapeGeneration() throws Exception{
		AsteroidShape shape = AsteroidShapeFactory.getInstance().generateShape();
		Assert.notNull(shape, "Fail to generate Asteroid Shape");
		System.out.println(shape.getVertices().toString());
		
	}

}
