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

import edu.wol.dom.space.Planetoid;

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
	
    public long getID(){
    	return ID;
    }
    
    @Override
	public boolean equals(Object comp){
		if(comp.getClass() == this.getClass()){
			return this.ID == ((WolEntity)comp).ID;
		}else{
			return false;
		}
	}
    
    public boolean isNew(){
    	return this.ID==0;
    }

    //void setUID(String UID);

    /*Karma<? extends Entity> getKarma();

    Set<iPower> getPowers();

    void setPowers(Set<iPower> powers);

    boolean addPower(iPower power); */
}
