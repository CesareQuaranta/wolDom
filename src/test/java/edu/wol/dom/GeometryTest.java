package edu.wol.dom;

import java.util.Comparator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;
import edu.wol.dom.shape.AsteroidShape;
import edu.wol.dom.shape.AsteroidShapeFactory;
import edu.wol.dom.shape.PlaneShape;
import edu.wol.dom.shape.PlanetShapeFactory;
import edu.wol.dom.space.Vector3f;

public class GeometryTest {
	private class VectorYComparator implements Comparator<Vector3f>{

		@Override
		public int compare(Vector3f v1, Vector3f v2) {
			return Float.compare(v1.y, v2.y);
		}
		
	}
	
	@Test
	public void testVectors() throws Exception{
		Vector3f v0=new Vector3f(0,0,0);
		Vector3f v00=new Vector3f(0,0,0);
		Vector3f v1=new Vector3f(1,0,0);
		Vector3f v2=new Vector3f(0,1,0);
		Vector3f v3=new Vector3f(0,0,1);
		Vector3f v11=new Vector3f(1,0,0);
		assertTrue( "Error Equals function",v0.equals(v00));
		assertTrue("Error Equals function",v1.equals(v11));
		assertTrue("Error Equals function",!v0.equals(v1));
		assertTrue("Error Equals function",!v0.equals(v2));
		assertTrue("Error Equals function",!v0.equals(v3));
		assertTrue("Error HashCode function", v0.hashCode()==v0.hashCode());
		assertTrue("Error HashCode function", v0.hashCode()!=v1.hashCode());
		assertTrue("Error HashCode function", v0.hashCode()!=v2.hashCode());
		assertTrue("Error HashCode function", v0.hashCode()!=v3.hashCode());
		assertTrue("Error HashCode function", v1.hashCode()!=v2.hashCode());
		assertTrue("Error HashCode function", v1.hashCode()!=v3.hashCode());
	}
	@Test
	public void testAsteroidShapeGeneration() throws Exception{
		AsteroidShape shape = AsteroidShapeFactory.getInstance().generateHidrogenGemShape();
		assertNotNull("Fail to generate Asteroid Shape",shape);
		List<Vector3f> vectors=shape.getVertices();
		vectors.sort(new VectorYComparator());
		Vector3f max1Y=vectors.get(vectors.size()-1);
		Vector3f max2Y=vectors.get(vectors.size()-2);
		Vector3f max3Y=vectors.get(vectors.size()-3);
		//3 vertici con stessa y == y max
		assertEquals(max1Y.getY(),max2Y.getY(),0.001d);
		assertEquals(max1Y.getY(),max3Y.getY(),0.001d);
		
		//1 vertice con y == y min
		Vector3f minY=vectors.get(0);
		assertTrue("Unaspected short shape", minY.getY()<-11);
		System.out.println(shape.getVertices().toString());
		System.out.println("Max1:"+max1Y.toString());
		System.out.println("Max2:"+max2Y.toString());
		System.out.println("Max3:"+max3Y.toString());
		System.out.println("Min:"+minY.toString());
		
	}
	
	@Test
	public void testIslandGeneration() throws Exception{
		PlaneShape shape = PlanetShapeFactory.getInstance().generateIsland(6, 1, 100);
		System.out.println("Terrain test:"+shape.getVertices().toString());
	}

}
