package wol.dom;

import java.util.List;

import wol.dom.space.Position;
public abstract class WolContainer<T extends WorldContainer<E,Position>,E extends Entity> implements Runnable {
	
	public abstract Window openWindow(Position pos);
	
	public abstract List<iEvent> getEvents(String windowIdentifier);
}
