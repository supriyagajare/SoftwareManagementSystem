package com.example.SoftwareManagementUsingSpring.SoftwareInterface;

import java.util.List;

import com.example.SoftwareManagementUsingSpring.model.User;

public interface UserService {
	public void addUser(User obj);
	public List<User> findBookedUsersBySoftwareId(long softwareId);
}
