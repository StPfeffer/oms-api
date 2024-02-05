package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.AddressBO;
import pfeffer.oms.inventory.domain.entities.CustomerBO;
import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.domain.entities.TelephoneBO;
import pfeffer.oms.inventory.domain.enums.EnumCustomerType;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaAddress;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaCustomer;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaDocument;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaTelephone;

import java.util.List;

public class JakartaCustomerMapper {

    public static JakartaCustomer toEntity(CustomerBO bo) {
        JakartaCustomer entity = new JakartaCustomer();

        entity.setCustomerId(bo.getId());
        entity.setFirstName(bo.getFirstName());
        entity.setLastName(bo.getLastName());
        entity.setFullName(bo.getFullName());
        entity.setEmail(bo.getEmail());
        entity.setBirthdate(bo.getBirthdate());
        entity.setType(bo.getType() == null ? EnumCustomerType.INDIVIDUAL : bo.getType());

        List<JakartaAddress> addresses = bo.getAddresses().stream().map(JakartaAddressMapper::toEntity).toList();
        addresses.forEach(address -> address.setCustomer(entity));

        entity.setAddresses(addresses);

        if (bo.getTelephones() != null && bo.getTelephones().size() > 0) {
            List<JakartaTelephone> telephones = bo.getTelephones().stream().map(JakartaTelephoneMapper::toEntity).toList();
            telephones.forEach(telephone -> telephone.setCustomer(entity));

            entity.setTelephones(telephones);
        }

        if (bo.getDocuments() != null && bo.getDocuments().size() > 0) {
            List<JakartaDocument> documents = bo.getDocuments().stream().map(JakartaDocumentMapper::toEntity).toList();
            documents.forEach(document -> document.setCustomer(entity));

            entity.setDocuments(documents);
        }

        return entity;
    }

    public static CustomerBO toDomain(JakartaCustomer entity) {
        CustomerBO bo = new CustomerBO();

        bo.setId(entity.getCustomerId());
        bo.setFirstName(entity.getFirstName());
        bo.setLastName(entity.getLastName());
        bo.setFullName(entity.getFullName());
        bo.setEmail(entity.getEmail());
        bo.setBirthdate(entity.getBirthdate());
        bo.setType(entity.getType());

        List<AddressBO> addresses = entity.getAddresses().stream().map(JakartaAddressMapper::toDomain).toList();
        List<TelephoneBO> telephones = entity.getTelephones().stream().map(JakartaTelephoneMapper::toDomain).toList();
        List<DocumentBO> documents = entity.getDocuments().stream().map(JakartaDocumentMapper::toDomain).toList();

        bo.setAddresses(addresses);
        bo.setTelephones(telephones);
        bo.setDocuments(documents);

        return bo;
    }

}
