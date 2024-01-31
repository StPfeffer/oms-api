package pfeffer.oms.inventory.domain.mappers;

import org.junit.jupiter.api.Test;
import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.entities.ChannelBO;

import static org.junit.jupiter.api.Assertions.*;

class ChannelMapperTest {

    @Test
    void testToDTO() {
        ChannelBO bo = new ChannelBO();
        bo.setChannelId("channel");

        ChannelDTO dto = ChannelMapper.toDTO(bo);

        assertNotNull(dto);
        assertEquals("channel", dto.getChannelId());
    }

    @Test
    void testToBO() {
        ChannelDTO dto = new ChannelDTO();
        dto.setChannelId("channel");

        ChannelBO bo = ChannelMapper.toBO(dto);

        assertNotNull(bo);
        assertEquals("channel", bo.getChannelId());
    }

}