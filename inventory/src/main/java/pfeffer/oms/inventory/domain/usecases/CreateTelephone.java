package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.TelephoneDTO;
import pfeffer.oms.inventory.domain.entities.TelephoneBO;
import pfeffer.oms.inventory.domain.mappers.TelephoneMapper;
import pfeffer.oms.inventory.domain.repositories.ITelephoneDataBaseRepository;

public class CreateTelephone {

    private final ITelephoneDataBaseRepository repository;

    public CreateTelephone(ITelephoneDataBaseRepository repository) {
        this.repository = repository;
    }

    public TelephoneDTO execute(TelephoneDTO dto) {
        TelephoneBO entity = repository.persist(TelephoneMapper.toBO(dto));

        return TelephoneMapper.toDTO(entity);
    }

}