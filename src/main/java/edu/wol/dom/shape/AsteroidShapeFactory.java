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
		int numFace=3;
		List<Vector> basePoints=generateEquilateralBase(numFace);
		Vector center=new Vector(0,1,0);
		s.addVertice(center);//Center
		s.addVertices(basePoints);//Base
		List<Vector> vertices=s.getVertices();
		for(int i=1;i<numFace;i++){
			s.addFace(new Triangle(vertices.get(i),center,vertices.get(i+1)));
		}
		s.addFace(new Triangle(vertices.get(numFace),center,vertices.get(1)));//Last face
		//TODO Projections of numFace
		for(Vector curBasePoint:basePoints){
			Vector newBasePoint=curBasePoint.clone();
			newBasePoint.setY(-10);
			s.addVertice(newBasePoint);
		}
		for(int i=0;i<numFace;i++){
			s.addFace(new Triangle(vertices.get(4+i),vertices.get(4+((1+i)%numFace)),vertices.get(1+i)));
			s.addFace(new Triangle(vertices.get(4+((1+i)%numFace)),vertices.get(1+((1+i)%numFace)),vertices.get(1+i)));
		}
		//TODO Normals
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
