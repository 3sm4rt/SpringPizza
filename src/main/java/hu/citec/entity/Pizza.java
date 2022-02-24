package hu.citec.entity;

public class Pizza {

	private Integer pizzaId;
	private String pizzaName;
	private String description;
	private Integer cost;
	private String img;

	public Pizza() {

	}

	public Pizza(Integer pizzaId, String pizzaName, String description, Integer cost,String img) {

		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.description = description;
		this.cost = cost;
		this.img = img;
	}

	public Integer getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
}
