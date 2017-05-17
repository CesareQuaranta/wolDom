package edu.wol.dom;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Created with IntelliJ IDEA.
 * User: cesare
 * Date: 17/08/13
 * Time: 15.50
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ExternalCause<E extends WolEntity> implements iEvent,Serializable{
	@Id
	@GeneratedValue
	private long ID;
}
