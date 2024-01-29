package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.AddressDTO;
import pfeffer.oms.inventory.domain.dtos.CustomerDTO;
import pfeffer.oms.inventory.domain.dtos.DocumentDTO;
import pfeffer.oms.inventory.domain.dtos.TelephoneDTO;
import pfeffer.oms.inventory.domain.entities.AddressBO;
import pfeffer.oms.inventory.domain.entities.CustomerBO;
import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.domain.entities.TelephoneBO;

import java.util.List;

public class CustomerMapper {

    public static CustomerDTO toDTO(CustomerBO bo) {
        CustomerDTO dto = new CustomerDTO();

        dto.setId(bo.getId());
        dto.setFirstName(bo.getFirstName());
        dto.setLastName(bo.getLastName());
        dto.setFullName(bo.getFullName());
        dto.setEmail(bo.getEmail());
        dto.setBirthdate(bo.getBirthdate());
        dto.setType(bo.getType());

        List<AddressDTO> addresses = bo.getAddresses().stream().map(AddressMapper::toDTO).toList();
        List<TelephoneDTO> telephones = bo.getTelephones().stream().map(TelephoneMapper::toDTO).toList();
        List<DocumentDTO> documents = bo.getDocuments().stream().map(DocumentMapper::toDTO).toList();

        dto.setAddresses(addresses);
        dto.setTelephones(telephones);
        dto.setDocuments(documents);

        return dto;
    }

    public static CustomerBO toBO(CustomerDTO dto) {
        CustomerBO bo = new CustomerBO();

        bo.setId(dto.getId());
        bo.setFirstName(dto.getFirstName());
        bo.setLastName(dto.getLastName());
        bo.setFullName(dto.getFullName());
        bo.setEmail(dto.getEmail());
        bo.setBirthdate(dto.getBirthdate());
        bo.setType(dto.getType());

        List<AddressBO> addresses = dto.getAddresses().stream().map(AddressMapper::toBO).toList();
        List<TelephoneBO> telephones = dto.getTelephones().stream().map(TelephoneMapper::toBO).toList();
        List<DocumentBO> documents = dto.getDocuments().stream().map(DocumentMapper::toBO).toList();

        bo.setAddresses(addresses);
        bo.setTelephones(telephones);
        bo.setDocuments(documents);

        return bo;
    }

}
