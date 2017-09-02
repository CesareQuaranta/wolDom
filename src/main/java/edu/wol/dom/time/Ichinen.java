package edu.wol.dom.time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.wol.dom.Effect;
import edu.wol.dom.Power;
import edu.wol.dom.WolEntity;
import edu.wol.dom.Action;
import edu.wol.dom.ExternalCause;
import edu.wol.dom.InternalCause;
import edu.wol.dom.LatentEffect;

/**
 * Created with IntelliJ IDEA.
 * User: cesare
 * Date: 22/08/12
 * Time: 17.28
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="WOL_TIMEICHINEN")
public class Ichinen<E extends WolEntity> {
	@Id
	@GeneratedValue
	private long ID;
	
	private WolEntity entity;//Entità
	private Power power;//Potere
    private Action action;//Azione scatenante
    private InternalCause<WolEntity> internalCause;
    private ExternalCause<WolEntity> externalCause;
    private LatentEffect latentEffect;
    private Effect<WolEntity> effect;

    public Ichinen() {
		this.entity=null;
	}
    
	public Ichinen(E entity) {
		this.entity=entity;
	}


	@Override
	public String toString() {
		return "Ichinen ["
				+ (entity != null ? "entity=" + entity + ", " : "")
				+ (power != null ? "power=" + power + ", " : "")
				+ (action != null ? "action=" + action + ", " : "")
				+ (internalCause != null ? "internalCause=" + internalCause
						+ ", " : "")
				+ (externalCause != null ? "externalCause=" + externalCause
						+ ", " : "")
				+ (latentEffect != null ? "latentEffect=" + latentEffect + ", "
						: "") + (effect != null ? "effect=" + effect : "")
				+ "]";
	}

	public E getEntity() {
		return (E) entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public InternalCause<E> getInternalCause() {
		return (InternalCause<E>) internalCause;
	}

	public void setInternalCause(InternalCause<E> internalCause) {
		this.internalCause = (InternalCause<WolEntity>) internalCause;
	}

	public ExternalCause<E> getExternalCause() {
		return (ExternalCause<E>) externalCause;
	}

	public void setExternalCause(ExternalCause<E> externalCause) {
		this.externalCause = (ExternalCause<WolEntity>) externalCause;
	}

	public LatentEffect getLatentEffect() {
		return latentEffect;
	}

	public void setLatentEffect(LatentEffect latentEffect) {
		this.latentEffect = latentEffect;
	}

	public Effect<E> getEffect() {
		return (Effect<E>) effect;
	}

	public void setEffect(Effect<E> effect) {
		this.effect = (Effect<WolEntity>) effect;
	}
}
