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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="tweet")
public class Tweet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TWEET_ID", unique=true, nullable=false)
	private Integer tweetId;
	
	@Column(name="CONTENT", nullable=false, length=100)
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	@Transient
	private MultipartFile coverPhotoFile;
	
	@Column(name="COVER_PHOTO")
	@Lob private byte[] coverPhoto;
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getTweetId() {
		return tweetId;
	}
	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	
}
