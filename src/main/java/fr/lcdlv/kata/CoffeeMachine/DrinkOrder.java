package fr.lcdlv.kata.CoffeeMachine;

public class DrinkOrder {

	private final Drink drink;
	private int sugarQuantity;
	private final Double credit;

	public DrinkOrder(Drink drink, int sugarQuantity, Double credit) {
		this.drink = drink;
		this.sugarQuantity = sugarQuantity;
		this.credit = credit;
	}

	public String commandeFormatter() {
		return String.format("%s:%s:%s", this.drink.code(), this.sugarQuantity > 0 ? this.sugarQuantity : "",
				this.sugarQuantity > 0 ? 1 : "");
	}

	public void addSugar() {
		this.sugarQuantity++;
	}

	private void command(String commandString) {
		//TODO : to implement next iteration
	}
}
