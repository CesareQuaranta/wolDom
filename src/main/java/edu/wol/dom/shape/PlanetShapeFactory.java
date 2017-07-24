package edu.wol.dom.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.wol.dom.space.Vector3f;

public class PlanetShapeFactory {
	private static PlanetShapeFactory instance=null;
	public static PlanetShapeFactory getInstance(){
		if(instance==null){
			instance = new PlanetShapeFactory();
		}
		return instance;
	}
	
	/*
	 * Insipired by http://www.javaworld.com/article/2076745/learn-java/3d-graphic-java--render-fractal-landscapes.html
	 * 
	 * int lod : Level Of detail => final dimension = (2^lod)+1 X (2^lod)+1
	 */
	public PlaneShape generateIsland(int lod,double roughness,double maxHeigth){
		PlaneShape plane=new PlaneShape();
		
		int divisions=  1 << lod;//(int) Math.pow(lod, 2);
		double[][] terrain = new double[divisions+1][divisions+1];
		double rough = roughness;
		Random rng = new Random ();
		//init
		terrain[0][0] = rng.nextDouble()*maxHeigth;
	    terrain[0][divisions] = rng.nextDouble()*maxHeigth;
	    terrain[divisions][divisions] =rng.nextDouble()*maxHeigth;
	    terrain[divisions][0] = rng.nextDouble()*maxHeigth;
	    
	    for (int i = 0; i < lod; ++ i) {
	        int side = 1 << (lod - i);
	        int scale = side >> 1;
	        for (int x = 0; x < divisions; x += side)
	          for (int y = 0; y < divisions; y += side){
	        	  if (side > 1) {
	        	      int half = side / 2;
	        	      double avg = (terrain[x][y] + terrain[x + side][y] + terrain[x + side][y + side] + terrain[x][y + side]) * 0.25;
	        	      terrain[x + half][y + half] = avg + (rng.nextDouble() * rough);
	        	    }
	          }
	        if (scale > 0)
	            for (int j = 0; j <= divisions; j += scale)
	              for (int k = (j + scale) % side; k <= divisions; k += side){
	            	  int half = side / 2;
	            	  int x = j - scale;
	            	  int y = k - scale;
	            	    double avg = 0.0, sum = 0.0;
	            	    if (x >= 0)
	            	    { avg += terrain[x][y + half]; sum += 1.0; }
	            	    if (y >= 0)
	            	    { avg += terrain[x + half][y]; sum += 1.0; }
	            	    if (x + side <= divisions)
	            	    { avg += terrain[x + side][y + half]; sum += 1.0; }
	            	    if (y + side <= divisions)
	            	    { avg += terrain[x + half][y + side]; sum += 1.0; }
	            	    terrain[x + half][y + half] = avg / sum + (rng.nextDouble() * rough);
	              }
	          rough *= roughness;
	    }
	    
	    //Convert terrain to faces
	    List<Triangle> faces=new ArrayList<Triangle>(divisions*divisions*2);
	    for(int x = 0; x<divisions-1; x++){
	    	 for(int z = 0; z<divisions-1; z++){
	    		 Vector3f upperLeft = new Vector3f(x,(float) terrain[x][z],z);
	    		 Vector3f upperRight = new Vector3f(x+1,(float) terrain[x+1][z],z);
	    		 Vector3f lowerLeft = new Vector3f(x,(float) terrain[x][z+1],z+1);
	    		 Vector3f lowerRight = new Vector3f(x+1,(float) terrain[x+1][z+1],z+1);
	    		 faces.add(new Triangle(upperLeft,upperRight,lowerLeft));
	    		 faces.add(new Triangle(lowerLeft,upperRight,lowerRight));
	    	 }
	    }
	    
	    plane.addFaces(faces);
		return plane;
	}
}
