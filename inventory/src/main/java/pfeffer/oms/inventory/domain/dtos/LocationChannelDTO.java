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

    public ChannelDTO getChannel() {
        return channel;
    }

    public void setChannel(ChannelDTO channel) {
        this.channel = channel;
    }

    public List<LocationDTO> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDTO> locations) {
        this.locations = locations;
    }

}
