package pfeffer.oms.core.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.core.domain.dtos.CustomerDTO;
import pfeffer.oms.core.domain.exceptions.CustomerException;
import pfeffer.oms.core.domain.mappers.CustomerMapper;
import pfeffer.oms.core.domain.repositories.ICustomerRepository;
import pfeffer.oms.core.domain.usecases.CreateCustomer;
import pfeffer.oms.core.domain.usecases.UpdateCustomer;
import pfeffer.oms.core.infra.jakarta.mappers.JakartaCustomerMapper;
import pfeffer.oms.core.infra.jakarta.repository.JakartaCustomerRepository;

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
    public CustomerDTO findCustomerById(String locationId) {
        CustomerDTO location = this.repository.findCustomerById(locationId);

        if (location == null) {
            throw new CustomerException("Não existe um cliente cadastrado para o ID informado", 404);
        }

        return location;
    }

}