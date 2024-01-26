package pfeffer.oms.core.domain.usecases;

import pfeffer.oms.core.domain.dtos.AddressDTO;
import pfeffer.oms.core.domain.entities.AddressBO;
import pfeffer.oms.core.domain.mappers.AddressMapper;
import pfeffer.oms.core.domain.repositories.IAddressDataBaseRepository;

public class CreateAddress {

    private final IAddressDataBaseRepository repository;

    public CreateAddress(IAddressDataBaseRepository repository) {
        this.repository = repository;
    }

    public AddressDTO execute(AddressDTO dto) {
        AddressBO entity = repository.persist(AddressMapper.toBO(dto));

        return AddressMapper.toDTO(entity);
    }

}