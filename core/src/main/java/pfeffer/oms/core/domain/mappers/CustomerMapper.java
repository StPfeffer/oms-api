package pfeffer.oms.core.domain.mappers;

import pfeffer.oms.core.domain.dtos.AddressDTO;
import pfeffer.oms.core.domain.dtos.CustomerDTO;
import pfeffer.oms.core.domain.dtos.DocumentDTO;
import pfeffer.oms.core.domain.dtos.TelephoneDTO;
import pfeffer.oms.core.domain.entities.AddressBO;
import pfeffer.oms.core.domain.entities.CustomerBO;
import pfeffer.oms.core.domain.entities.DocumentBO;
import pfeffer.oms.core.domain.entities.TelephoneBO;

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
