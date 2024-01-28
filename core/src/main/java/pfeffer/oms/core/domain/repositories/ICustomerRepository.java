package pfeffer.oms.core.domain.repositories;

import pfeffer.oms.core.domain.dtos.CustomerDTO;

public interface ICustomerRepository {

    CustomerDTO findCustomerById(String id);

}
