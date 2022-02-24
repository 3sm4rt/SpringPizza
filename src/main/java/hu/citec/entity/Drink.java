package hu.citec.entity;

public class Drink {
	private Integer drinkId;
	private String drinkName;
	private Integer cost;
	private String img;

	public Drink() {

	}

	public Drink(Integer drinkId, String drinkName, Integer cost, String img) {

		this.drinkId = drinkId;
		this.drinkName = drinkName;
		this.cost = cost;
		this.img = img;
	}

	public Integer getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(Integer drinkId) {
		this.drinkId = drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDinkName(String dinkName) {
		this.drinkName = dinkName;
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
