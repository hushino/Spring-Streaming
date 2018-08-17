package com.red.spring.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table()
@Cacheable(true)
public class Anime  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "anime_id")
	private Long id;
	
	@Column(length = 100)
	private  String title;
	
	@Column(length = 900)
	private String synopsis;
	
	@Column
	private String state;
	
	@Column
	private String type;
	
	@Column(length = 500)
	private String frontimage;
	
	@Column(length = 500)
	private String backgroundimage;
	
/*	@Column
	private LocalDateTime fechadeEmision;*/
	
	/*@LazyCollection( LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "animes", cascade = CascadeType.ALL)
	private List<Tags> tags = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "anime", cascade = CascadeType.ALL)
	private List<Episodio> episodio = new ArrayList<>();*/
	
	// Constructor
	public Anime() {
	
	}
	public Anime(String title, String synopsis, String state, String type, String frontimage, String backgroundimage
	             ) {
		this.title = title;
		this.synopsis = synopsis;
		this.state = state;
		this.type = type;
		this.frontimage = frontimage;
		this.backgroundimage = backgroundimage;
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getFrontimage() {
		return frontimage;
	}
	
	public void setFrontimage(String frontimage) {
		this.frontimage = frontimage;
	}
	
	public String getBackgroundimage() {
		return backgroundimage;
	}
	
	public void setBackgroundimage(String backgroundimage) {
		this.backgroundimage = backgroundimage;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
	
}
