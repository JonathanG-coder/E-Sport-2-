package com.esport.back.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNull;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.RoleModel;
import com.esport.back.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service pour gérer les opérations liées aux objets RoleModel.
 */
@Service
public class RoleService {

	/**
	 * Logger pour le suivi des opérations de service.
	 */
	static final Logger LOG = LoggerFactory.getLogger(RoleModel.class);

	/**
	 * Repository pour les opérations CRUD sur RoleModel.
	 */
	private final RoleRepository roleRepository;

	/**
	 * Constructeur pour initialiser RoleService avec le RoleRepository.
	 * 
	 * @param roleRepository
	 */
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	/**
	 * Crée un nouveau RoleModel dans la base de données.
	 * 
	 * @param roleModel
	 * @return
	 */
	@Transactional
	public RoleModel createRoleModel(@NonNull RoleModel roleModel) {
		return this.roleRepository.save(roleModel);
	}

	/**
	 * Récupère tous les RoleModels de la base de données.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<RoleModel> getAllRoleModels() {
		return (List<RoleModel>) this.roleRepository.findAll();
	}

	/**
	 * Récupère un RoleModel par son identifiant.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<RoleModel> getRoleModelById(@NonNull Long id) {
		return this.roleRepository.findById(id);
	}

	/**
	 * Met à jour un RoleModel existant dans la base de données.
	 * 
	 * @param id
	 * @param updatedRoleModel
	 * @return
	 */
	@Transactional
	public RoleModel updateRoleModel(@NonNull Long id, @NonNull RoleModel updatedRoleModel) {

		// Vérifie si l'identifiant est différent de celui du modèle mis à jour
		if (!id.equals(updatedRoleModel.getId_role())) {
			throw new RuntimeException("Changing id is not allowed !");
		}

		// Vérifie si les données existent
		Optional<RoleModel> optionalRoleModel = this.roleRepository.findById(updatedRoleModel.getId_role());
		if (optionalRoleModel.isPresent()) {
			// Met à jour les données
			return this.roleRepository.save(updatedRoleModel);
		} else {
			throw new RuntimeException("RoleModel not found with id " + updatedRoleModel.getId_role());
		}
	}

	/**
	 * Supprime un RoleModel de la base de données.
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteRoleModel(@NonNull Long id) {
		Optional<RoleModel> optionalRoleModel = this.roleRepository.findById(id);
		if (optionalRoleModel.isPresent()) {
			this.roleRepository.deleteById(id);
		} else {
			throw new RuntimeException("RoleModel not found with id " + id);
		}
	}

}