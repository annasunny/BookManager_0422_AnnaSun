package edu.neu.bookmanager.domain;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="BOOK")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="TITLE")
	@NotEmpty
	@Size(min=1, max=255)
	private String title;
	
	@Column(name="AUTHOR")
	@NotEmpty
	@Size(min=1, max=255)
	private String author;
	
	@Column(name="DISCRIPTION")
	@Size(min=1, max=255)
	private String discription;
	
	@Column(name="QUANTITY")
	@NotNull
	private int quantity;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Comment> comments = new HashSet<Comment>();
	
	@Transient
	private MultipartFile coverPhotoFile;
	
	@Column(name="COVER_PHOTO")
	@Lob private byte[] coverPhoto;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MultipartFile getCoverPhotoFile() {
		return coverPhotoFile;
	}
	public void setCoverPhotoFile(MultipartFile coverPhotoFile) {
		this.coverPhotoFile = coverPhotoFile;
		
		try {
			setCoverPhoto(coverPhotoFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public byte[] getCoverPhoto() {
		return coverPhoto;
	}
	public void setCoverPhoto(byte[] coverPhoto) {
		this.coverPhoto = coverPhoto;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment){
		comments.add(comment);
		comment.setBook(this);
		
	}
	
	
}
