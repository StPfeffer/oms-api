package pfeffer.oms.inventory.domain.interfaces;

public interface IAbstractMapper<DTO, BO> {

    DTO toDTO(BO bo);

    BO toBO(DTO dto);

}
