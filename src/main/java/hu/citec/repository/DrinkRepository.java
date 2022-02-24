package hu.citec.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.citec.entity.Drink;
import hu.citec.entity.Pizza;
import hu.citec.rowMapper.DrinkRowMapper;

@Repository
public class DrinkRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Drink> findAllDrink() {
		String query = "Select * from drink";
		return jdbcTemplate.query(query, new DrinkRowMapper());
	}
	public void uploadDrinkOrder(Integer userId,Integer drinkId) {
		String query ="INSERT INTO orders (user_id, pizza_id, drink_id) VALUES (?,NULL,?)";
		jdbcTemplate.update(query,userId,drinkId);
	}
	public  List <Drink> OrderDrink(Integer userId){
		String query = "SELECT d.drink_name,d.cost,d.img  from orders o LEFT JOIN drink d ON d.drink_id=o.drink_id WHERE o.user_id =? AND o.drink_id IS NOT NULL";

		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Drink.class),userId);
	}

}
