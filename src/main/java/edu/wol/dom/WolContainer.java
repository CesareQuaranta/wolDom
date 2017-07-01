package edu.wol.dom;

import java.io.IOException;
import java.util.Collection;

import edu.wol.dom.space.Position;

public interface  WolContainer<T extends WorldContainer<E,Position>,E extends WolEntity> extends Runnable {
	public void init() throws Exception;
	public void insertEntity(E entity,long wolID,Position position) throws IOException, Exception;
	public Prospective associateNewWolProspective() throws IOException, Exception;
	public Collection<Phenomen<E>> getAllPhenomen(long wolID)throws IOException, Exception;
}
