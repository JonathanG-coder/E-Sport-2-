package com.esport.back.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est une entité JPA correspondant à la table "members" dans la
 * base de données.
 */
@Getter
@Setter
@Entity
@Table(name = "members")
public class MemberModel {

	/**
	 * Identifiant unique du membre.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_member;

	/**
	 * Prénom du membre.
	 */
	@Column(name = "firstname_member", length = 30)
	private String firstname_member;

	/**
	 * Nom de famille du membre.
	 */
	@Column(name = "lastname_member", length = 30)
	private String lastname_member;

	/**
	 * Surnom du membre.
	 */
	@Column(name = "nickname_member", length = 30)
	private String nickname_member;

	/**
	 * Photo du membre (URL de l'image).
	 */
	@Column(name = "photo_member", length = 150)
	private String photo_member;

	/**
	 * Pays du membre.
	 */
	@Column(name = "country_member", length = 30)
	private String country_member;

	/**
	 * Liste des rôles associés au membre.
	 * 
	 * La liste est ignorée lors de la sérialisation JSON.
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "member")
	private Set<Member_has_role_Model> member_has_role;

}