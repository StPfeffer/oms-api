package pfeffer.oms.core.domain.repositories;

public interface IAbstractDataBaseRepository<BO> {

    BO persist(BO bo);

    BO update(String id, BO bo);

}
