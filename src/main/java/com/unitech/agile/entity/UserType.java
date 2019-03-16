package com.unitech.agile.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_type database table.
 * 
 */
@Entity
@Table(name="user_type")
@NamedQuery(name="UserType.findAll", query="SELECT u FROM UserType u")
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Column(name="add_date")
	private Timestamp addDate;

	@Column(name="last_modified")
	private Timestamp lastModified;

	private String name;

	//bi-directional many-to-one association to ApplicationUser
	@OneToMany(mappedBy="userType")
	private List<ApplicationUser> applicationUsers;

	public UserType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ApplicationUser> getApplicationUsers() {
		return this.applicationUsers;
	}

	public void setApplicationUsers(List<ApplicationUser> applicationUsers) {
		this.applicationUsers = applicationUsers;
	}

	public ApplicationUser addApplicationUser(ApplicationUser applicationUser) {
		getApplicationUsers().add(applicationUser);
		applicationUser.setUserType(this);

		return applicationUser;
	}

	public ApplicationUser removeApplicationUser(ApplicationUser applicationUser) {
		getApplicationUsers().remove(applicationUser);
		applicationUser.setUserType(null);

		return applicationUser;
	}

}