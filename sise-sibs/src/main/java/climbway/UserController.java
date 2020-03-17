package climbway;

public class UserController {
	
	private User model;
	private UserView view;
	
	private UserController(User model, UserView view) {
		this.model = model;
		this.view= view;
	}

}
