package pfeffer.oms.inventory.domain.dtos;

public class StockDTO {

    /**
     * O ID do SKU no qual o estoque está vinculado.
     */
    private String skuId;

    /**
     * O ID da filial na qual o estoque pertence.
     */
    private String locationId;

    /**
     * O saldo total para o respectivo SKU.
     */
    private Integer quantity;

    /**
     * A proteção de estoque para o respectivo SKU.
     */
    private Integer threshold;

}
