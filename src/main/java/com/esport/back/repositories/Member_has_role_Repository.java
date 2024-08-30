package com.esport.back.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esport.back.models.Member_has_role_Model;
import com.esport.back.models.Member_has_role_ModelId;

/**
 * Interface de dépôt pour les opérations CRUD sur les objets
 * Member_has_role_Model.
 */
public interface Member_has_role_Repository extends CrudRepository<Member_has_role_Model, Member_has_role_ModelId> {
}