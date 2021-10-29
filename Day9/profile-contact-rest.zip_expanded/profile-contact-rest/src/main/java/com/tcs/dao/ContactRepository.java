package com.tcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tcs.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	@Modifying
	@Query("delete from Contact c where c.contactId=?1 and c.profileId=?2")
	public void deleteContact(int contactId, int profileId);
	
	@Modifying
	@Query("delete from Contact c where c.profileId=?1")
	public void deleteContacts(int profileId);
	
}
