package pfeffer.oms.inventory.domain.entities;

public class ChannelBO {
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

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

}
