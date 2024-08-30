package com.esport.back.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esport.back.models.StyleModel;

/**
 * Interface de dépôt pour les opérations CRUD sur les objets StyleModel.
 */
public interface StyleRepository extends CrudRepository<StyleModel, Long> {
}