package pfeffer.oms.logistic.domain.usecases;

import pfeffer.oms.logistic.domain.dtos.CarrierDTO;
import pfeffer.oms.logistic.domain.entities.CarrierBO;
import pfeffer.oms.logistic.domain.mappers.CarrierMapper;
import pfeffer.oms.logistic.domain.repositories.ICarrierDataBaseRepository;

public class CreateCarrier {

    private final ICarrierDataBaseRepository repository;

    public CreateCarrier(ICarrierDataBaseRepository repository) {
        this.repository = repository;
    }

    public CarrierDTO execute(CarrierDTO dto) {
        CarrierBO entity = repository.persist(CarrierMapper.toBO(dto));

        return CarrierMapper.toDTO(entity);
    }

}
