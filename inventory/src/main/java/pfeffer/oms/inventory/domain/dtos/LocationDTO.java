package pfeffer.oms.inventory.domain.dtos;

import java.util.Date;

public class LocationDTO {

    /**
     * O ID da filial.
     */
    private String id;

    /**
     * O nome fantasia da filial.
     */
    private String tradingName;

    /**
     * O apelido da filial.
     */
    private String alias;

    /**
     * A razão social da filial.
     */
    private String name;

    /**
     * A descrição da filial.
     */
    private String description;

    /**
     * O CEP da filial.
     */
    private String zip;

    /**
     * A data de criação da filial.
     */
    private Date createdAt;

    /**
     * A data da última atualização da filial.
     */
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
