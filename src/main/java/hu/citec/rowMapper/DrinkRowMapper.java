package hu.citec.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.citec.entity.Drink;


public class DrinkRowMapper implements RowMapper<Drink> {

	@Override
	public Drink mapRow(ResultSet rs, int rowNum) throws SQLException {
		Drink drink = new Drink();
		drink.setDrinkId(rs.getInt("drink_id"));;
		drink.setDinkName(rs.getString("drink_name"));
		drink.setCost(rs.getInt("cost"));
		drink.setImg(rs.getString("img"));

		return drink;
	}

}
