package pfeffer.oms.core.domain.usecases;

import pfeffer.oms.core.domain.dtos.CustomerDTO;
import pfeffer.oms.core.domain.entities.CustomerBO;
import pfeffer.oms.core.domain.mappers.CustomerMapper;
import pfeffer.oms.core.domain.repositories.ICustomerDataBaseRepository;

public class CreateCustomer {

    private final ICustomerDataBaseRepository repository;

    public CreateCustomer(ICustomerDataBaseRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO execute(CustomerDTO dto) {
        CustomerBO entity = repository.persist(CustomerMapper.toBO(dto));

        return CustomerMapper.toDTO(entity);
    }

}