package hu.citec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.citec.entity.Drink;
import hu.citec.entity.Pizza;
import hu.citec.repository.DrinkRepository;

@Service
public class drinkService {
	private DrinkRepository drinkRepository ;

	public drinkService(DrinkRepository drinkRepository) {
		
		this.drinkRepository = drinkRepository;
	}
	
	public List<Drink> findAllDrink(){
		return drinkRepository.findAllDrink();
	}
	public void uploadDrinkOrder(Integer userId ,Integer drinkId) {
		drinkRepository.uploadDrinkOrder(userId,drinkId);
	}
	public List<Drink> OrderDrink(Integer userId) {
		return drinkRepository.OrderDrink(userId);
	}
	
	

}
