package org.acme.rest;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author cristhiank on 25/11/19
 **/
@Embeddable
public class EmbeddedValue implements Serializable {
	@Column(name = "super_field")
	private String superField;

	protected EmbeddedValue() {
	}

	private EmbeddedValue(String superField) {
		this.superField = superField;
	}

	public static EmbeddedValue of(String superField) {
		return new EmbeddedValue( superField );
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		EmbeddedValue that = (EmbeddedValue) o;
		return superField.equals( that.superField );
	}

	@Override
	public int hashCode() {
		return Objects.hash( superField );
	}
}
