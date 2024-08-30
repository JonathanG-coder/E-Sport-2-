package com.esport.back.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNull;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.TeamModel;
import com.esport.back.repositories.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service pour gérer les opérations liées aux objets TeamModel.
 */
@Service
public class TeamService {

	/**
	 * Logger pour le suivi des opérations de service
	 */
	static final Logger LOG = LoggerFactory.getLogger(TeamModel.class);

	/**
	 * Repository pour les opérations CRUD sur TeamModel.
	 */
	private final TeamRepository teamRepository;

	/**
	 * Constructeur pour initialiser TeamService avec le TeamRepository.
	 * 
	 * @param teamRepository
	 */
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	/**
	 * Crée une nouvelle équipe dans la base de données.
	 * 
	 * @param teamModel
	 * @return
	 */
	@Transactional
	public TeamModel createTeamModel(@NonNull TeamModel teamModel) {
		return this.teamRepository.save(teamModel);
	}

	/**
	 * Récupère toutes les équipes de la base de données.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<TeamModel> getAllTeamModels() {
		return (List<TeamModel>) this.teamRepository.findAll();
	}

	/**
	 * Récupère une équipe par son identifiant.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<TeamModel> getTeamModelById(@NonNull Long id) {
		return this.teamRepository.findById(id);
	}

	/**
	 * Met à jour une équipe existante dans la base de données.
	 * 
	 * @param id
	 * @param updatedTeamModel
	 * @return
	 */
	@Transactional
	public TeamModel updateTeamModel(@NonNull Long id, @NonNull TeamModel updatedTeamModel) {

		// Vérifie si l'identifiant est différent de celui du modèle mis à jour
		if (!id.equals(updatedTeamModel.getId_team())) {
			throw new RuntimeException("Changing id is not allowed !");
		}

		// Vérifie si les données existent
		Optional<TeamModel> optionalTeamModel = this.teamRepository.findById(updatedTeamModel.getId_team());
		if (optionalTeamModel.isPresent()) {
			// Met à jour les données
			return this.teamRepository.save(updatedTeamModel);
		} else {
			throw new RuntimeException("TeamModel not found with id " + updatedTeamModel.getId_team());
		}
	}

	/**
	 * Supprime une équipe de la base de données.
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteTeamModel(@NonNull Long id) {
		Optional<TeamModel> optionalTeamModel = this.teamRepository.findById(id);
		if (optionalTeamModel.isPresent()) {
			this.teamRepository.deleteById(id);
		} else {
			throw new RuntimeException("TeamModel not found with id " + id);
		}
	}

}