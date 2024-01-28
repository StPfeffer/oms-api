package pfeffer.oms.core.domain.usecases;

import pfeffer.oms.core.domain.dtos.CustomerDTO;
import pfeffer.oms.core.domain.entities.CustomerBO;
import pfeffer.oms.core.domain.mappers.CustomerMapper;
import pfeffer.oms.core.domain.repositories.ICustomerDataBaseRepository;

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