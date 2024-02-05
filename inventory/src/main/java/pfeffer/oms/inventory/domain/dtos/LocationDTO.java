package pfeffer.oms.inventory.domain.dtos;

import java.util.Date;
import java.util.List;

public class LocationDTO {

    private String id;

    private String tradingName;

    private String alias;

    private String name;

    private String description;

    private AddressDTO address;

    private List<TelephoneDTO> telephones;

    private List<DocumentDTO> documents;

    private List<LocationChannelDTO> channels;

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<TelephoneDTO> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneDTO> telephones) {
        this.telephones = telephones;
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }

    public List<LocationChannelDTO> getChannels() {
        return channels;
    }

    public void setChannels(List<LocationChannelDTO> channels) {
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
