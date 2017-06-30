package edu.wol.dom;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import edu.wol.dom.space.Position;
public abstract class WolContainer<T extends WorldContainer<E,Position>,E extends WolEntity> implements Runnable {
	
	public abstract void insertEntity(E entity,long wolID,Position position) throws IOException, Exception;
	public abstract Prospective generateNewWol() throws IOException, Exception;
	public abstract Collection<Phenomen<E>> getAllPhenomen(long wolID)throws IOException, Exception;
}
