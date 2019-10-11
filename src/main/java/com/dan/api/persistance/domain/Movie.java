package com.dan.api.persistance.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(columnDefinition = "VARCHAR(64)")
	private String name;
	
	@NotNull
	@Column(columnDefinition = "BLOB")
	private String description;
	
	@NotNull
	@Column(name = "age_rating", columnDefinition = "VARCHAR(3)")
	private String ageRating;
	
	@NotNull
	@Column(name = "img_url")
	private String imgUrl;

	@NotNull
	private int runtime;

	@Column(columnDefinition = "FLOAT(4,2) DEFAULT 0.0")
	private float rating;
	
	@Column(name = "ratings_count", columnDefinition = "INT DEFAULT 0")
	private int ratingsCount;
	
//	@Column(name = "released_date")
//	private String releaseDate;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews;

	public void addRating(float rating) {
		if(ratingsCount > 0) {
			this.rating = this.rating + ((rating - this.rating) / (ratingsCount + 1));
		} else {
			this.rating = rating;
		}
		this.ratingsCount++;
	}
	
	public void removeRating(float rating) {
		if(ratingsCount > 1) {
			this.rating = ((this.rating * ratingsCount) - rating) / (ratingsCount - 1);
		} else {
			this.rating = 0F;
		}
		this.ratingsCount--;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long movieId) {
		this.id = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public int getRuntime() {
		return runtime;
	}
	
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
