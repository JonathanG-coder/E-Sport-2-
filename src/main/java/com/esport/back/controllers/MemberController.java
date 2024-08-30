package com.esport.back.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.MemberModel;
import com.esport.back.services.MemberService;

/**
 * Contrôleur REST pour gérer les opérations liées aux membres.
 */
@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/member")
public class MemberController {

	/**
	 * Service utilisé pour gérer les opérations sur les membres.
	 */
	private final MemberService memberService;

	/**
	 * Constructeur pour initialiser le service de gestion des membres.
	 * 
	 * @param memberService
	 */
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	/**
	 * Crée un nouveau membre.
	 * 
	 * Le membre est fourni dans le corps de la requête.
	 * 
	 * @param memberModel
	 * @return
	 */
	@PostMapping
	public MemberModel createMemberModel(@RequestBody MemberModel memberModel) {
		return memberService.createMemberModel(memberModel);
	}

	/**
	 * Retourne la liste complète des membres existants.
	 * 
	 * @return
	 */
	@GetMapping
	public List<MemberModel> getAllMemberModels() {
		return memberService.getAllMemberModels();
	}

	/**
	 * Retourne un membre spécifique en utilisant son identifiant.
	 * 
	 * L'identifiant du membre est passé en paramètre de l'URL.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<MemberModel> getMemberModelById(@PathVariable Long id) {
		return memberService.getMemberModelById(id);
	}

	/**
	 * Met à jour un membre existant.
	 * 
	 * L'identifiant du membre à mettre à jour est passé en paramètre de l'URL.
	 * 
	 * Le membre mis à jour est fourni dans le corps de la requête.
	 * 
	 * @param id
	 * @param memberModel
	 * @return
	 */
	@PutMapping("/{id}")
	public MemberModel updateMemberModel(@PathVariable Long id, @RequestBody MemberModel memberModel) {
		return memberService.updateMemberModel(id, memberModel);
	}

	/**
	 * Supprime un membre par son identifiant.
	 * 
	 * L'identifiant du membre à supprimer est passé en paramètre de l'URL.
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteMemberModel(@PathVariable Long id) {
		memberService.deleteMemberModel(id);
	}

}