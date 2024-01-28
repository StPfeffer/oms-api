package pfeffer.oms.core.infra.jakarta.mappers;

import pfeffer.oms.core.domain.entities.AddressBO;
import pfeffer.oms.core.domain.entities.CustomerBO;
import pfeffer.oms.core.domain.entities.DocumentBO;
import pfeffer.oms.core.domain.entities.TelephoneBO;
import pfeffer.oms.core.infra.jakarta.model.JakartaAddress;
import pfeffer.oms.core.infra.jakarta.model.JakartaCustomer;
import pfeffer.oms.core.infra.jakarta.model.JakartaDocument;
import pfeffer.oms.core.infra.jakarta.model.JakartaTelephone;

import java.util.List;

public class JakartaCustomerMapper {

    public static JakartaCustomer toEntity(CustomerBO bo) {
        JakartaCustomer dto = new JakartaCustomer();

        dto.setCustomerId(bo.getId());
        dto.setFirstName(bo.getFirstName());
        dto.setLastName(bo.getLastName());
        dto.setFullName(bo.getFullName());
        dto.setEmail(bo.getEmail());
        dto.setBirthdate(bo.getBirthdate());
        dto.setType(bo.getType());

        List<JakartaAddress> addresses = bo.getAddresses().stream().map(JakartaAddressMapper::toEntity).toList();
        List<JakartaTelephone> telephones = bo.getTelephones().stream().map(JakartaTelephoneMapper::toEntity).toList();
        List<JakartaDocument> documents = bo.getDocuments().stream().map(JakartaDocumentMapper::toEntity).toList();

        dto.setAddresses(addresses);
        dto.setTelephones(telephones);
        dto.setDocuments(documents);

        return dto;
    }

    public static CustomerBO toDomain(JakartaCustomer dto) {
        CustomerBO bo = new CustomerBO();

        bo.setId(dto.getCustomerId());
        bo.setFirstName(dto.getFirstName());
        bo.setLastName(dto.getLastName());
        bo.setFullName(dto.getFullName());
        bo.setEmail(dto.getEmail());
        bo.setBirthdate(dto.getBirthdate());
        bo.setType(dto.getType());

        List<AddressBO> addresses = dto.getAddresses().stream().map(JakartaAddressMapper::toDomain).toList();
        List<TelephoneBO> telephones = dto.getTelephones().stream().map(JakartaTelephoneMapper::toDomain).toList();
        List<DocumentBO> documents = dto.getDocuments().stream().map(JakartaDocumentMapper::toDomain).toList();

        bo.setAddresses(addresses);
        bo.setTelephones(telephones);
        bo.setDocuments(documents);

        return bo;
    }

}
