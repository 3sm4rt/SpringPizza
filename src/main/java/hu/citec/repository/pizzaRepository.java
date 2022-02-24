package hu.citec.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hu.citec.entity.Pizza;

import hu.citec.rowMapper.PizzaRowMapper;


@Repository
public class pizzaRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List <Pizza> findAllPizza(){
		String query ="Select * from pizza";
		return jdbcTemplate.query(query, new PizzaRowMapper());
	}
	
//	public Pizza chosePizza(Integer pizzaId){
//		String query = "SELECT p.pizza_name,p.descrip,p.cost,p.img FROM pizza p WHERE p.pizza_id = ?";
//				
//				return jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Pizza.class),pizzaId);
//	}
//	public List <Pizza> orders(Integer userId){
//		String query = "SELECT p.pizza_name,p.descrip,p.cost,p.img FROM pizza p LEFT JOIN orders o ON o.pizza_id = p.pizza_id LEFT JOIN user u ON u.user_id = o.user_id WHERE U.user_id = '1'";
//		
//		return jdbcTemplate.query(query, new PizzaRowMapper(), userId);
//	}
	
	public void uploadOrder(Integer userId ,Integer pizzaId) {
		String query ="INSERT INTO orders (user_id, pizza_id, drink_id) VALUES (?,?,NULL)";
		jdbcTemplate.update(query,userId,pizzaId);
	}
	public  List <Pizza> OrderPizzas(Integer userId){
		String query = "SELECT p.pizza_name,p.descrip,p.cost,p.img  from orders o LEFT JOIN pizza p ON p.pizza_id=o.pizza_id WHERE o.user_id = ? AND o.pizza_id IS NOT NULL";

		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Pizza.class),userId);
	}
}
