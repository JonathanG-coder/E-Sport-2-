package com.esport.back.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNull;
import java.util.Optional;
import java.util.List;
import com.esport.back.models.StyleModel;
import com.esport.back.repositories.StyleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service pour gérer les opérations liées aux objets StyleModel.
 */
@Service
public class StyleService {

	/**
	 * Logger pour le suivi des opérations de service.
	 */
	static final Logger LOG = LoggerFactory.getLogger(StyleModel.class);

	/**
	 * Repository pour les opérations CRUD sur StyleModel.
	 */
	private final StyleRepository styleRepository;

	/**
	 * Constructeur pour initialiser StyleService avec le StyleRepository.
	 * 
	 * @param styleRepository
	 */
	public StyleService(StyleRepository styleRepository) {
		this.styleRepository = styleRepository;
	}

	/**
	 * Crée un nouveau StyleModel dans la base de données.
	 * 
	 * @param styleModel
	 * @return
	 */
	@Transactional
	public StyleModel createStyleModel(@NonNull StyleModel styleModel) {
		return this.styleRepository.save(styleModel);
	}

	/**
	 * Récupère tous les StyleModels de la base de données.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<StyleModel> getAllStyleModels() {
		return (List<StyleModel>) this.styleRepository.findAll();
	}

	/**
	 * Récupère un StyleModel par son identifiant.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Optional<StyleModel> getStyleModelById(@NonNull Long id) {
		return this.styleRepository.findById(id);
	}

	/**
	 * Met à jour un StyleModel existant dans la base de données.
	 * 
	 * @param id
	 * @param updatedStyleModel
	 * @return
	 */
	@Transactional
	public StyleModel updateStyleModel(@NonNull Long id, @NonNull StyleModel updatedStyleModel) {

		// Vérifie si l'identifiant est différent de celui du modèle mis à jour
		if (!id.equals(updatedStyleModel.getId_style())) {
			throw new RuntimeException("Changing id is not allowed !");
		}

		// Vérifie si les données existent
		Optional<StyleModel> optionalStyleModel = this.styleRepository.findById(updatedStyleModel.getId_style());
		if (optionalStyleModel.isPresent()) {
			// Met à jour les données
			return this.styleRepository.save(updatedStyleModel);
		} else {
			throw new RuntimeException("StyleModel not found with id " + updatedStyleModel.getId_style());
		}
	}

	/**
	 * Supprime un StyleModel de la base de données.
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteStyleModel(@NonNull Long id) {
		Optional<StyleModel> optionalStyleModel = this.styleRepository.findById(id);
		if (optionalStyleModel.isPresent()) {
			this.styleRepository.deleteById(id);
		} else {
			throw new RuntimeException("StyleModel not found with id " + id);
		}
	}

}