package com.esport.back.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.RoleModel;
import com.esport.back.services.RoleService;

/**
 * Contrôleur REST pour gérer les opérations liées aux rôles.
 */
@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/role")
public class RoleController {

	/**
	 * Service utilisé pour gérer les opérations sur les rôles.
	 */
	private final RoleService roleService;

	/**
	 * Constructeur pour initialiser le service de gestion des rôles.
	 * 
	 * @param roleService
	 */
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * Crée un nouveau rôle.
	 * 
	 * Le rôle est fourni dans le corps de la requête.
	 * 
	 * @param roleModel
	 * @return
	 */
	@PostMapping
	public RoleModel createRoleModel(@RequestBody RoleModel roleModel) {
		return roleService.createRoleModel(roleModel);
	}

	/**
	 * Retourne la liste complète des rôles existants.
	 * 
	 * @return
	 */
	@GetMapping
	public List<RoleModel> getAllRoleModels() {
		return roleService.getAllRoleModels();
	}

	/**
	 * Retourne un rôle spécifique en utilisant son identifiant.
	 * 
	 * L'identifiant du rôle est passé en paramètre de l'URL.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<RoleModel> getRoleModelById(@PathVariable Long id) {
		return roleService.getRoleModelById(id);
	}

	/**
	 * Met à jour un rôle existant.
	 * 
	 * L'identifiant du rôle à mettre à jour est passé en paramètre de l'URL.
	 * 
	 * Le rôle mis à jour est fourni dans le corps de la requête.
	 * 
	 * @param id
	 * @param roleModel
	 * @return
	 */
	@PutMapping("/{id}")
	public RoleModel updateRoleModel(@PathVariable Long id, @RequestBody RoleModel roleModel) {
		return roleService.updateRoleModel(id, roleModel);
	}

	/**
	 * Supprime un rôle par son identifiant.
	 * 
	 * L'identifiant du rôle à supprimer est passé en paramètre de l'URL.
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteRoleModel(@PathVariable Long id) {
		roleService.deleteRoleModel(id);
	}

}