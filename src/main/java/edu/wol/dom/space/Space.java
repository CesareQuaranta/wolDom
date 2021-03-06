package edu.wol.dom.space;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import edu.wol.dom.WolEntity;
import edu.wol.dom.iEventGenerator;
import edu.wol.dom.iEventObserver;
import edu.wol.dom.phisycs.Force;
import edu.wol.dom.phisycs.ForceFactory;

/**
 * Created by IntelliJ IDEA.
 * User: Cesaropode
 * Date: 31-gen-2010
 * Time: 23.53.19
 * To change this template use File | Settings | File Templates.
 */
/**
 * Obbiettivi della classe sono:
 * 1) Collezionare le coordinate delle entity inserite
 * 2) Determinare la loro posiziopne nell'istante di tempo attuale
 * 3) Determinare l'istante di tempo di collisione di due entità
 * 
 * TODO List
 * L'idea è di trasformare questa classe astratta in una che abbia tutte le funzioni fondamentali e che possa gestire lo spazio non come una matrice
 * ma come un insieme di funzioni temporali
 * In particolare lo spazio base dovrebbe gestire la funzione stupida immutabile nel tempo, ed una funzione inerziale dove la posizione e le distanze variano al variare del tempo
 * Bisogna quindi trasferire qui da Physincs il concetto di velocity index
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Space<E extends WolEntity,V extends Tuple3f> implements iEventGenerator<E>,iEventObserver<E>,Serializable{
	@Id
	@GeneratedValue
	private long ID;
	
    protected float precision;//Space Precision in fraction of meters
	public abstract E getEntity(V position);
    public abstract Collection<E> getAllEntities();
    public abstract V getPosition(E entity);//?? necessaria??
    //public abstract boolean process(Movement<E> movement);
    public abstract void addObserver(iEventObserver<E> observer);
    public abstract boolean insertEntity(V coordinate,E entity);
    //public abstract void insertForceFactory(ForceFactory f);
    public abstract boolean isEmpty();
    //public Collection<Force> getAllForces(E entity);
}
