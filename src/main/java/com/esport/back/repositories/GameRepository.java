package com.esport.back.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esport.back.models.GameModel;

/**
 * Interface de dépôt pour les opérations CRUD sur les objets GameModel.
 */
public interface GameRepository extends CrudRepository<GameModel, Long> {
}