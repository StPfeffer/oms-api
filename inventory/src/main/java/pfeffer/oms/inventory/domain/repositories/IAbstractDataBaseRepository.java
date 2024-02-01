package pfeffer.oms.inventory.domain.repositories;

public interface IAbstractDataBaseRepository<BO> {

    BO persist(BO bo);

}
