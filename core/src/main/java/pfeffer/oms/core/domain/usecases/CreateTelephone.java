package pfeffer.oms.core.domain.usecases;

import pfeffer.oms.core.domain.dtos.TelephoneDTO;
import pfeffer.oms.core.domain.entities.TelephoneBO;
import pfeffer.oms.core.domain.mappers.TelephoneMapper;
import pfeffer.oms.core.domain.repositories.ITelephoneDataBaseRepository;

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