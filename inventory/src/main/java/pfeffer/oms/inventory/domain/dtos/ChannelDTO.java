package pfeffer.oms.inventory.domain.dtos;

public class ChannelDTO {

    /**
     * O ID do canal de vendas.
     */
    private Long id;

    /**
     * O nome do canal de vendas.
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
