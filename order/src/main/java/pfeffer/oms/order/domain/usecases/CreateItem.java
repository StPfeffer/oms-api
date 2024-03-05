package pfeffer.oms.order.domain.usecases;

import pfeffer.oms.order.domain.dtos.ItemDTO;
import pfeffer.oms.order.domain.entities.ItemBO;
import pfeffer.oms.order.domain.mappers.ItemMapper;
import pfeffer.oms.order.domain.repositories.IItemDataBaseRepository;

public class CreateItem {

    private final IItemDataBaseRepository repository;

    public CreateItem(IItemDataBaseRepository repository) {
        this.repository = repository;
    }

    public ItemDTO execute(ItemDTO dto) {
        ItemBO entity = repository.persist(ItemMapper.toBO(dto));

        return ItemMapper.toDTO(entity);
    }

}
