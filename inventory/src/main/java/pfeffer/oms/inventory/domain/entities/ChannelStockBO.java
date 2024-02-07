package pfeffer.oms.inventory.domain.entities;

import pfeffer.oms.inventory.domain.enums.EnumStockType;

import java.util.List;

public class ChannelStockBO {

    private String channelId;

    private List<EnumStockType> stockTypes;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<EnumStockType> getStockTypes() {
        return stockTypes;
    }

    public void setStockTypes(List<EnumStockType> stockTypes) {
        this.stockTypes = stockTypes;
    }

}
