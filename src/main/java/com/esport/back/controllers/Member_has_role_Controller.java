package com.esport.back.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.Member_has_role_Model;
import com.esport.back.services.Member_has_role_Service;

/**
 * Contrôleur REST pour gérer les opérations liées aux associations membre-rôle.
 */
@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/member_has_role")
public class Member_has_role_Controller {

	/**
	 * Service utilisé pour gérer les opérations liées aux associations membre-rôle.
	 */
	private final Member_has_role_Service member_has_role_Service;

	/**
	 * Constructeur pour initialiser le service de gestion des associations
	 * membre-rôle.
	 * 
	 * @param member_has_role_Service
	 */
	public Member_has_role_Controller(Member_has_role_Service member_has_role_Service) {
		this.member_has_role_Service = member_has_role_Service;
	}

	/**
	 * Crée une nouvelle association membre-rôle.
	 * 
	 * L'association membre-rôle à créer est fournie dans le corps de la requête.
	 * 
	 * @param member_has_role_Model
	 * @return
	 */
	@PostMapping
	public Member_has_role_Model createMember_has_role_Model(@RequestBody Member_has_role_Model member_has_role_Model) {
		return member_has_role_Service.createMember_has_role_Model(member_has_role_Model);
	}

	/**
	 * Retourne la liste complète des associations membre-rôle existantes.
	 * 
	 * @return
	 */
	@GetMapping
	public List<Member_has_role_Model> getAllMember_has_role_Models() {
		return member_has_role_Service.getAllMember_has_role_Models();
	}

	/**
	 * Retourne une association membre-rôle spécifique en utilisant les identifiants
	 * du membre et de l'équipe.
	 * 
	 * Les identifiants du membre et de l'équipe sont passés en paramètres de l'URL.
	 * 
	 * @param idMember
	 * @param idTeam
	 * @return
	 */
	@GetMapping("/{idMember}/{idTeam}")
	public Optional<Member_has_role_Model> getMember_has_role_ModelById(@PathVariable Long idMember,
			@PathVariable Long idTeam) {
		return member_has_role_Service.getMember_has_role_ModelById(idMember, idTeam);
	}

	/**
	 * Met à jour une association membre-rôle existante.
	 * 
	 * Les identifiants du membre et de l'équipe sont passés en paramètres de l'URL.
	 * 
	 * L'association membre-rôle mise à jour est fournie dans le corps de la
	 * requête.
	 * 
	 * @param idMember
	 * @param idTeam
	 * @param member_has_role_Model
	 * @return
	 */
	@PutMapping("/{idMember}/{idTeam}")
	public Member_has_role_Model updateMember_has_role_Model(@PathVariable Long idMember, @PathVariable Long idTeam,
			@RequestBody Member_has_role_Model member_has_role_Model) {
		return member_has_role_Service.updateMember_has_role_Model(idMember, idTeam, member_has_role_Model);
	}

	/**
	 * Supprime une association membre-rôle par ses identifiants.
	 * 
	 * Les identifiants du membre et de l'équipe sont passés en paramètres de l'URL.
	 * 
	 * @param idMember
	 * @param idTeam
	 */
	@DeleteMapping("/{idMember}/{idTeam}")
	public void deleteMember_has_role_Model(@PathVariable Long idMember, @PathVariable Long idTeam) {
		member_has_role_Service.deleteMember_has_role_Model(idMember, idTeam);
	}

}