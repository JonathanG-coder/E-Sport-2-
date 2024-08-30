package com.esport.back.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNull;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.Member_has_role_Model;
import com.esport.back.models.Member_has_role_ModelId;
import com.esport.back.repositories.Member_has_role_Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service pour gérer les opérations liées aux objets Member_has_role_Model.
 */
@Service
public class Member_has_role_Service {

	/**
	 * Logger pour le suivi des opérations de service.
	 */
	static final Logger LOG = LoggerFactory.getLogger(Member_has_role_Model.class);

	/**
	 * Repository pour les opérations CRUD sur Member_has_role_Model.
	 */
	private final Member_has_role_Repository member_has_role_Repository;

	/**
	 * Constructeur pour initialiser Member_has_role_Service avec le
	 * Member_has_role_Repository.
	 * 
	 * @param member_has_role_Repository
	 */
	public Member_has_role_Service(Member_has_role_Repository member_has_role_Repository) {
		this.member_has_role_Repository = member_has_role_Repository;
	}

	/**
	 * Crée une nouvelle association entre membre et rôle dans la base de données.
	 * 
	 * @param member_has_role_Model
	 * @return
	 */
	@Transactional
	public Member_has_role_Model createMember_has_role_Model(@NonNull Member_has_role_Model member_has_role_Model) {
		return this.member_has_role_Repository.save(member_has_role_Model);
	}

	/**
	 * Récupère toutes les associations entre membres et rôles de la base de
	 * données.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Member_has_role_Model> getAllMember_has_role_Models() {
		return (List<Member_has_role_Model>) this.member_has_role_Repository.findAll();
	}

	/**
	 * Récupère une association entre membre et rôle par ses identifiants.
	 * 
	 * @param id_member
	 * @param id_team
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<Member_has_role_Model> getMember_has_role_ModelById(@NonNull Long id_member,
			@NonNull Long id_team) {
		Member_has_role_ModelId id = new Member_has_role_ModelId();
		id.setId_member(id_member);
		id.setId_team(id_team);
		return this.member_has_role_Repository.findById(id);
	}

	/**
	 * Met à jour une association entre membre et rôle existante dans la base de
	 * données.
	 * 
	 * @param id_member
	 * @param id_team
	 * @param updatedMember_has_role_Model
	 * @return
	 */
	@Transactional
	public Member_has_role_Model updateMember_has_role_Model(@NonNull Long id_member, @NonNull Long id_team,
			@NonNull Member_has_role_Model updatedMember_has_role_Model) {

		// Vérifie si l'identifiant est différent de celui du modèle mis à jour
		if (!id_team.equals(updatedMember_has_role_Model.getTeam().getId_team())
				&& !id_member.equals(updatedMember_has_role_Model.getMember().getId_member())) {
			throw new RuntimeException("Changing id is not allowed !");
		}

		// Vérifie si les données existent
		Optional<Member_has_role_Model> optionalMember_has_role_Model = this.member_has_role_Repository
				.findById(updatedMember_has_role_Model.getId());
		if (optionalMember_has_role_Model.isPresent()) {
			// Met à jour les données
			return this.member_has_role_Repository.save(updatedMember_has_role_Model);
		} else {
			throw new RuntimeException(
					"Member_has_role_Model not found with id " + updatedMember_has_role_Model.getId());
		}
	}

	/**
	 * Supprime une association entre membre et rôle de la base de données.
	 * 
	 * @param id_member
	 * @param id_team
	 */
	@Transactional
	public void deleteMember_has_role_Model(@NonNull Long id_member, @NonNull Long id_team) {
		Member_has_role_ModelId id = new Member_has_role_ModelId();
		id.setId_member(id_member);
		id.setId_team(id_team);
		Optional<Member_has_role_Model> optionalMember_has_role_Model = this.member_has_role_Repository.findById(id);
		if (optionalMember_has_role_Model.isPresent()) {
			this.member_has_role_Repository.deleteById(id);
		} else {
			throw new RuntimeException("Member_has_role_Model not found with id " + id);
		}
	}

}