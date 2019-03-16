package com.unitech.agile.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the place_type database table.
 * 
 */
@Entity
@Table(name="place_type")
@NamedQuery(name="PlaceType.findAll", query="SELECT p FROM PlaceType p")
public class PlaceType implements Serializable {
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

	//bi-directional many-to-one association to Place
	@OneToMany(mappedBy="placeType")
	private List<Place> places;

	public PlaceType() {
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

	public List<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Place addPlace(Place place) {
		getPlaces().add(place);
		place.setPlaceType(this);

		return place;
	}

	public Place removePlace(Place place) {
		getPlaces().remove(place);
		place.setPlaceType(null);

		return place;
	}

}