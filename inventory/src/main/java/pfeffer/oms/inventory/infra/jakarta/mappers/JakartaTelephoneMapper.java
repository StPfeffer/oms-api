package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.TelephoneBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaTelephone;

public class JakartaTelephoneMapper {

    public static JakartaTelephone toEntity(TelephoneBO bo) {
        JakartaTelephone entity = new JakartaTelephone();

        entity.setDdi(bo.getDdi());
        entity.setDdd(bo.getDdd());
        entity.setNumber(bo.getNumber());
        entity.setType(bo.getType());

        return entity;
    }

    public static TelephoneBO toDomain(JakartaTelephone entity) {
        TelephoneBO bo = new TelephoneBO();

        bo.setDdi(entity.getDdi());
        bo.setDdd(entity.getDdd());
        bo.setNumber(entity.getNumber());
        bo.setType(entity.getType());

        return bo;
    }

}