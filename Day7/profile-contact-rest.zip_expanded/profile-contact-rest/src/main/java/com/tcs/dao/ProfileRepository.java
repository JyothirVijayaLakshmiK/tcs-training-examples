package com.tcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	
}
