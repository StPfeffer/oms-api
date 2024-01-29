package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.CustomerDTO;
import pfeffer.oms.inventory.domain.entities.CustomerBO;
import pfeffer.oms.inventory.domain.mappers.CustomerMapper;
import pfeffer.oms.inventory.domain.repositories.ICustomerDataBaseRepository;

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