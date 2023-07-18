package easyAutomate.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import easyAutomate.data.LoginRequest;
import easyAutomate.data.User;
import easyAutomate.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	public final UserRepository userRepository;

	@Autowired
	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
		// Extract login credentials from the request payload
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		// Implement logic to validate the credentials
		User user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(DigestUtils.sha256Hex(password))) {
			// Login successful
			return ResponseEntity.ok("Login successful!");
		} else {
			// Login failed
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
}
