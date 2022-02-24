package hu.citec.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.citec.entity.User;
import hu.citec.rowMapper.UserRowMapper;

@Repository
public class userRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User findUser(String username) {
		String query = "Select user_id, username, password, email,address FROM user WHERE username = ?";

		return jdbcTemplate.queryForObject(query, new UserRowMapper(), username);
	}
	
	public void registrateUser(User user) {

		String query = "INSERT INTO user(username, password, email, address) VALUES (?,?,?,?)";
		jdbcTemplate.update(query, user.getUsername(),user.getPassword(),user.getEmail(),user.getAdress());
	}
	
	public void deleteOrder(Integer userId) {
		String query = "DELETE FROM orders WHERE orders.user_id = ?";
				jdbcTemplate.update(query,userId);
	}

}
