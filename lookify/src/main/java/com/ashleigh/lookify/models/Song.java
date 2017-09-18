package com.ashleigh.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=5, max=200)
	public String artist;
	
	@Column
	@Size(min=5, max=200)
	public String title;
	
	@Column
	@Min(1)
	public int rating;
	
	 @Column
	 @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	 private Date created_at;

	 @Column
	 @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	 private Date updated_at;

	public Song(){
		
	}
	
	public Song(String artist, String title, int rating, Date updated_at, Date created_at){
		
		this.artist = artist;
		this.title = title;
		this.rating = rating;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public void setArtist(String artist){
		this.artist = artist;
		}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getRating(){
		return rating;
	}
	
	public void setRating(int rating){
		this.rating = rating;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public Date getUpdatedAt(){
		return updated_at;
	}
	
	@PreUpdate
	public void setUpdatedAt(){
		this.updated_at = new Date();
	}
	
	public Date getCreatedAt(){
		return created_at;
	}
	
    @PrePersist
	public void setCreatedAt(){
		this.created_at = new Date();
	}
}
