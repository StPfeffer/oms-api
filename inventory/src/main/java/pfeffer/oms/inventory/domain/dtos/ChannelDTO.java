package pfeffer.oms.inventory.domain.dtos;

public class ChannelDTO {

    private String channelId;

    private boolean isDefault;

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

}
