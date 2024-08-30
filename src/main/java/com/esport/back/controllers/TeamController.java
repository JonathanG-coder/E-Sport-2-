package com.esport.back.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.TeamModel;
import com.esport.back.services.TeamService;

/**
 * Contrôleur REST pour gérer les opérations liées aux équipes.
 */
@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/team")
public class TeamController {

	/**
	 * Service utilisé pour gérer les opérations sur les équipes.
	 */
	private final TeamService teamService;

	/**
	 * Constructeur pour initialiser le service de gestion des équipes.
	 * 
	 * @param teamService
	 */
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	/**
	 * Crée une nouvelle équipe.
	 * 
	 * L'équipe est fournie dans le corps de la requête.
	 * 
	 * @param teamModel
	 * @return
	 */
	@PostMapping
	public TeamModel createTeamModel(@RequestBody TeamModel teamModel) {
		return teamService.createTeamModel(teamModel);
	}

	/**
	 * Retourne la liste complète des équipes existantes.
	 * 
	 * @return
	 */
	@GetMapping
	public List<TeamModel> getAllTeamModels() {
		return teamService.getAllTeamModels();
	}

	/**
	 * Retourne une équipe spécifique en utilisant son identifiant.
	 * 
	 * L'identifiant de l'équipe est passé en paramètre de l'URL.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<TeamModel> getTeamModelById(@PathVariable Long id) {
		return teamService.getTeamModelById(id);
	}

	/**
	 * Met à jour une équipe existante.
	 * 
	 * L'identifiant de l'équipe à mettre à jour est passé en paramètre de l'URL.
	 * 
	 * L'équipe mise à jour est fournie dans le corps de la requête.
	 * 
	 * @param id
	 * @param teamModel
	 * @return
	 */
	@PutMapping("/{id}")
	public TeamModel updateTeamModel(@PathVariable Long id, @RequestBody TeamModel teamModel) {
		return teamService.updateTeamModel(id, teamModel);
	}

	/**
	 * Supprime une équipe par son identifiant.
	 * 
	 * L'identifiant de l'équipe à supprimer est passé en paramètre de l'URL.
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteTeamModel(@PathVariable Long id) {
		teamService.deleteTeamModel(id);
	}

}