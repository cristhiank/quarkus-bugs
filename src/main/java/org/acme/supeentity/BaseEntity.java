package org.acme.supeentity;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * @author cristhiank on 25/11/19
 **/
@MappedSuperclass
public abstract class BaseEntity {
	// Comment this and use getter annotation solves the issue
	// Changing field to protected solves the issue only if super-class is in the same package than the entity-class
	@Embedded
	private EmbeddedValue superField;

	// Uncommenting this solves the issue.
	//@Embedded
	public EmbeddedValue getSuperField() {
		return superField;
	}

	protected void setSuperField(EmbeddedValue superField) {
		this.superField = superField;
	}
}
