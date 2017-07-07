package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		List<Triangle> pyramidFaces=generatePyramid(numFace+1);
		List<Triangle> projectionFaces=generateEquilateralProjection(numFace,10);
		s.addFaces(faceFusion(pyramidFaces,projectionFaces));
		return s;
		
	}
	private List<Triangle> faceFusion(List<Triangle> obj1,List<Triangle> obj2){//TODO Intersect rotate & co
		List<Triangle> allFaces=new ArrayList<Triangle>(obj1.size()+obj2.size());
		allFaces.addAll(obj1);
		allFaces.addAll(obj2);
		return allFaces;
	}
	/**
	 * Generazioni di geometrie di sepmlici piramidi
	 * @param numFace
	 * @return
	 */
	private List<Triangle> generatePyramid(int numFace){
		List<Triangle> faces=new ArrayList<Triangle>(numFace);
		List<Vector> allVertices=new ArrayList<Vector>(numFace);
		List<Vector> basePoints=generateEquilateralBase(numFace-1);
		
		for(int i=0;i<numFace-3;i++){//Base faces
			faces.add(new Triangle(basePoints.get(i),basePoints.get(i+1),basePoints.get(i+2)));
		}
		Vector center=new Vector(0,1,0);
		allVertices.add(center);//Center
		allVertices.addAll(basePoints);//Base
		for(int i=1;i<numFace-1;i++){
			faces.add(new Triangle(allVertices.get(i),center,allVertices.get(i+1)));
		}
		faces.add(new Triangle(allVertices.get(numFace-1),center,allVertices.get(1)));//Last face
		return faces;
	}
	/**
	 * Generazioni di geometrie di sepmlici shape equilatere proiettate
	 * @param numFace
	 * @return
	 */
	private List<Triangle> generateEquilateralProjection(int numFace,int length){
		List<Triangle> faces=new ArrayList<Triangle>(numFace+2);
		List<Vector> basePoints=generateEquilateralBase(numFace);
		List<Vector> basePoints2=generateEquilateralBase(numFace);
		
		for(int i=0;i<numFace-2;i++){//Base faces
			faces.add(new Triangle(basePoints.get(i),basePoints.get(i+1),basePoints.get(i+2)));
		}
		for(Vector curBasePoint:basePoints){
			Vector newBasePoint=curBasePoint.clone();
			newBasePoint.setY(-length);
			basePoints2.add(newBasePoint);
		}
		for(int i=0;i<numFace;i++){
			faces.add(new Triangle(basePoints.get(i),basePoints.get((1+i)%numFace),basePoints2.get(i)));
			faces.add(new Triangle(basePoints2.get(i),basePoints.get((1+i)%numFace),basePoints2.get((1+i)%numFace)));
		}
		
		for(int i=0;i<numFace-2;i++){//Base faces
			faces.add(new Triangle(basePoints2.get(i),basePoints2.get(i+1),basePoints2.get(i+2)));
		}
		return faces;
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
