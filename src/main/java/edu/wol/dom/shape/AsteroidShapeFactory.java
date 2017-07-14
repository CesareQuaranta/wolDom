package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.wol.dom.space.Vector3f;

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
		List<Triangle> faceFused=faceFusion(pyramidFaces,0,projectionFaces,0);
		List<Triangle> clone1=new ArrayList<Triangle> (faceFused.size());
		List<Triangle> clone2=new ArrayList<Triangle> (faceFused.size());
		List<Triangle> clone3=new ArrayList<Triangle> (faceFused.size());
		for(Triangle curFace:faceFused){
			Triangle curClone1=curFace.clone();
			Triangle curClone2=curFace.clone();
			Triangle curClone3=curFace.clone();
			clone1.add(curClone1);
			clone2.add(curClone2);
			clone3.add(curClone3);
		}
		Vector3f center=new Vector3f(0,-11,0);
		rotateFaces(clone1,center,45,45,0);
		rotateFaces(clone2,center,-45,45,0);
		rotateFaces(clone3,center,180,0,0);
		List<Triangle> allFaces=new ArrayList<Triangle>(faceFused.size()+clone1.size()+clone2.size()+clone3.size());
		allFaces.addAll(faceFused);
		allFaces.addAll(clone1);
		allFaces.addAll(clone2);
		allFaces.addAll(clone3);
		s.addFaces(allFaces);
		return s;
		
	}
	private void  rotateFaces( List<Triangle> faces,Vector3f center,double angleX,double angleY,double angleZ){
		double radiansX=Math.toRadians(angleX);
		double sinX=Math.sin(radiansX);
		double cosX=Math.cos(radiansX);
		double radiansY=Math.toRadians(angleY);
		double sinY=Math.sin(radiansY);
		double cosY=Math.cos(radiansY);
		for(Triangle curFace:faces){
			double newX = center.getX() + ( cosX * (curFace.getV1().getX()-center.getX()) + sinX * (curFace.getV1().getY() -center.getY()));
			double newY = center.getY() + ( -sinX * (curFace.getV1().getX()-center.getX()) + cosX * (curFace.getV1().getY() -center.getY()));
			double newZ = curFace.getV1().getZ();
			if(angleY!=0){
				newX = center.getX() + ( cosY * (newX-center.getX()) + sinY * (newY -center.getY()));
				newZ = center.getY() + ( -sinY * (curFace.getV1().getX()-center.getX()) + cosX * (curFace.getV1().getY() -center.getY()));
			}
			curFace.getV1().setX((float) newX);
			curFace.getV1().setY((float) newY);
			newX = center.getX() + ( cosX * (curFace.getV2().getX()-center.getX()) + sinX * (curFace.getV2().getY() -center.getY()));
			newY = center.getY() + ( -sinX * (curFace.getV2().getX()-center.getX()) + cosX * (curFace.getV2().getY() -center.getY()));
			curFace.getV2().setX((float) newX);
			curFace.getV2().setY((float) newY);
			newX = center.getX() + ( cosX * (curFace.getV3().getX()-center.getX()) + sinX * (curFace.getV3().getY() -center.getY()));
			newY = center.getY() + ( -sinX * (curFace.getV3().getX()-center.getX()) + cosX * (curFace.getV3().getY() -center.getY()));
			curFace.getV3().setX((float) newX);
			curFace.getV3().setY((float) newY);
		}
	}
	private List<Triangle> faceFusion(List<Triangle> obj1,int fusionIndex1,List<Triangle> obj2,int fusionIndex2){//TODO Intersect rotate & co
		List<Triangle> allFaces=new ArrayList<Triangle>(obj1.size()+obj2.size()-2);
		if(fusionIndex1>0){
			allFaces.addAll(obj1.subList(0, fusionIndex1));
		}
		if(fusionIndex1+1<obj1.size()){
			allFaces.addAll(obj1.subList(fusionIndex1+1, obj1.size()));
		}
		if(fusionIndex2>0){
			allFaces.addAll(obj2.subList(0, fusionIndex2));
		}
		if(fusionIndex2+1<obj2.size()){
			allFaces.addAll(obj2.subList(fusionIndex2+1, obj2.size()));
		}
		return allFaces;
	}
	/**
	 * Generazioni di geometrie di sepmlici piramidi
	 * @param numFace
	 * @return
	 */
	private List<Triangle> generatePyramid(int numFace){
		List<Triangle> faces=new ArrayList<Triangle>(numFace);
		List<Vector3f> allVertices=new ArrayList<Vector3f>(numFace);
		List<Vector3f> basePoints=generateEquilateralBase(numFace-1);
		
		for(int i=0;i<numFace-3;i++){//Base faces
			faces.add(new Triangle(basePoints.get(i),basePoints.get(i+1),basePoints.get(i+2)));
		}
		Vector3f center=new Vector3f(0,1,0);
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
		List<Vector3f> basePoints=generateEquilateralBase(numFace);
		List<Vector3f> basePoints2=new ArrayList<Vector3f>(numFace);
		
		for(int i=0;i<numFace-2;i++){//Base faces
			faces.add(new Triangle(basePoints.get(i),basePoints.get(i+1),basePoints.get(i+2)));
		}
		for(Vector3f curBasePoint:basePoints){
			Vector3f newBasePoint=curBasePoint.clone();
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
	private List<Vector3f> generateEquilateralBase(int nVertex){
		return this.generateEquilateralBase(0,0,0,1,nVertex);
	}
	private List<Vector3f> generateEquilateralBase(float centerX,float centerY,float centerZ,float radius, int nVertex){
		List<Vector3f> vertex=new ArrayList<Vector3f>(nVertex);
		double x,z;
		 for(int i=0; i<nVertex; i++) {
		      x=centerX+radius*Math.cos(2*Math.PI*i/nVertex);
		      z=centerZ+radius*Math.sin(2*Math.PI*i/nVertex);
		      vertex.add(new Vector3f((float)x,centerY,(float)z));
		    }
		return vertex;
	}
}
