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

import easyAutomate.data.PasswordChangeRequest;
import easyAutomate.data.User;
import easyAutomate.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class ChangePasswordController {

	public final UserRepository userRepository;

	@Autowired
	public ChangePasswordController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/change-password")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest) {
		String currentPassword = DigestUtils.sha256Hex(passwordChangeRequest.getCurrentPassword());
		String newPassword = DigestUtils.sha256Hex(passwordChangeRequest.getNewPassword());
		String confirmPassword = DigestUtils.sha256Hex(passwordChangeRequest.getConfirmPassword());

		// Check if the new password and confirm password match
		if (!newPassword.equals(confirmPassword)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("New password and confirm password do not match");
		}

		String authenticatedUserEmail = passwordChangeRequest.getEmail();
		User user = userRepository.findByEmail(authenticatedUserEmail);

		if (user != null && user.getPassword().equals(currentPassword)) {
			// Current password matches, update the password
			user.setPassword(newPassword);
			userRepository.save(user);
			return ResponseEntity.ok("Password changed successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid current password");
		}
	}
}
