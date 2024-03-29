package pfeffer.oms.inventory.domain.entities;

import java.util.Date;
import java.util.List;

public class LocationBO {

    private String id;

    private String tradingName;

    private String alias;

    private String name;

    private String description;

    private AddressBO address;

    private List<TelephoneBO> telephones;

    private List<DocumentBO> documents;

    private List<LocationChannelBO> channels;

    private Date createdAt;

    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddressBO getAddress() {
        return address;
    }

    public void setAddress(AddressBO address) {
        this.address = address;
    }

    public List<TelephoneBO> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneBO> telephones) {
        this.telephones = telephones;
    }

    public List<DocumentBO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentBO> documents) {
        this.documents = documents;
    }

    public List<LocationChannelBO> getChannels() {
        return channels;
    }

    public void setChannels(List<LocationChannelBO> channels) {
        this.channels = channels;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
