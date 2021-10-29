package com.tcs.service;
import com.tcs.exceptions.*;
import java.util.List;

import com.tcs.entities.*;

public interface ProfileService {
	public Profile save(Profile profile);
	public Profile getProfile(int profileId) throws ProfileOrContactNotFoundException;
	public List<Contact> getContacts(int profileId) throws ProfileOrContactNotFoundException;
	public void deleteProfile(int profileId) throws ProfileOrContactNotFoundException;
	public List<Profile> getProfiles();
	public Contact getContact(int contactId, int profileId) throws ProfileOrContactNotFoundException;
	public void deleteContact(int contactId, int profileId) throws ProfileOrContactNotFoundException;
	public void addContact(int profileId, Contact contact) throws ProfileOrContactNotFoundException;
}
