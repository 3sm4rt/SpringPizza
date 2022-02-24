package hu.citec.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.citec.entity.Pizza;

public class PizzaRowMapper implements RowMapper<Pizza> {
	
	@Override
	public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pizza pizza = new Pizza();
		pizza.setPizzaId(rs.getInt("pizza_id"));
		pizza.setPizzaName(rs.getString("pizza_name"));
		pizza.setDescription(rs.getString("descrip"));
		pizza.setCost(rs.getInt("cost"));
		pizza.setImg(rs.getString("img"));
		return pizza;
	}

}
