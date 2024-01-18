package pfeffer.oms.inventory.domain.dtos;

public class ChannelDTO {

    /**
     * O ID do canal de vendas.
     */
    private Integer id;

    /**
     * O nome do canal de vendas.
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
