package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.List;

import edu.wol.dom.space.Vector3f;

public class AsteroidShapeFactory {
	private static AsteroidShapeFactory instance=null;
	public static AsteroidShapeFactory getInstance(){
		if(instance==null){
			instance = new AsteroidShapeFactory();
		}
		return instance;
	}
	/*
	 * Genera Shape di una gemma di idrogeno con valori di default
	 */
	public AsteroidShape generateHidrogenGemShape(){
		return generateHidrogenGemShape(10,10,10,10,28,-70.685,200,160,180,68,0.21f,0.35f);
	}
	
	/*
	 * Genera una Shape di tipo Gemma di Idrogeno Metallico rappresentata da una struttura geometrica di 4 baraccia, con in cima una piramide a base triangolare, che si intersecano formando una piramide a base triangolare
	 * TODO:
	 * Ancora da implementare il calcolo del centro sulla base del baricentro
	 * 
	 * Parametri:
	 *  float length1 : lunghezza del primo braccio
	 *  float length2 : lunghezza del secondo braccio
	 *  float length3 : lunghezza del terzo braccio
	 *  float length4 : lunghezza del quarto braccio
	 *  double angoloX : angolo(in gradi) di rotazione attorno all'asse delle X per il primo ed il secondo braccio 
	 *  double angol3X : angolo(in gradi) di rotazione attorno all'asse delle X per il terzo braccio 
	 *  double angolo1Y : angolo(in gradi) di rotazione attorno all'asse delle Y per il primo braccio 
	 *  double angolo2Y : angolo(in gradi) di rotazione attorno all'asse delle Y per il secondo braccio 
	 *  double angolo3Y : angolo(in gradi) di rotazione attorno all'asse delle Y per il terzo braccio 
	 *  double angoloZ : angolo(in gradi) di rotazione attorno all'asse della Z per il primo ed il secondo braccio 
	 *  float correctXZ : Correzione delle coordinate X e Z applicata rispettivamente ai bracci terzo e quarto ed ai bracci primo e secondo
	 *  float correctY : Correzione delle coordinate Y applicata al quarto braccio 
	 *  
	 */
	public AsteroidShape generateHidrogenGemShape(float length1,float length2,float length3,float length4,double angoloX,double angolo3X,double angolo1Y,double angolo2Y,double angolo3Y,double angoloZ,float correctXZ,float correctY){
		AsteroidShape s = new AsteroidShape();
		int numFace=3;
		List<Triangle> pyramidFaces=generatePyramid(numFace+1);
		List<Triangle> projectionFaces=generateEquilateralProjection(true,numFace,length1);
		List<Triangle> faceFused=faceFusion(pyramidFaces,0,projectionFaces,-1);
		List<Triangle> clone1=cloneAll(faceFused);
		
		projectionFaces=generateEquilateralProjection(true,numFace,length2);
	    faceFused=faceFusion(pyramidFaces,0,projectionFaces,-1);
		List<Triangle> clone2=cloneAll(faceFused);
		
		projectionFaces=generateEquilateralProjection(true,numFace,length3);
	    faceFused=faceFusion(pyramidFaces,0,projectionFaces,-1);
		List<Triangle> clone3=cloneAll(faceFused);
		
		projectionFaces=generateEquilateralProjection(true,numFace,length4);
	    faceFused=faceFusion(pyramidFaces,0,projectionFaces,-1);
		List<Triangle> clone4=cloneAll(faceFused);
	
		Vector3f center=new Vector3f(0,-10.6f,0);
		//rotateFaces(faceFused,center,0,45,0);
		//Triangolo equilatero 3 angoli di 60°
		moveFaces(clone1,0,length1-10,0);//Normalize length
		rotateFaces(clone1,center,0,angolo1Y,0);//Rotate Y Axis 180°
		rotateFaces(clone1,center,angoloX,0,0);//Rotate X Axis 20°
		rotateFaces(clone1,center,0,0,angoloZ);//Rotate Z Axis 
		moveFaces(clone1,0,0,-correctXZ);
		
		moveFaces(clone2,0,length2-10,0);//Normalize length
		rotateFaces(clone2,center,0,angolo2Y,0);
		rotateFaces(clone2,center,angoloX,0,0);
		rotateFaces(clone2,center,0,0,-angoloZ);
		moveFaces(clone2,0,0,correctXZ);
		
		moveFaces(clone3,0,length3-10,0);//Normalize length
		rotateFaces(clone3,center,0,angolo3Y,0);
		rotateFaces(clone3,center,angolo3X,0,0);
		moveFaces(clone3,-(correctXZ+0.13f),0,0);
		
		moveFaces(clone4,0,length4-10,0);//Normalize length
		rotateFaces(clone4,center,180,0,0);//Capovolge
		moveFaces(clone4,-(correctXZ/2),correctY,0);
		//rotateFaces(clone2,center,-45,0,0);
		
		/*Center all*///TODO Center first calculate baricentro
		moveFaces(clone1,0,10.6f,0);
		moveFaces(clone2,0,10.6f,0);
		moveFaces(clone3,0,10.6f,0);
		moveFaces(clone4,0,10.6f,0);
		

		s.addFaces(fuseOptimized(clone1,clone2,clone3,clone4));
		return s;
		
	}
	
	private List<Triangle> cloneAll(List<Triangle> src){
		List<Triangle> rValue=new ArrayList<Triangle> (src.size());
		for(Triangle curFace:src){
			Triangle curClone=curFace.clone();
			rValue.add(curClone);
		}
		return rValue;
	}
	
	private void  rotateFaces( List<Triangle> faces,Vector3f center,double angleX,double angleY,double angleZ){
		double radiansX,radiansY,radiusZ,sinX,cosX,sinY,cosY,sinZ,cosZ;
		if(angleX!=0){
			radiansX=Math.toRadians(angleX);
			sinX=Math.sin(radiansX);
			cosX=Math.cos(radiansX);
		}else{
			sinX=0;
			cosX=0;
		}
		if(angleY!=0){
			radiansY=Math.toRadians(angleY);
			sinY=Math.sin(radiansY);
			cosY=Math.cos(radiansY);
		}else{
			sinY=0;
			cosY=0;
		}
		if(angleZ!=0){
			radiusZ=Math.toRadians(angleZ);
			sinZ=Math.sin(radiusZ);
			cosZ=Math.cos(radiusZ);
		}else{
			sinZ=0;
			cosZ=0;
		}

		for(Triangle curFace:faces){
			rotateVector(curFace.getV1(),center,sinX,cosX,sinY,cosY,sinZ,cosZ);
			rotateVector(curFace.getV2(),center,sinX,cosX,sinY,cosY,sinZ,cosZ);
			rotateVector(curFace.getV3(),center,sinX,cosX,sinY,cosY,sinZ,cosZ);
		}
	}
	private void rotateVector(Vector3f v,Vector3f center,double sinX,double cosX,double sinY,double cosY,double sinZ,double cosZ){
		double newX = v.getX();
		double newY = v.getY();
		double newZ = v.getZ();
		if(sinX!=0 || cosX!=0){
			//x' = x*cos q - y*sin q
	        //y' = x*sin q + y*cos q 
	        //z' = z
			double tmpX = center.getX() + ((newX - center.getX()) * cosX ) - ((newY - center.getY()) * sinX);
			//double newX = center.getX() + ( cosX * (curFace.getV1().getX()-center.getX()) + sinX * (curFace.getV1().getY() -center.getY()));
			//double newY = center.getY() + ( -sinX * (curFace.getV1().getX()-center.getX()) + cosX * (curFace.getV1().getY() -center.getY()));
			double tmpY = center.getY() + ((newX - center.getX()) * sinX) + ((newY - center.getY()) * cosX);
			newX=tmpX;
			newY=tmpY;
		}
		if(sinY!=0 || cosY!=0){
			//z' = z*cos q - x*sin q
	        //x' = z*sin q + x*cos q
	        //y' = y
			double tmpZ = center.getZ() + ((newZ - center.getZ()) * cosY) - ((newX - center.getX()) * sinY );
	        double tmpX = center.getX() + ((newZ - center.getZ()) * sinY) + ((newX - center.getX()) * cosY );
	        newX=tmpX;
			newZ=tmpZ;
		}
		if(sinZ!=0 || cosZ!=0){
			// y' = y*cos q - z*sin q
	        // z' = y*sin q + z*cos q
	        // x' = x
			double tmpY = center.getY() +  ((newY - center.getY()) * cosZ) - ((newZ - center.getZ()) * sinZ);
			double tmpZ = center.getZ() +  ((newY - center.getY()) * sinZ) + ((newZ - center.getZ()) * cosZ);
			newY = tmpY;
			newZ = tmpZ;
		}
		v.set((float)newX, (float)newY, (float)newZ);
	}
	private void  moveFaces( List<Triangle> faces,float x,float y,float z){
		for(Triangle curFace:faces){
			curFace.getV1().setX(curFace.getV1().getX()+x);
			curFace.getV1().setY(curFace.getV1().getY()+y);
			curFace.getV1().setZ(curFace.getV1().getZ()+z);
			curFace.getV2().setX(curFace.getV2().getX()+x);
			curFace.getV2().setY(curFace.getV2().getY()+y);
			curFace.getV2().setZ(curFace.getV2().getZ()+z);
			curFace.getV3().setX(curFace.getV3().getX()+x);
			curFace.getV3().setY(curFace.getV3().getY()+y);
			curFace.getV3().setZ(curFace.getV3().getZ()+z);
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<Triangle> fuseOptimized(List<Triangle>... faces ){
		int size=0;
		for(List<Triangle> curList:faces){
			size+=curList.size();
		}
		
		List<Triangle> allFaces=new ArrayList<Triangle>(size);
		for(List<Triangle> curList:faces){
			allFaces.addAll(curList);
		}
		float minDistance=0.1f;
		for(Triangle curFace:allFaces){
			for(Triangle curCheckFace:allFaces){
				if(curFace!=curCheckFace){
					if(curFace.getV1()!= curCheckFace.getV1() && curFace.getV1().distance(curCheckFace.getV1())<minDistance){
						curCheckFace.setV1(curFace.getV1());
					}
					if(curFace.getV1()!= curCheckFace.getV2() && curFace.getV1().distance(curCheckFace.getV2())<minDistance){
						curCheckFace.setV2(curFace.getV1());
					}
					if(curFace.getV1()!= curCheckFace.getV3() && curFace.getV1().distance(curCheckFace.getV3())<minDistance){
						curCheckFace.setV3(curFace.getV1());
					}
					if(curFace.getV2()!= curCheckFace.getV1() && curFace.getV2().distance(curCheckFace.getV1())<minDistance){
						curCheckFace.setV1(curFace.getV2());
					}
					if(curFace.getV2()!= curCheckFace.getV2() && curFace.getV2().distance(curCheckFace.getV2())<minDistance){
						curCheckFace.setV2(curFace.getV2());
					}
					if(curFace.getV2()!= curCheckFace.getV3() && curFace.getV2().distance(curCheckFace.getV3())<minDistance){
						curCheckFace.setV3(curFace.getV2());
					}
					if(curFace.getV3()!= curCheckFace.getV1() && curFace.getV3().distance(curCheckFace.getV1())<minDistance){
						curCheckFace.setV1(curFace.getV3());
					}
					if(curFace.getV3()!= curCheckFace.getV2() && curFace.getV3().distance(curCheckFace.getV2())<minDistance){
						curCheckFace.setV2(curFace.getV3());
					}
					if(curFace.getV3()!= curCheckFace.getV3() && curFace.getV3().distance(curCheckFace.getV3())<minDistance){
						curCheckFace.setV3(curFace.getV3());
					}

				}
				
			}
		}
		return allFaces;
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
			if(fusionIndex2+1<obj2.size()){
				allFaces.addAll(obj2.subList(fusionIndex2+1, obj2.size()));
			}
		}else if(fusionIndex2 == 0){
			allFaces.addAll(obj2.subList(1, obj2.size()));
		}else{
			allFaces.addAll(obj2);//Add all
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
	private List<Triangle> generateEquilateralProjection(boolean open,int numFace,float length){
		List<Triangle> faces=new ArrayList<Triangle>(numFace+2);
		List<Vector3f> basePoints=generateEquilateralBase(numFace);
		List<Vector3f> basePoints2=new ArrayList<Vector3f>(numFace);
		
		if(!open){
			for(int i=0;i<numFace-2;i++){//Base faces
				faces.add(new Triangle(basePoints.get(i),basePoints.get(i+1),basePoints.get(i+2)));
			}
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
		
		if(!open){
			for(int i=0;i<numFace-2;i++){//Base faces
				faces.add(new Triangle(basePoints2.get(i),basePoints2.get(i+1),basePoints2.get(i+2)));
			}
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
