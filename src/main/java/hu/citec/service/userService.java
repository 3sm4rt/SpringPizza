package hu.citec.service;

import org.springframework.stereotype.Service;

import hu.citec.entity.User;
import hu.citec.repository.userRepository;

@Service
public class userService {
	private userRepository userRepo;

	public userService(userRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	public User findUser(String username) {
		return userRepo.findUser(username);
	}
	public void registrateUser(User user) {
		userRepo.registrateUser(user);
	}
	public void deleteOrder(Integer userId) {
		userRepo.deleteOrder(userId);
	}

}
