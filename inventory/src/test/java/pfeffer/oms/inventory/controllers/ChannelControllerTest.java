package pfeffer.oms.inventory.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.services.ChannelService;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ChannelController.class)
class ChannelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ChannelService service;

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldCreateChannel() throws Exception {
        ChannelDTO dto = new ChannelDTO();
        dto.setChannelId("channel-test-293857");

        MvcResult result = this.mockMvc.perform(post("/channels")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(toJson(dto)
                        .getBytes(StandardCharsets.UTF_8)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        assertNotNull(result);

        String channelJson = result.getResponse().getContentAsString();

        assertNotNull(channelJson);
        assertEquals(channelJson, toJson(dto));
    }

    @Test
    void shouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/channels")).andDo(print()).andExpect(status().isOk());
    }

}