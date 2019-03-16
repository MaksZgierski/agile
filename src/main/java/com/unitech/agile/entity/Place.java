package com.unitech.agile.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the place database table.
 * 
 */
@Entity
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Column(name="add_date")
	private Timestamp addDate;

	private String address;

	private String description;

	@Column(name="last_modified")
	private Timestamp lastModified;

	private float lat;

	private float lon;

	private String name;

	//bi-directional many-to-one association to Media
	@OneToMany(mappedBy="place")
	private List<Media> medias;

	//bi-directional many-to-one association to Opinion
	@OneToMany(mappedBy="place")
	private List<Opinion> opinions;

	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="owner_id")
	private ApplicationUser applicationUser;

	//bi-directional many-to-one association to PlaceType
	@ManyToOne
	@JoinColumn(name="place_type_id")
	private PlaceType placeType;

	//bi-directional many-to-one association to PlaceConvenience
	@OneToMany(mappedBy="place")
	private List<PlaceConvenience> placeConveniences;

	public Place() {
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public float getLat() {
		return this.lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return this.lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Media addMedia(Media media) {
		getMedias().add(media);
		media.setPlace(this);

		return media;
	}

	public Media removeMedia(Media media) {
		getMedias().remove(media);
		media.setPlace(null);

		return media;
	}

	public List<Opinion> getOpinions() {
		return this.opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	public Opinion addOpinion(Opinion opinion) {
		getOpinions().add(opinion);
		opinion.setPlace(this);

		return opinion;
	}

	public Opinion removeOpinion(Opinion opinion) {
		getOpinions().remove(opinion);
		opinion.setPlace(null);

		return opinion;
	}

	public ApplicationUser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public PlaceType getPlaceType() {
		return this.placeType;
	}

	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}

	public List<PlaceConvenience> getPlaceConveniences() {
		return this.placeConveniences;
	}

	public void setPlaceConveniences(List<PlaceConvenience> placeConveniences) {
		this.placeConveniences = placeConveniences;
	}

	public PlaceConvenience addPlaceConvenience(PlaceConvenience placeConvenience) {
		getPlaceConveniences().add(placeConvenience);
		placeConvenience.setPlace(this);

		return placeConvenience;
	}

	public PlaceConvenience removePlaceConvenience(PlaceConvenience placeConvenience) {
		getPlaceConveniences().remove(placeConvenience);
		placeConvenience.setPlace(null);

		return placeConvenience;
	}

}