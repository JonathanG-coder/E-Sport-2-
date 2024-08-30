package com.esport.back.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esport.back.models.TeamModel;

/**
 * Interface de dépôt pour les opérations CRUD sur les objets TeamModel.
 */
public interface TeamRepository extends CrudRepository<TeamModel, Long> {
}