package com.tcs.api;
import com.tcs.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entities.Profile;
import com.tcs.service.ProfileService;
import com.tcs.entities.Contact;
import com.tcs.entities.CustomResponse;

@RestController
@RequestMapping("profile")
public class ProfileRestApi {

	@Autowired
	private ProfileService profileService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveProfile(@RequestBody Profile profile) {
		return ResponseEntity.status(HttpStatus.CREATED).body(profileService.save(profile));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProfiles() {
		return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfiles());
	}
	
	@GetMapping(path = "contact/{profileId}")
	public ResponseEntity<Object> getContactFromProfile(@PathVariable("profileId") int profileId) {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(profileService.getContacts(profileId));
		}
		catch(ProfileOrContactNotFoundException e){
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
	}
	
	@GetMapping(path = "{profileId}")
	public ResponseEntity<Object> getProfile(@PathVariable("profileId") int profileId) {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfile(profileId));
		}
		catch(ProfileOrContactNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
	}
	
	@DeleteMapping(path = "{contactId}/{profileId}")
	public ResponseEntity<Object> deleteContactFromProfile(@PathVariable("contactId") int contactId, @PathVariable("profileId") int profileId) {
		try {
			profileService.deleteContact(contactId, profileId);
			CustomResponse data = new CustomResponse();
			data.setMsg("Contact Deleted Successfully");
			return ResponseEntity.status(HttpStatus.OK).body(data);
		}
		catch(ProfileOrContactNotFoundException e){
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
	}
	
	@GetMapping(path = "{contactId}/{profileId}")
	public ResponseEntity<Object> getContactFromProfile(@PathVariable("contactId") int contactId, @PathVariable("profileId") int profileId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(profileService.getContact(contactId, profileId));
		}
		catch(ProfileOrContactNotFoundException e){
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
	}
	@DeleteMapping(path = "{profileId}")
	public ResponseEntity<Object> deleteProfile(@PathVariable("profileId") int profileId) {
		try {
			profileService.deleteProfile(profileId);
			CustomResponse data = new CustomResponse();
			data.setMsg("Profile Deleted Successfully");
			return ResponseEntity.status(HttpStatus.OK).body(data);
		}
		catch(ProfileOrContactNotFoundException e){
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addContact(@RequestBody Contact contact) {
		try {
			profileService.addContact(contact.getProfileId(),contact);
			CustomResponse data = new CustomResponse();
			data.setMsg("Contact Successfully Added");
			return ResponseEntity.status(HttpStatus.CREATED).body(data);
		}
		catch(ProfileOrContactNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
	}
		
}
