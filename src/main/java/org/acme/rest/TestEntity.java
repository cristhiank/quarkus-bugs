package org.acme.rest;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author cristhiank on 25/11/19
 **/
@Entity
public class TestEntity extends BaseEntity {
	@Id
	private String id;
	private String name;

	protected TestEntity() {
	}

	private TestEntity(String id, String name) {
		this.id = id;
		this.name = name;
		setSuperField( EmbeddedValue.of( "SUPER " + name ) );
	}

	public static TestEntity of(String id, String name) {
		return new TestEntity( id, name );
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}
}
