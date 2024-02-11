package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;
import pfeffer.oms.inventory.domain.mappers.ChannelStockMapper;
import pfeffer.oms.inventory.domain.usecases.channel.CreateChannelStock;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelStockMapper;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaChannelStockRepository;

import java.util.List;

@Service
public class ChannelStockService {

    private final JakartaChannelStockRepository repository;

    @Autowired
    public ChannelStockService(JakartaChannelStockRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ChannelStockDTO createChannelStock(ChannelStockDTO dto) {
        CreateChannelStock createChannel = new CreateChannelStock(repository);

        return createChannel.execute(dto);
    }

    public List<ChannelStockDTO> listChannelStockTypes() {
        return this.repository.findAll().stream().map(jakartaChannelStock ->
                ChannelStockMapper.toDTO(JakartaChannelStockMapper.toDomain(jakartaChannelStock))
        ).toList();
    }

}
