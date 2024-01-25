package pfeffer.oms.inventory.domain.usecases.update;

import pfeffer.oms.inventory.domain.interfaces.IAbstractMapper;
import pfeffer.oms.inventory.domain.repositories.IAbstractDataBaseRepository;

public abstract class AbstractUpdateUseCase<DTO, BO, Mapper extends IAbstractMapper<DTO, BO>, Repository extends IAbstractDataBaseRepository<BO>> {

    private final Repository repository;
    private final Mapper mapper;

    public AbstractUpdateUseCase(Repository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DTO execute(String id, DTO dto) {
        BO entity = repository.update(id, mapper.toBO(dto));

        return mapper.toDTO(entity);
    }

}
