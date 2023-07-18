package easyAutomate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import easyAutomate.data.UserDetails;
import easyAutomate.repository.UserDetailsRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserDetailsController {

	public final UserDetailsRepository userDetailsRepository;

	@Autowired
	public UserDetailsController(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	@PostMapping("/details")
	public ResponseEntity<?> saveUserDetails(@RequestBody UserDetails userDetails) {
		UserDetails savedDetails = userDetailsRepository.save(userDetails);
		return ResponseEntity.ok(savedDetails);
	}
}
