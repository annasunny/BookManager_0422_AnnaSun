package edu.neu.bookmanager.dao;

import java.util.List;

import edu.neu.bookmanager.domain.Comment;

public interface CommentDAO {
	
	public void addComment(Comment comment);
	public List<Comment> listComments();
	public Comment getComment(Integer id);
	public void removeComment(Integer id);
}
