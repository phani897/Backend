package easyAutomate.data;

public class RegistrationResponse {
	public User user;
	public String token;

	public RegistrationResponse(User user, String token) {
		this.user = user;
		this.token = token;
	}

}
