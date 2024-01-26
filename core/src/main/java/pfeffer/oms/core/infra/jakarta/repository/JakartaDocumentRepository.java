package pfeffer.oms.core.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.core.domain.entities.DocumentBO;
import pfeffer.oms.core.domain.repositories.IDocumentDataBaseRepository;
import pfeffer.oms.core.infra.jakarta.mappers.JakartaDocumentMapper;
import pfeffer.oms.core.infra.jakarta.model.JakartaDocument;

@Service
public class JakartaDocumentRepository extends SimpleJpaRepository<JakartaDocument, Long> implements IDocumentDataBaseRepository {

    private final EntityManager em;

    @Autowired
    public JakartaDocumentRepository(EntityManager em) {
        super(JakartaDocument.class, em);
        this.em = em;
    }

    @Override
    public DocumentBO persist(DocumentBO bo) {
        JakartaDocument entity = JakartaDocumentMapper.toEntity(bo);

        em.persist(entity);
        em.flush();

        return JakartaDocumentMapper.toDomain(entity);
    }

    @Override
    public DocumentBO update(String id, DocumentBO documentBO) {
        throw new UnsupportedOperationException();
    }

}
