package org.acme.rest;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * @author cristhiank on 25/11/19
 **/
@MappedSuperclass
public abstract class BaseEntity {
	// CHANGE THIS TO PUBLIC AND IT WORKS :o
	@Embedded
	private EmbeddedValue superField;

	public EmbeddedValue superField() {
		return superField;
	}

	protected void setSuperField(EmbeddedValue superField) {
		this.superField = superField;
	}
}
