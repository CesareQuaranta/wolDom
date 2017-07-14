package edu.wol.dom;

import org.junit.Test;
import org.springframework.util.Assert;

import edu.wol.dom.shape.AsteroidShape;
import edu.wol.dom.shape.AsteroidShapeFactory;
import edu.wol.dom.space.Vector3f;

public class GeometryTest {
	
	@Test
	public void testVectors() throws Exception{
		Vector3f v0=new Vector3f(0,0,0);
		Vector3f v00=new Vector3f(0,0,0);
		Vector3f v1=new Vector3f(1,0,0);
		Vector3f v2=new Vector3f(0,1,0);
		Vector3f v3=new Vector3f(0,0,1);
		Vector3f v11=new Vector3f(1,0,0);
		Assert.isTrue(v0.equals(v00), "Error Equals function");
		Assert.isTrue(v1.equals(v11), "Error Equals function");
		Assert.isTrue(!v0.equals(v1), "Error Equals function");
		Assert.isTrue(!v0.equals(v2), "Error Equals function");
		Assert.isTrue(!v0.equals(v3), "Error Equals function");
		Assert.isTrue(v0.hashCode()==v0.hashCode(), "Error HashCode function");
		Assert.isTrue(v0.hashCode()!=v1.hashCode(), "Error HashCode function");
		Assert.isTrue(v0.hashCode()!=v2.hashCode(), "Error HashCode function");
		Assert.isTrue(v0.hashCode()!=v3.hashCode(), "Error HashCode function");
		Assert.isTrue(v1.hashCode()!=v2.hashCode(), "Error HashCode function");
		Assert.isTrue(v1.hashCode()!=v3.hashCode(), "Error HashCode function");
	}
	@Test
	public void testAsteroidShapeGeneration() throws Exception{
		AsteroidShape shape = AsteroidShapeFactory.getInstance().generateShape();
		Assert.notNull(shape, "Fail to generate Asteroid Shape");
		System.out.println(shape.getVertices().toString());
		
	}

}
