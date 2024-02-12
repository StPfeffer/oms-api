package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.enums.EnumStockType;
import pfeffer.oms.inventory.domain.exceptions.ChannelException;
import pfeffer.oms.inventory.domain.mappers.ChannelMapper;
import pfeffer.oms.inventory.domain.repositories.channel.IChannelRepository;
import pfeffer.oms.inventory.domain.usecases.channel.CreateChannel;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelMapper;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaChannelRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ChannelService implements IChannelRepository {

    private final JakartaChannelRepository repository;

    @Autowired
    public ChannelService(JakartaChannelRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ChannelDTO createChannel(ChannelDTO dto) {
        CreateChannel createChannel = new CreateChannel(repository);

        this.isValidChannel(dto);

        List<ChannelDTO> existingChannels = this.listChannels();

        if (existingChannels.isEmpty()) {
            dto.setDefault(true);
        }

        if (dto.getStockTypes() == null) {
            dto.setStockTypes(Collections.singletonList(EnumStockType.PHYSICAL));
        }

        return createChannel.execute(dto);
    }

    public List<ChannelDTO> listChannels() {
        return this.repository.findAll().stream().map(jakartaChannel ->
                ChannelMapper.toDTO(JakartaChannelMapper.toDomain(jakartaChannel))
        ).toList();
    }

    @Override
    public ChannelDTO findChannelByChannelId(String channelId) {
        ChannelDTO channel = this.repository.findChannelByChannelId(channelId);

        if (channel == null) {
            throw new ChannelException("There is no channel registered with the provided channelId", 400);
        }

        return channel;
    }

    private void isValidChannel(ChannelDTO dto) {
        if (dto.getChannelId() == null) {
            throw new ChannelException("Missing property in the request body: channelId", 400);
        }
    }

}
