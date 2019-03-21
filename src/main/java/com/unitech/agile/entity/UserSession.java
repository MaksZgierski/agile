package com.unitech.agile.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_session database table.
 * 
 */
@Entity
@Table(name="user_session")
@NamedQuery(name="UserSession.findAll", query="SELECT u FROM UserSession u")
public class UserSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="add_date")
	private Timestamp addDate;

	private String token;

	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private ApplicationUser applicationUser;

	public UserSession() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ApplicationUser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

}