package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.CustomerDTO;
import pfeffer.oms.inventory.domain.entities.CustomerBO;
import pfeffer.oms.inventory.domain.mappers.CustomerMapper;
import pfeffer.oms.inventory.domain.repositories.ICustomerDataBaseRepository;

public class UpdateCustomer {

    private final ICustomerDataBaseRepository repository;

    public UpdateCustomer(ICustomerDataBaseRepository repository) {
        this.repository = repository;
    }

    public CustomerDTO execute(String locationId, CustomerDTO dto) {
        CustomerBO entity = repository.update(locationId, CustomerMapper.toBO(dto));

        return CustomerMapper.toDTO(entity);
    }

}