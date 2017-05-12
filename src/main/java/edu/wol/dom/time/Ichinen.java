package edu.wol.dom.time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.wol.dom.Effect;
import edu.wol.dom.WolEntity;
import edu.wol.dom.iAction;
import edu.wol.dom.iExternalCause;
import edu.wol.dom.iInternalCause;
import edu.wol.dom.iLatentEffect;
import edu.wol.dom.iPower;

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
	
	private WolEntity entity;
	private iPower power;
    private iAction action;
    private iInternalCause<WolEntity> internalCause;
    private iExternalCause<WolEntity> externalCause;
    private iLatentEffect latentEffect;
    private Effect<WolEntity> effect;

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

	public iPower getPower() {
		return power;
	}

	public void setPower(iPower power) {
		this.power = power;
	}

	public iAction getAction() {
		return action;
	}

	public void setAction(iAction action) {
		this.action = action;
	}

	public iInternalCause<E> getInternalCause() {
		return (iInternalCause<E>) internalCause;
	}

	public void setInternalCause(iInternalCause<E> internalCause) {
		this.internalCause = (iInternalCause<WolEntity>) internalCause;
	}

	public iExternalCause<E> getExternalCause() {
		return (iExternalCause<E>) externalCause;
	}

	public void setExternalCause(iExternalCause<E> externalCause) {
		this.externalCause = (iExternalCause<WolEntity>) externalCause;
	}

	public iLatentEffect getLatentEffect() {
		return latentEffect;
	}

	public void setLatentEffect(iLatentEffect latentEffect) {
		this.latentEffect = latentEffect;
	}

	public Effect<E> getEffect() {
		return (Effect<E>) effect;
	}

	public void setEffect(Effect<E> effect) {
		this.effect = (Effect<WolEntity>) effect;
	}
}
