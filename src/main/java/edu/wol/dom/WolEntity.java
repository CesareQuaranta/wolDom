package edu.wol.dom;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: cesare
 * Date: 14/08/13
 * Time: 10.21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class WolEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 830900835843147978L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long ID;
    //String getUID();

    //void setUID(String UID);

    /*Karma<? extends Entity> getKarma();

    Set<iPower> getPowers();

    void setPowers(Set<iPower> powers);

    boolean addPower(iPower power); */
}
