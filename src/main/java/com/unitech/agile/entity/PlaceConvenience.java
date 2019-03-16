package com.unitech.agile.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the place_convenience database table.
 * 
 */
@Entity
@Table(name="place_convenience")
@NamedQuery(name="PlaceConvenience.findAll", query="SELECT p FROM PlaceConvenience p")
public class PlaceConvenience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Column(name="add_date")
	private Timestamp addDate;

	//bi-directional many-to-one association to Convenience
	@ManyToOne
	private Convenience convenience;

	//bi-directional many-to-one association to Place
	@ManyToOne
	private Place place;

	public PlaceConvenience() {
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

	public Convenience getConvenience() {
		return this.convenience;
	}

	public void setConvenience(Convenience convenience) {
		this.convenience = convenience;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}