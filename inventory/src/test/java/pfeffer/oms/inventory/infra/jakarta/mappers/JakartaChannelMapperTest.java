package pfeffer.oms.inventory.infra.jakarta.mappers;

import org.junit.jupiter.api.Test;
import pfeffer.oms.inventory.domain.entities.ChannelBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;

import static org.junit.jupiter.api.Assertions.*;

class JakartaChannelMapperTest {

    @Test
    void toEntity() {
        ChannelBO bo = new ChannelBO();
        bo.setChannelId("channel");

        JakartaChannel entity = JakartaChannelMapper.toEntity(bo);

        assertNotNull(entity);
        assertEquals("channel", entity.getChannelId());
    }

    @Test
    void toDomain() {
        JakartaChannel dto = new JakartaChannel();
        dto.setChannelId("channel");

        ChannelBO bo = JakartaChannelMapper.toDomain(dto);

        assertNotNull(bo);
        assertEquals("channel", bo.getChannelId());
    }

}