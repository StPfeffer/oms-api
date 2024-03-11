package pfeffer.oms.logistic.domain.repositories;

import pfeffer.oms.logistic.domain.dtos.CarrierDTO;

public interface ICarrierRepository {

    CarrierDTO findByCarrierId(String carrierId);

}
