package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.entities.CustomerBO;

public interface ICustomerDataBaseRepository extends IAbstractDataBaseRepository<CustomerBO> {

    CustomerBO update(String customerId, CustomerBO bo);

}
