package com.example.SoftwareManagementUsingSpring.SoftwareRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SoftwareManagementUsingSpring.model.Developer;
import com.example.SoftwareManagementUsingSpring.model.Software;


@Repository
public interface DeveloperRepository  extends JpaRepository<Developer, Integer> {

	Iterable<Developer> findByDeveloperNameContainingIgnoreCase(String title);

	void deleteById(int id);

	Developer save(Developer developer);
}