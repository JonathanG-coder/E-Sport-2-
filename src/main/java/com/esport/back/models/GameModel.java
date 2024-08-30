package com.esport.back.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est une entité JPA correspondant à la table "games" dans la base
 * de données.
 */
@Getter
@Setter
@Entity
@Table(name = "games")
public class GameModel {

	/**
	 * Identifiant unique du jeu.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_game;

	/**
	 * Nom du jeu.
	 */
	@Column(name = "name_game", length = 30)
	private String name_game;

	/**
	 * Bannière du jeu (URL de l'image).
	 */
	@Column(name = "banner_game", length = 150)
	private String banner_game;

	/**
	 * Image du jeu (URL de l'image).
	 */
	@Column(name = "img_game", length = 150)
	private String img_game;

	/**
	 * Classification PEGI du jeu.
	 */
	@Column(name = "pegi_game")
	private Long pegi_game;

	/**
	 * Année de sortie du jeu.
	 */
	@Column(name = "year_game")
	private Long year_game;

	/**
	 * Liste des équipes associées au jeu.
	 * 
	 * La liste est ignorée lors de la sérialisation JSON.
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "game")
	private Set<TeamModel> teamModel;

	/**
	 * Liste des styles associés au jeu.
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "games_has_styles", joinColumns = @JoinColumn(name = "id_game"), inverseJoinColumns = @JoinColumn(name = "id_style"))
	private Set<StyleModel> styles;

}