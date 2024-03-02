package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.CustomerDTO;
import pfeffer.oms.inventory.domain.exceptions.CustomerException;
import pfeffer.oms.inventory.domain.mappers.CustomerMapper;
import pfeffer.oms.inventory.domain.repositories.ICustomerRepository;
import pfeffer.oms.inventory.domain.usecases.CreateCustomer;
import pfeffer.oms.inventory.domain.usecases.UpdateCustomer;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaCustomerMapper;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaCustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerRepository {

    private final JakartaCustomerRepository repository;

    @Autowired
    public CustomerService(JakartaCustomerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO dto) {
        CreateCustomer createLocation = new CreateCustomer(repository);

        return createLocation.execute(dto);
    }

    @Transactional
    public CustomerDTO updateCustomer(String locationId, CustomerDTO dto) {
        UpdateCustomer updateLocation = new UpdateCustomer(repository);

        return updateLocation.execute(locationId, dto);
    }

    public List<CustomerDTO> listCustomers() {
        return this.repository.findAll().stream().map(jakartaLocation ->
                CustomerMapper.toDTO(JakartaCustomerMapper.toDomain(jakartaLocation))
        ).toList();
    }

    @Override
    public CustomerDTO findByCustomerId(String locationId) {
        CustomerDTO location = this.repository.findByCustomerId(locationId);

        if (location == null) {
            throw new CustomerException("There is no customer registered with the provided id", 404);
        }

        return location;
    }

}