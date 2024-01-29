package pfeffer.oms.inventory.domain.usecases;

import pfeffer.oms.inventory.domain.dtos.DocumentDTO;
import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.domain.mappers.DocumentMapper;
import pfeffer.oms.inventory.domain.repositories.IDocumentDataBaseRepository;

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