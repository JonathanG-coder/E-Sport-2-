package com.esport.back.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esport.back.models.MemberModel;

/**
 * Interface de dépôt pour les opérations CRUD sur les objets MemberModel.
 */
public interface MemberRepository extends CrudRepository<MemberModel, Long> {
}