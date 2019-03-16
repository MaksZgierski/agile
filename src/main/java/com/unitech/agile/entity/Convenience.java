package com.unitech.agile.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the convenience database table.
 * 
 */
@Entity
@NamedQuery(name="Convenience.findAll", query="SELECT c FROM Convenience c")
public class Convenience implements Serializable {
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

	//bi-directional many-to-one association to PlaceConvenience
	@OneToMany(mappedBy="convenience")
	private List<PlaceConvenience> placeConveniences;

	public Convenience() {
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

	public List<PlaceConvenience> getPlaceConveniences() {
		return this.placeConveniences;
	}

	public void setPlaceConveniences(List<PlaceConvenience> placeConveniences) {
		this.placeConveniences = placeConveniences;
	}

	public PlaceConvenience addPlaceConvenience(PlaceConvenience placeConvenience) {
		getPlaceConveniences().add(placeConvenience);
		placeConvenience.setConvenience(this);

		return placeConvenience;
	}

	public PlaceConvenience removePlaceConvenience(PlaceConvenience placeConvenience) {
		getPlaceConveniences().remove(placeConvenience);
		placeConvenience.setConvenience(null);

		return placeConvenience;
	}

}