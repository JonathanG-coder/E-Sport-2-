package com.esport.back.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNull;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.GameModel;
import com.esport.back.repositories.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service pour gérer les opérations liées aux objets GameModel.
 */
@Service
public class GameService {

	/**
	 * Logger pour le suivi des opérations de service.
	 */
	static final Logger LOG = LoggerFactory.getLogger(GameModel.class);

	/**
	 * Repository pour les opérations CRUD sur GameModel.
	 */
	private final GameRepository gameRepository;

	/**
	 * Constructeur pour initialiser GameService avec le GameRepository.
	 * 
	 * @param gameRepository
	 */
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	/**
	 * Crée un nouveau GameModel dans la base de données.
	 * 
	 * @param gameModel
	 * @return
	 */
	@Transactional
	public GameModel createGameModel(@NonNull GameModel gameModel) {
		return this.gameRepository.save(gameModel);
	}

	/**
	 * Récupère tous les GameModels de la base de données.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<GameModel> getAllGameModels() {
		return (List<GameModel>) this.gameRepository.findAll();
	}

	/**
	 * Récupère un GameModel par son identifiant.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<GameModel> getGameModelById(@NonNull Long id) {
		return this.gameRepository.findById(id);
	}

	/**
	 * Met à jour un GameModel existant dans la base de données.
	 * 
	 * @param id
	 * @param updatedGameModel
	 * @return
	 */
	@Transactional
	public GameModel updateGameModel(@NonNull Long id, @NonNull GameModel updatedGameModel) {

		// Vérifie si l'identifiant est différent de celui du modèle mis à jour
		if (!id.equals(updatedGameModel.getId_game())) {
			throw new RuntimeException("Changing id is not allowed !");
		}

		// Vérifie si les données existent
		Optional<GameModel> optionalGameModel = this.gameRepository.findById(updatedGameModel.getId_game());
		if (optionalGameModel.isPresent()) {
			// Met à jour les données
			return this.gameRepository.save(updatedGameModel);
		} else {
			throw new RuntimeException("GameModel not found with id " + updatedGameModel.getId_game());
		}
	}

	/**
	 * Supprime un GameModel de la base de données.
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteGameModel(@NonNull Long id) {
		Optional<GameModel> optionalGameModel = this.gameRepository.findById(id);
		if (optionalGameModel.isPresent()) {
			this.gameRepository.deleteById(id);
		} else {
			throw new RuntimeException("GameModel not found with id " + id);
		}
	}

}