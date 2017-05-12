package edu.wol.dom.phisycs;

import edu.wol.dom.iPower;

public interface ForceFactory extends iPower {
	public Force getForce(iForceElements elements);
}
