package pfeffer.oms.inventory.domain.usecases.create;

import pfeffer.oms.inventory.domain.interfaces.IAbstractMapper;
import pfeffer.oms.inventory.domain.repositories.IAbstractDataBaseRepository;

public abstract class AbstractCreateUseCase<DTO, BO, Mapper extends IAbstractMapper<DTO, BO>, Repository extends IAbstractDataBaseRepository<BO>> {

    private final Repository repository;
    private final Mapper mapper;

    public AbstractCreateUseCase(Repository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DTO execute(DTO dto) {
        BO entity = repository.persist(mapper.toBO(dto));

        return mapper.toDTO(entity);
    }

}
