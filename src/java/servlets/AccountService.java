package servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccountService {
	public User login(String username,String password) throws IOException {
		User loginUser=null;
		if("password".equals(password)&&("adam".equals(username)||"betty".equals(username))) {
			loginUser=new User();
			loginUser.setUsername(username);
		}
		return loginUser;
	}
}
