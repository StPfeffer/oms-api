package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.AddressDTO;
import pfeffer.oms.inventory.domain.entities.AddressBO;
import pfeffer.oms.inventory.domain.mappers.AddressMapper;
import pfeffer.oms.inventory.domain.repositories.IAddressDataBaseRepository;

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