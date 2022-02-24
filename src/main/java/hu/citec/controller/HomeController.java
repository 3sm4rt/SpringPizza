package hu.citec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.citec.entity.Drink;
import hu.citec.entity.Pizza;
import hu.citec.entity.User;
import hu.citec.service.drinkService;
import hu.citec.service.pizzaService;
import hu.citec.service.userService;

@Controller
public class HomeController {
	private pizzaService pizzaSERVICE;
	private drinkService drinkService;
	private userService userSERVICE;

	public HomeController(pizzaService pizzaSERVICE, drinkService drinkService, userService userSERVICE) {
		this.drinkService = drinkService;
		this.pizzaSERVICE = pizzaSERVICE;
		this.userSERVICE = userSERVICE;
	}

	@RequestMapping({ "/home", "/" })
	public String home() {

		return "View/home";
	}
	@RequestMapping("/reg")
	public String reg(@ModelAttribute(value = "user") User user) {
		userSERVICE.registrateUser(user);

		return "View/reg";
	}
	

	@GetMapping("/pizzashow")
	public String home(Model model) {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		List<Pizza> findAllPizza = pizzaSERVICE.findAllPizza();
		User findUser = userSERVICE.findUser(aut.getName());
		model.addAttribute("user", findUser);
		model.addAttribute("pizzas", findAllPizza);
		return "View/webshop";
	}

	@GetMapping("/drinkshow")
	public String drinkShow(Model model) {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		List<Drink> findAllDrink = drinkService.findAllDrink();
		User findUser = userSERVICE.findUser(aut.getName());
		model.addAttribute("user", findUser);
		model.addAttribute("drinks", findAllDrink);
		return "View/drinkPage";
	}

	@GetMapping("/login")
	public String login() {
		return "View/Login";
	}

	@GetMapping("/cart/{pizzaId}/{userId}")
	public String cart(@PathVariable(name = "pizzaId") Integer pizzaId, @PathVariable(name = "userId") Integer userId) {
		pizzaSERVICE.uploadOrder(userId, pizzaId);

		return "redirect:/pizzashow";
	}

	@GetMapping("/drinkCart/{drinkId}/{userId}")
	public String drinkCart(@PathVariable(name = "drinkId") Integer drinkId,
			@PathVariable(name = "userId") Integer userId) {
		drinkService.uploadDrinkOrder(userId, drinkId);

		return "redirect:/drinkshow";
	}

	@GetMapping("/cartshow")
	public String cartShow(Model model, User user) {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		User findUser = userSERVICE.findUser(aut.getName());
		
		List<Pizza> orderPizzas = pizzaSERVICE.OrderPizzas(findUser.getUserId());
		List<Drink> orderDrink = drinkService.OrderDrink(findUser.getUserId());
		
		model.addAttribute("choose", orderPizzas);
		model.addAttribute("drinkchose", orderDrink);
		return "View/cart";
	}
	@GetMapping("/deleteOrder")
		public String deleteOrder(User user){
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		User findUser = userSERVICE.findUser(aut.getName());
		System.out.println(findUser.getUserId());
		userSERVICE.deleteOrder(findUser.getUserId());
       return"View/cart";
	}
	
	

}
