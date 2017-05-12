package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.Id;

import edu.wol.dom.WorldContainer;
import edu.wol.dom.iEvent;
import edu.wol.dom.shape.iShape;
@Entity
public class LivingPlanet extends Planet  implements WorldContainer<iPlanetEntity,Position>{
	private static final long serialVersionUID = 8898280448751239745L;
	
	@Id
	private String id;

	public LivingPlanet(double mass, double radius) {
		super(mass, radius);
	}

	public LivingPlanet(double mass, double radius, iShape shape) {
		super(mass, radius, shape);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processEvent(iEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(float spacePrecision, float timePrecision) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public iSpace<iPlanetEntity, Position> getSpace() {
		// TODO Auto-generated method stub
		return null;
	}

}
