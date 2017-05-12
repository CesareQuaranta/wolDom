package edu.wol.dom.time;

import java.util.List;

import edu.wol.dom.WolEntity;
import edu.wol.dom.iEvent;

public class ManifestPresent<E extends WolEntity> implements iEvent {
	private static final long serialVersionUID = 1L;
	private List<Ichinen<E>> present;
	
	public ManifestPresent(List<Ichinen<E>> present) {
		this.present=present;
	}

	public List<Ichinen<E>> getPresent() {
		return present;
	}
	

}
