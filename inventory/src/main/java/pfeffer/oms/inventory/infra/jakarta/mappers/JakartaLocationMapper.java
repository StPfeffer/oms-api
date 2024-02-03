package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.entities.LocationChannelBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaDocument;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocationChannel;

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
        entity.setAddress(JakartaAddressMapper.toEntity(bo.getAddress()));

        List<JakartaDocument> documents = bo.getDocuments().stream().map(JakartaDocumentMapper::toEntity).toList();
        entity.setDocuments(documents);

        List<LocationChannelBO> channelsBO = bo.getChannels();

        if (channelsBO == null || channelsBO.isEmpty()) {
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

        List<DocumentBO> documents = entity.getDocuments().stream().map(JakartaDocumentMapper::toDomain).toList();
        bo.setDocuments(documents);

        List<JakartaLocationChannel> jakartaChannels = entity.getChannels();

        if (jakartaChannels == null || jakartaChannels.size() == 0) {
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
