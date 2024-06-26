package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.*;
import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.domain.entities.LocationBO;
import pfeffer.oms.inventory.domain.entities.LocationChannelBO;
import pfeffer.oms.inventory.domain.entities.TelephoneBO;

import java.util.ArrayList;
import java.util.List;

public class LocationMapper {

    public static LocationDTO toDTO(LocationBO bo) {
        LocationDTO dto = new LocationDTO();

        dto.setId(bo.getId());
        dto.setTradingName(bo.getTradingName());
        dto.setAlias(bo.getAlias());
        dto.setName(bo.getName());
        dto.setDescription(bo.getDescription());
        dto.setAddress(AddressMapper.toDTO(bo.getAddress()));

        if (bo.getTelephones() != null && !bo.getTelephones().isEmpty()) {
            List<TelephoneDTO> telephones = bo.getTelephones().stream().map(TelephoneMapper::toDTO).toList();
            dto.setTelephones(telephones);
        }

        if (bo.getDocuments() != null && !bo.getDocuments().isEmpty()) {
            List<DocumentDTO> documents = bo.getDocuments().stream().map(DocumentMapper::toDTO).toList();
            dto.setDocuments(documents);
        }

        List<LocationChannelBO> channelsBO = bo.getChannels();

        if (channelsBO == null || channelsBO.isEmpty()) {
            dto.setChannels(new ArrayList<>());
        } else {
            List<LocationChannelDTO> channels = bo.getChannels().stream().map(LocationChannelMapper::toDTO).toList();
            dto.setChannels(channels);
        }

        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        return dto;
    }

    public static LocationBO toBO(LocationDTO dto) {
        LocationBO bo = new LocationBO();

        bo.setId(dto.getId());
        bo.setTradingName(dto.getTradingName());
        bo.setAlias(dto.getAlias());
        bo.setName(dto.getName());
        bo.setDescription(dto.getDescription());
        bo.setAddress(AddressMapper.toBO(dto.getAddress()));

        if (dto.getTelephones() != null && !dto.getTelephones().isEmpty()) {
            List<TelephoneBO> telephones = dto.getTelephones().stream().map(TelephoneMapper::toBO).toList();
            bo.setTelephones(telephones);
        }

        if (dto.getDocuments() != null && !dto.getDocuments().isEmpty()) {
            List<DocumentBO> documents = dto.getDocuments().stream().map(DocumentMapper::toBO).toList();
            bo.setDocuments(documents);
        }

        List<LocationChannelDTO> channelsBO = dto.getChannels();

        if (channelsBO == null || channelsBO.isEmpty()) {
            bo.setChannels(new ArrayList<>());
        } else {
            List<LocationChannelBO> channels = dto.getChannels().stream().map(LocationChannelMapper::toBO).toList();
            bo.setChannels(channels);
        }

        bo.setCreatedAt(dto.getCreatedAt());
        bo.setUpdatedAt(dto.getUpdatedAt());

        return bo;
    }

}
