package com.esport.back.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est une entité JPA correspondant à la table "teams" dans la base
 * de données.
 */
@Getter
@Setter
@Entity
@Table(name = "teams")
public class TeamModel {

	/**
	 * Identifiant unique de l'équipe.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_team;

	/**
	 * Nom de l'équipe.
	 */
	@Column(name = "name_team", length = 30)
	private String name_team;

	/**
	 * Nombre maximal de joueurs dans l'équipe.
	 */
	@Column(name = "maxplayers_team")
	private Long maxplayers_team;

	/**
	 * Logo de l'équipe (URL de l'image).
	 */
	@Column(name = "logo_team", length = 150)
	private String logo_team;

	/**
	 * Jeu associé à l'équipe.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_game", nullable = false)
	private GameModel game;

	/**
	 * Liste des membres ayant des rôles dans l'équipe.
	 * 
	 * L'équipe est ignorée lors de la sérialisation JSON.
	 */
	@JsonIgnoreProperties({ "team" })
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
	private Set<Member_has_role_Model> member_has_role;

}