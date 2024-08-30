package com.esport.back.models;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe est une entité JPA correspondant à la table "roles" dans la base
 * de données.
 */
@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleModel {

	/**
	 * Identifiant unique du rôle.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_role;

	/**
	 * Tâche associée au rôle.
	 */
	@Column(name = "task_role", length = 30)
	private String task_role;

	/**
	 * Type du rôle.
	 */
	@Column(name = "type_role")
	private Long type_role;

	/**
	 * Liste des membres ayant ce rôle.
	 * 
	 * La liste est ignorée lors de la sérialisation JSON.
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private Set<Member_has_role_Model> member_has_role;

}