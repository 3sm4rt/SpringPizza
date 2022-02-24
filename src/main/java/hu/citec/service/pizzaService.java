package hu.citec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.citec.entity.Pizza;
import hu.citec.repository.pizzaRepository;

@Service
public class pizzaService {
	private pizzaRepository pizzaRepository;

	public pizzaService(pizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}
	
	public List<Pizza> findAllPizza(){
		return pizzaRepository.findAllPizza();
	}

//	public Pizza chosePizza (Integer pizzaId) {
//		return pizzaRepository.chosePizza(pizzaId);
//	}
//	public List<Pizza> orders(Integer userId){
//		return pizzaRepository.orders(userId);
//	}
	
	public void uploadOrder (Integer userId,Integer pizzaId) {
		 pizzaRepository.uploadOrder(userId,pizzaId);
	}
	public List<Pizza> OrderPizzas(Integer userId) {
		return pizzaRepository.OrderPizzas(userId);
	}
}
