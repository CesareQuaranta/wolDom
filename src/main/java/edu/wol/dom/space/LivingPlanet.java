package edu.wol.dom.space;

import javax.persistence.Entity;
import javax.persistence.Id;

import edu.wol.dom.WorldContainer;
import edu.wol.dom.iEvent;
import edu.wol.dom.shape.PlanetShape;
import edu.wol.dom.shape.Shape;
@Entity
public class LivingPlanet extends Planet{
	private static final long serialVersionUID = 8898280448751239745L;
	
	public LivingPlanet() {
		super();
	}

	public LivingPlanet(double mass, double radius) {
		super(mass, radius);
	}

	public LivingPlanet(double mass, double radius, PlanetShape shape) {
		super(mass, radius, shape);
	}

	/*@Override
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
	public iSpace<Planetoid, Position> getSpace() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
