package pfeffer.oms.core.domain.usecases;

import pfeffer.oms.core.domain.dtos.DocumentDTO;
import pfeffer.oms.core.domain.entities.DocumentBO;
import pfeffer.oms.core.domain.mappers.DocumentMapper;
import pfeffer.oms.core.domain.repositories.IDocumentDataBaseRepository;

public class CreateDocument {

    private final IDocumentDataBaseRepository repository;

    public CreateDocument(IDocumentDataBaseRepository repository) {
        this.repository = repository;
    }

    public DocumentDTO execute(DocumentDTO dto) {
        DocumentBO entity = repository.persist(DocumentMapper.toBO(dto));

        return DocumentMapper.toDTO(entity);
    }

}