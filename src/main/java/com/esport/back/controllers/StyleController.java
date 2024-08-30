package com.esport.back.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.StyleModel;
import com.esport.back.services.StyleService;

/**
 * Contrôleur REST pour gérer les opérations liées aux styles.
 */
@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/style")
public class StyleController {

	/**
	 * Service utilisé pour gérer les opérations sur les styles.
	 */
	private final StyleService styleService;

	/**
	 * Constructeur pour initialiser le service de gestion des styles.
	 * 
	 * @param styleService
	 */
	public StyleController(StyleService styleService) {
		this.styleService = styleService;
	}

	/**
	 * Crée un nouveau style.
	 * 
	 * Le style est fourni dans le corps de la requête.
	 * 
	 * @param styleModel
	 * @return
	 */
	@PostMapping
	public StyleModel createStyleModel(@RequestBody StyleModel styleModel) {
		return styleService.createStyleModel(styleModel);
	}

	/**
	 * Retourne la liste complète des styles existants.
	 * 
	 * @return
	 */
	@GetMapping
	public List<StyleModel> getAllStyleModels() {
		return styleService.getAllStyleModels();
	}

	/**
	 * Retourne un style spécifique en utilisant son identifiant.
	 * 
	 * L'identifiant du style est passé en paramètre de l'URL.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<StyleModel> getStyleModelById(@PathVariable Long id) {
		return styleService.getStyleModelById(id);
	}

	/**
	 * Met à jour un style existant.
	 * 
	 * L'identifiant du style à mettre à jour est passé en paramètre de l'URL.
	 * 
	 * Le style mis à jour est fourni dans le corps de la requête.
	 * 
	 * @param id
	 * @param styleModel
	 * @return
	 */
	@PutMapping("/{id}")
	public StyleModel updateStyleModel(@PathVariable Long id, @RequestBody StyleModel styleModel) {
		return styleService.updateStyleModel(id, styleModel);
	}

	/**
	 * Supprime un style par son identifiant.
	 * 
	 * L'identifiant du style à supprimer est passé en paramètre de l'URL.
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteStyleModel(@PathVariable Long id) {
		styleService.deleteStyleModel(id);
	}

}