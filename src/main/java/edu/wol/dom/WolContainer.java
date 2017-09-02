package edu.wol.dom;

import java.io.IOException;
import java.util.Collection;

import edu.wol.dom.space.Position;

public interface  WolContainer<T extends WorldContainer<E,Position,?,?>,E extends WolEntity> extends Runnable {
	public void init() throws Exception;
	public void insertEntity(E entity,String wolID,Position position) throws IOException, Exception;
	public void castAwayEntities(String wolID,Position position, long radius);
	public Prospective associateNewWolProspective() throws IOException, Exception;
	public Collection<Phenomen<E>> getAllPhenomen(String wolID)throws IOException, Exception;
}
