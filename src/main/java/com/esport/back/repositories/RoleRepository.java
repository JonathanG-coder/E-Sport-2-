package com.esport.back.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esport.back.models.RoleModel;

/**
 * Interface de dépôt pour les opérations CRUD sur les objets RoleModel.
 */
public interface RoleRepository extends CrudRepository<RoleModel, Long> {
}