package pfeffer.oms.inventory.domain.repositories;

import pfeffer.oms.inventory.domain.dtos.CustomerDTO;

public interface ICustomerRepository {

    CustomerDTO findCustomerById(String id);

}
