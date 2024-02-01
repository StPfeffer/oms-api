package pfeffer.oms.inventory.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.domain.repositories.IDocumentDataBaseRepository;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaDocumentMapper;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaDocument;

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

    public DocumentBO findByDocument(DocumentBO bo) {
        TypedQuery<JakartaDocument> query = em.createQuery("SELECT e FROM JakartaDocument e WHERE e.type = :type AND e.number = :number", JakartaDocument.class)
                .setParameter("type", bo.getType())
                .setParameter("number", bo.getNumber());

        try {
            return JakartaDocumentMapper.toDomain(query.getSingleResult());
        } catch (NoResultException e) {
            return null;
        }
    }

}
