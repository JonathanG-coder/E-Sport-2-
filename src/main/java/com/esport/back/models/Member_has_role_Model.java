package com.esport.back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est une entité JPA correspondant à la table "members_has_roles"
 * dans la base de données.
 */
@Getter
@Setter
@Entity
@Table(name = "members_has_roles")
public class Member_has_role_Model {

	/**
	 * Clé composée pour l'association entre membre et rôle.
	 */
	@EmbeddedId
	private Member_has_role_ModelId id;

	/**
	 * Le membre associé à ce rôle.
	 */
	@ManyToOne
	@MapsId("id_member")
	@JoinColumn(name = "id_member", insertable = false, updatable = false, nullable = false)
	private MemberModel member;

	/**
	 * L'équipe associée à ce rôle.
	 */
	@ManyToOne
	@MapsId("id_team")
	@JoinColumn(name = "id_team", insertable = false, updatable = false, nullable = false)
	private TeamModel team;

	/**
	 * Le rôle associé au membre dans l'équipe.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role", insertable = true, updatable = true, nullable = false)
	private RoleModel role;

}