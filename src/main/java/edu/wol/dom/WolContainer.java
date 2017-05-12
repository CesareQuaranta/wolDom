package edu.wol.dom;

import java.util.List;

import edu.wol.dom.space.Position;
public abstract class WolContainer implements Runnable {
	
	public abstract Window openWindow(Position pos);
	
	public abstract List<iEvent> getEvents(String windowIdentifier);
}