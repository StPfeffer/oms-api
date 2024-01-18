package pfeffer.oms.inventory.domain.dtos;

import java.util.List;

public class LocationChannelDTO {

    /**
     * O ID do canal de vendas.
     */
    private ChannelDTO channel;

    /**
     * As filiais vinculadas ao canal de vendas.
     */
    private List<LocationDTO> locations;

}
