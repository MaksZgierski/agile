package com.unitech.agile.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the opinion database table.
 * 
 */
@Entity
@NamedQuery(name="Opinion.findAll", query="SELECT o FROM Opinion o")
public class Opinion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="add_date")
	private Timestamp addDate;

	private String comment;

	private Integer rating;

	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private ApplicationUser applicationUser;

	//bi-directional many-to-one association to Place
	@ManyToOne
	private Place place;

	public Opinion() {
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

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public ApplicationUser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}