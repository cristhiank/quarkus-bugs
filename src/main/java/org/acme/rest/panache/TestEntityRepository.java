package org.acme.rest.panache;

import java.util.UUID;
import javax.enterprise.context.Dependent;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

/**
 * @author cristhiank on 2019-04-09
 *
 **/
@Dependent
public class TestEntityRepository implements PanacheRepositoryBase<TestEntity, UUID> {
}
