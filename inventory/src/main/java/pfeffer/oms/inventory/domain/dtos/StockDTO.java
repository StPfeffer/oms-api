package pfeffer.oms.inventory.domain.dtos;

import pfeffer.oms.inventory.domain.enums.EnumStockType;

public class StockDTO {

    /**
     * O ID do SKU no qual o estoque está vinculado.
     */
    private String skuId;

    /**
     * O ID da filial na qual o estoque pertence.
     */
    private LocationDTO location;

    /**
     * O saldo total para o respectivo SKU.
     */
    private Integer quantity;

    /**
     * A proteção de estoque para o respectivo SKU.
     */
    private Integer threshold;

    /**
     * O tipo do estoque.
     */
    private EnumStockType stockType;

    /**
     * Determina se esse saldo está disponível para o respectivo SKU.
     */
    private boolean enabled;

}
