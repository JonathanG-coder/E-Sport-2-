package com.esport.back.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est une entité JPA correspondant à la table "styles" dans la
 * base de données.
 */
@Getter
@Setter
@Entity
@Table(name = "styles")
public class StyleModel {

	/**
	 * Identifiant unique du style.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_style;

	/**
	 * Nom du style.
	 */
	@Column(name = "name_style", length = 30)
	private String name_style;

	/**
	 * Liste des jeux associés à ce style.
	 * 
	 * La liste est ignorée lors de la sérialisation JSON.
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "styles")
	private Set<GameModel> game;

}