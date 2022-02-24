package hu.citec.entity;

public class Order {
	private Integer userID;
	private Integer pizzaID;
	private String pizzaName;
	private Integer pizzaCost;

	public Order(Integer userID, Integer pizzaID, String pizzaName, Integer pizzaCost) {

		this.userID = userID;
		this.pizzaID = pizzaID;
		this.pizzaName = pizzaName;
		this.pizzaCost = pizzaCost;
	}

	public Order() {

	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getPizzaID() {
		return pizzaID;
	}

	public void setPizzaID(Integer pizzaID) {
		this.pizzaID = pizzaID;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public Integer getPizzaCost() {
		return pizzaCost;
	}

	public void setPizzaCost(Integer pizzaCost) {
		this.pizzaCost = pizzaCost;
	}

}
