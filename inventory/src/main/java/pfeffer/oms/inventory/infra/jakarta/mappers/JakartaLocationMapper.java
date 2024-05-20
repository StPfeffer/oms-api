package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.entities.LocationChannelBO;
import pfeffer.oms.inventory.domain.entities.TelephoneBO;
import pfeffer.oms.inventory.infra.jakarta.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JakartaLocationMapper {

    public static JakartaLocation toEntity(LocationBO bo) {
        JakartaLocation entity = new JakartaLocation();

        entity.setLocationId(bo.getId());
        entity.setTradingName(bo.getTradingName());
        entity.setAlias(bo.getAlias());
        entity.setName(bo.getName());
        entity.setDescription(bo.getDescription());

        JakartaAddress jakartaAddress = JakartaAddressMapper.toEntity(bo.getAddress());
        jakartaAddress.setLocation(entity);

        entity.setAddress(jakartaAddress);

        if (bo.getTelephones() != null && !bo.getTelephones().isEmpty()) {
            List<JakartaTelephone> telephones = bo.getTelephones().stream().map(JakartaTelephoneMapper::toEntity).toList();
            telephones.forEach(telephone -> telephone.setLocation(entity));
            entity.setTelephones(telephones);
        }

        if (bo.getDocuments() != null && !bo.getDocuments().isEmpty()) {
            List<JakartaDocument> documents = bo.getDocuments().stream().map(JakartaDocumentMapper::toEntity).toList();
            documents.forEach(document -> document.setLocation(entity));
            entity.setDocuments(documents);
        }

        if (bo.getChannels() == null || bo.getChannels().isEmpty()) {
            entity.setChannels(new ArrayList<>());
        } else {
            List<JakartaLocationChannel> channels = bo.getChannels().stream().map(JakartaLocationChannelMapper::toEntity).toList();
            entity.setChannels(channels);
        }

        entity.setCreatedAt(bo.getCreatedAt() != null ? bo.getCreatedAt() : new Date());
        entity.setUpdatedAt(bo.getUpdatedAt() != null ? bo.getUpdatedAt() : new Date());

        return entity;
    }

    public static LocationBO toDomain(JakartaLocation entity) {
        LocationBO bo = new LocationBO();

        bo.setId(entity.getLocationId());
        bo.setTradingName(entity.getTradingName());
        bo.setAlias(entity.getAlias());
        bo.setName(entity.getName());
        bo.setDescription(entity.getDescription());
        bo.setAddress(JakartaAddressMapper.toDomain(entity.getAddress()));

        if (entity.getTelephones() != null && !entity.getTelephones().isEmpty()) {
            List<TelephoneBO> telephones = entity.getTelephones().stream().map(JakartaTelephoneMapper::toDomain).toList();
            bo.setTelephones(telephones);
        }

        if (entity.getDocuments() != null && !entity.getDocuments().isEmpty()) {
            List<DocumentBO> documents = entity.getDocuments().stream().map(JakartaDocumentMapper::toDomain).toList();
            bo.setDocuments(documents);
        }

        List<JakartaLocationChannel> jakartaChannels = entity.getChannels();

        if (jakartaChannels == null || jakartaChannels.isEmpty()) {
            bo.setChannels(new ArrayList<>());
        } else {
            List<LocationChannelBO> channels = entity.getChannels().stream().map(JakartaLocationChannelMapper::toDomain).toList();
            bo.setChannels(channels);
        }

        bo.setCreatedAt(entity.getCreatedAt());
        bo.setUpdatedAt(entity.getUpdatedAt());

        return bo;
    }

}
