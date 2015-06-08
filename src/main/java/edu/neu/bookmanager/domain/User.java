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
import javax.persistence.UniqueConstraint;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="user", uniqueConstraints=@UniqueConstraint(columnNames={"USER_NAME", "PASS_WORD"}))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID", unique=true, nullable=false)
	private Integer userId;
	
	@Column(name="USER_NAME", unique=true, nullable=false, length=30)
	private String username;
	
	@Column(name="PASS_WORD", nullable=false, length=30)
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private Set<Tweet> tweets = new HashSet<Tweet>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private Set<Comment> comments = new HashSet<Comment>();
	
	@Column(name="USER_DETAIL", nullable=false, length=100)
	private String userDetail;
	
	//private Role role;
	
	@Transient
	private MultipartFile coverPhotoFile;
	
	@Column(name="COVER_PHOTO")
	@Lob private byte[] coverPhoto;

	public User(String name, String password) {
	        this.username = name;
	        this.password = password;
	    }
	
	public User(){
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(String userDetail) {
		this.userDetail = userDetail;
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

	public Set<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Set<Tweet> tweets) {
		this.tweets = tweets;
	}

	
	
	
	
	

}
