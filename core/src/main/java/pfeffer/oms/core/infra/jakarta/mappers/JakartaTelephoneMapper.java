package pfeffer.oms.core.infra.jakarta.mappers;

import pfeffer.oms.core.domain.entities.TelephoneBO;
import pfeffer.oms.core.infra.jakarta.model.JakartaTelephone;

public class JakartaTelephoneMapper {

    public static JakartaTelephone toEntity(TelephoneBO bo) {
        JakartaTelephone entity = new JakartaTelephone();

        entity.setDdi(bo.getDdi());
        entity.setDdi(bo.getDdd());
        entity.setNumber(bo.getNumber());
        entity.setType(bo.getType());

        return entity;
    }

    public static TelephoneBO toDomain(JakartaTelephone entity) {
        TelephoneBO bo = new TelephoneBO();

        bo.setDdi(entity.getDdi());
        bo.setDdi(entity.getDdd());
        bo.setNumber(entity.getNumber());
        bo.setType(entity.getType());

        return bo;
    }

}