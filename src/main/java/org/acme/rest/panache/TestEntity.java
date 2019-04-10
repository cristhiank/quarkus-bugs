package org.acme.rest.panache;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestEntity {
	@Id
	@GeneratedValue
	public UUID id;
	public String name;
}