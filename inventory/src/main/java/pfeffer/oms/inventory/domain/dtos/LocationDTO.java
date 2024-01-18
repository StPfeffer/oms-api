package pfeffer.oms.inventory.domain.dtos;

import pfeffer.oms.core.domain.dtos.AddressDTO;

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
     * As informações de endereço da filial.
     */
    private AddressDTO address;

    /**
     * A data de criação da filial.
     */
    private Date createdAt;

    /**
     * A data da última atualização da filial.
     */
    private Date updatedAt;

}
