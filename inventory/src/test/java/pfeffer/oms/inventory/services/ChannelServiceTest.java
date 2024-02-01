package pfeffer.oms.inventory.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.exceptions.ChannelException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService service;

    @Test
    void shouldCreateChannel() {
        this.shouldCreateChannel("channel-test-997348");
    }

    void shouldCreateChannel(String channelId) {
        ChannelDTO dto = new ChannelDTO();

        if (channelId != null) {
            dto.setChannelId(channelId);
        }

        ChannelDTO channel = service.createChannel(dto);

        assertNotNull(channel);
        assertEquals(dto.getChannelId(), channel.getChannelId());
    }

    @Test
    void shouldThrowChannelException() {
        ChannelException exception = assertThrows(
                ChannelException.class,
                () -> service.findChannelByChannelId("channel-test-997348"));

        assertTrue(exception.getMessage().contains("There is no channel registered with the provided channelId"));
    }

    @Test
    void shouldNotThrowChannelException() {
        this.shouldCreateChannel("channel-test-9348976209");

        assertDoesNotThrow(() -> service.findChannelByChannelId("channel-test-9348976209"));
    }

    @Test
    void shouldFindChannel() {
        this.shouldCreateChannel("channel-test-994567348");

        ChannelDTO channel = service.findChannelByChannelId("channel-test-994567348");

        assertNotNull(channel);
        assertEquals("channel-test-994567348", channel.getChannelId());
    }

}