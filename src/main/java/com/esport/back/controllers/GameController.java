package com.esport.back.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.GameModel;
import com.esport.back.services.GameService;

/**
 * Contrôleur REST pour gérer les opérations liées aux jeux.
 */
@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/game")
public class GameController {

	/**
	 * Service utilisé pour gérer les opérations liées aux jeux.
	 */
	private final GameService gameService;

	/**
	 * Constructeur pour initialiser le service de gestion des jeux.
	 * 
	 * @param gameService
	 */
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	/**
	 * Crée un nouveau jeu.
	 * 
	 * Le jeu est fourni dans le corps de la requête.
	 * 
	 * @param gameModel
	 * @return
	 */
	@PostMapping
	public GameModel createGameModel(@RequestBody GameModel gameModel) {
		return gameService.createGameModel(gameModel);
	}

	/**
	 * Retourne la liste complète des jeux existants.
	 * 
	 * @return
	 */
	@GetMapping
	public List<GameModel> getAllGameModels() {
		return gameService.getAllGameModels();
	}

	/**
	 * Retourne un jeu spécifique en utilisant son identifiant.
	 * 
	 * L'identifiant du jeu est passé en paramètre de l'URL.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<GameModel> getGameModelById(@PathVariable Long id) {
		return gameService.getGameModelById(id);
	}

	/**
	 * Met à jour un jeu existant.
	 * 
	 * L'identifiant du jeu à mettre à jour est passé en paramètre de l'URL.
	 * 
	 * Le jeu mis à jour est fourni dans le corps de la requête.
	 * 
	 * @param id
	 * @param gameModel
	 * @return
	 */
	@PutMapping("/{id}")
	public GameModel updateGameModel(@PathVariable Long id, @RequestBody GameModel gameModel) {
		return gameService.updateGameModel(id, gameModel);
	}

	/**
	 * Supprime un jeu par son identifiant.
	 * 
	 * L'identifiant du jeu à supprimer est passé en paramètre de l'URL.
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteGameModel(@PathVariable Long id) {
		gameService.deleteGameModel(id);
	}

}