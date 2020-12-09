package fr.lcdlv.kata.CoffeeMachine;

public class DrinkOrder {

	private final Drink drink;
	private int sugarQuantity;
	private Double credit;

	public DrinkOrder(Drink drink, int sugarQuantity, Double credit) {
		this.drink = drink;
		this.sugarQuantity = sugarQuantity;
		this.credit = credit;
	}
	public Drink drink() {
		return drink;
	}

	public Double credit() {
		return credit;
	}

	public int sugarQuantity() {
		return sugarQuantity;
	}

}

class DrinkOrderBuilder {
	private Drink drink;
	private int sugarQuantity;
	private Double credit;

	public DrinkOrderBuilder withDrink(Drink drink) {
		this.drink = drink;
		return this;
	}

	public DrinkOrderBuilder withSugar(int sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
		return this;
	}

	public DrinkOrderBuilder withNoSugar() {
		this.sugarQuantity = 0;
		return this;
	}
	
	public DrinkOrderBuilder withCredit(Double credit) {
		this.credit = credit;
		return this;
	}

	public DrinkOrder build() {
		return new DrinkOrder(this.drink, this.sugarQuantity, this.credit);
	}
}
