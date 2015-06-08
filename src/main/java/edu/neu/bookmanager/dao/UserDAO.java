package edu.neu.bookmanager.dao;

import java.util.List;

import edu.neu.bookmanager.domain.User;

public interface UserDAO {
	
	public void addUser(User user);
	public List<User> listUsers();
	public User getUser(Integer id);
	public void removeUser(Integer id);
	
	
}

