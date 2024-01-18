package pfeffer.oms.inventory.domain.entities;

import pfeffer.oms.inventory.domain.dtos.ChannelDTO;
import pfeffer.oms.inventory.domain.dtos.LocationDTO;

import java.util.List;

public class LocationChannelBO {

    private ChannelDTO channel;

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
