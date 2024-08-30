package com.esport.back.models;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est utilisée pour identifier de manière unique une association
 * entre un membre et un rôle au sein d'une équipe.
 */
@SuppressWarnings("serial")
@Getter
@Setter
@Embeddable
public class Member_has_role_ModelId implements Serializable {

	/**
	 * Identifiant du membre.
	 */
	@Column(name = "id_member")
	private Long id_member;

	/**
	 * Identifiant de l'équipe.
	 */
	@Column(name = "id_team")
	private Long id_team;

	/**
	 * Compare cet objet avec un autre objet pour vérifier s'ils sont égaux.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Member_has_role_ModelId that = (Member_has_role_ModelId) o;
		return Objects.equals(id_member, that.id_member) && Objects.equals(id_team, that.id_team);
	}

	/**
	 * Calcule le code de hachage de cet objet.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id_member, id_team);
	}

}