package pfeffer.oms.inventory.domain.dtos;

import java.util.List;

public class ChannelDTO {

    private String channelId;

    private boolean isDefault;

    private List<ChannelStockDTO> stockTypes;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<ChannelStockDTO> getStockTypes() {
        return stockTypes;
    }

    public void setStockTypes(List<ChannelStockDTO> stockTypes) {
        this.stockTypes = stockTypes;
    }

}
