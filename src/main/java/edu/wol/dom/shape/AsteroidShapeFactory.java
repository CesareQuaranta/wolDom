package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.List;

import edu.wol.dom.space.Vector;

public class AsteroidShapeFactory {
	private static AsteroidShapeFactory instance=null;
	public static AsteroidShapeFactory getInstance(){
		if(instance==null){
			instance = new AsteroidShapeFactory();
		}
		return instance;
	}
	public AsteroidShape generateShape(){
		AsteroidShape s = new AsteroidShape();
		List<Vector> vertices=generateEquilateralBase(3);
		s.addVertice(new Vector(0,1,0));//Center
		s.addVertices(vertices);//Base
		//TODO add Faces
		return s;
		
	}
	private List<Vector> generateEquilateralBase(int nVertex){
		return this.generateEquilateralBase(0,0,0,1,nVertex);
	}
	private List<Vector> generateEquilateralBase(float centerX,float centerY,float centerZ,float radius, int nVertex){
		List<Vector> vertex=new ArrayList<Vector>(nVertex);
		double x,z;
		 for(int i=0; i<nVertex; i++) {
		      x=centerX+radius*Math.cos(2*Math.PI*i/nVertex);
		      z=centerZ+radius*Math.sin(2*Math.PI*i/nVertex);
		      vertex.add(new Vector((float)x,centerY,(float)z));
		    }
		return vertex;
	}
}
