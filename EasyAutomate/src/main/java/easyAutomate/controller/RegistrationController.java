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

import easyAutomate.data.ErrorResponse;
import easyAutomate.data.User;
import easyAutomate.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

	public final UserRepository userRepository;

	@Autowired
	public RegistrationController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerEmployee(@RequestBody User user) {
		// Check if the email already exists
		if (userRepository.findByEmail(user.getEmail()) != null) {
			ErrorResponse errorResponse = new ErrorResponse("Email already exists. Please sign in.", "01");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		String encryptedPassword = DigestUtils.sha256Hex(user.getPassword());
		user.setPassword(encryptedPassword);
		User savedUser = userRepository.save(user);

		return ResponseEntity.ok(savedUser);
	}
}
