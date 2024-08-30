package com.esport.back.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNull;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.MemberModel;
import com.esport.back.repositories.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service pour gérer les opérations liées aux objets MemberModel.
 */
@Service
public class MemberService {

	/**
	 * Logger pour le suivi des opérations de service.
	 */
	static final Logger LOG = LoggerFactory.getLogger(MemberModel.class);

	/**
	 * Repository pour les opérations CRUD sur MemberModel.
	 */
	private final MemberRepository memberRepository;

	/**
	 * Constructeur pour initialiser MemberService avec le MemberRepository.
	 * 
	 * @param memberRepository
	 */
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/**
	 * Crée un nouveau MemberModel dans la base de données.
	 * 
	 * @param memberModel
	 * @return
	 */
	@Transactional
	public MemberModel createMemberModel(@NonNull MemberModel memberModel) {
		return this.memberRepository.save(memberModel);
	}

	/**
	 * Récupère tous les MemberModels de la base de données.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<MemberModel> getAllMemberModels() {
		return (List<MemberModel>) this.memberRepository.findAll();
	}

	/**
	 * Récupère un MemberModel par son identifiant.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<MemberModel> getMemberModelById(@NonNull Long id) {
		return this.memberRepository.findById(id);
	}

	/**
	 * Met à jour un MemberModel existant dans la base de données.
	 * 
	 * @param id
	 * @param updatedMemberModel
	 * @return
	 */
	@Transactional
	public MemberModel updateMemberModel(@NonNull Long id, @NonNull MemberModel updatedMemberModel) {

		// Vérifie si l'identifiant est différent de celui du modèle mis à jour
		if (!id.equals(updatedMemberModel.getId_member())) {
			throw new RuntimeException("Changing id is not allowed !");
		}

		// Vérifie si les données existent
		Optional<MemberModel> optionalMemberModel = this.memberRepository.findById(updatedMemberModel.getId_member());
		if (optionalMemberModel.isPresent()) {
			// Met à jour les données
			return this.memberRepository.save(updatedMemberModel);
		} else {
			throw new RuntimeException("MemberModel not found with id " + updatedMemberModel.getId_member());
		}
	}

	/**
	 * Supprime un MemberModel de la base de données.
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteMemberModel(@NonNull Long id) {
		Optional<MemberModel> optionalMemberModel = this.memberRepository.findById(id);
		if (optionalMemberModel.isPresent()) {
			this.memberRepository.deleteById(id);
		} else {
			throw new RuntimeException("MemberModel not found with id " + id);
		}
	}

}