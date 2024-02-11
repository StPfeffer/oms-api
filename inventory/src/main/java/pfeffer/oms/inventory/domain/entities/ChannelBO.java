package pfeffer.oms.inventory.domain.entities;

import java.util.List;

public class ChannelBO {
    private String channelId;

    private boolean isDefault;

    private List<ChannelStockBO> stockTypes;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public List<ChannelStockBO> getStockTypes() {
        return stockTypes;
    }

    public void setStockTypes(List<ChannelStockBO> stockTypes) {
        this.stockTypes = stockTypes;
    }

}
