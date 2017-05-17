package edu.wol.dom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 07/10/11
 * Time: 0.10
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class LatentEffect implements iEvent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2043979459033613267L;
	@Id
	@GeneratedValue
	private long ID;
	
	public float getTime(){//TODO
		return 0;
	}
}
