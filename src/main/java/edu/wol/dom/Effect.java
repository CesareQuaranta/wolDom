package edu.wol.dom;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: cesare
 * Date: 07/10/11
 * Time: 0.10
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Effect<E extends WolEntity> implements iEvent {
	private static final long serialVersionUID = 5692499734770881520L;
	@Id
	@GeneratedValue
	private long ID;
	@OneToOne(cascade=CascadeType.ALL)
	private WolEntity e;

	public Effect(E entity) {
		super();
		this.e = entity;
	}

	public E getEntity() {
		return (E)e;
	}
	
}
