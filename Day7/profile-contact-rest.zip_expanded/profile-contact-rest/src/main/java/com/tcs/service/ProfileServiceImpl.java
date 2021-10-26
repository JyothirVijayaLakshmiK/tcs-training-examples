package com.tcs.service;
import com.tcs.exceptions.*;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.*;
import com.tcs.entities.*;
@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileDao;
	@Autowired
	private ContactRepository contactDao;

	@Override
	@Transactional
	public Profile save(Profile profile) {
		return profileDao.save(profile);
	}

	@Override
	public List<Contact> getContacts(int profileId) throws ProfileOrContactNotFoundException{
		Profile profile = getProfile(profileId);
		if(profile != null) {
			return profile.getContactsList();
		}
		throw new ProfileOrContactNotFoundException("Profile Id : "+profileId+" not found");
	}

	@Override
	public List<Profile> getProfiles() {
		return profileDao.findAll();
	}
	
	@Override
	public Contact getContact(int contactId, int profileId) throws ProfileOrContactNotFoundException{
		List<Contact> l= getContacts(profileId);
		for(Contact i:l){
			if(i.getContactId()==contactId) {
				return i;
			}
		}
		throw new ProfileOrContactNotFoundException("Contact Id : "+contactId+" not found");
	}
	
	@Override
	@Transactional
	public void deleteContact(int contactId, int profileId) throws ProfileOrContactNotFoundException{
		Contact contact = getContact(contactId, profileId);
		contactDao.deleteContact(contact.getContactId(), profileId);
	}
	
	@Override
	@Transactional
	public void deleteProfile(int profileId) throws ProfileOrContactNotFoundException{
		Profile profile = getProfile(profileId);
		if (profile!=null){
			contactDao.deleteContacts(profileId);
			profileDao.delete(profile);
		}
		else {
		throw new ProfileOrContactNotFoundException("Profile Id : "+profileId+" not found");
		}
	}
	
	@Override
	public Profile getProfile(int profileId) throws ProfileOrContactNotFoundException{
		Profile profile = profileDao.findById(profileId).orElse(null);
		if(profile != null) 
		{
			return profile;
		}
		throw new ProfileOrContactNotFoundException("Profile Id : "+profileId+" not found");
	}

	@Override
	@Transactional
	public void addContact(int profileId, Contact contact) throws ProfileOrContactNotFoundException {
		Profile profile=getProfile(profileId);
		if(profile!=null) {
			contactDao.save(contact);
		}
		else {
			throw new ProfileOrContactNotFoundException("Profile Id : "+profileId+" not found");
		}
	}
}
