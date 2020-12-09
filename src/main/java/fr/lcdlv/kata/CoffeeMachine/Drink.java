package fr.lcdlv.kata.CoffeeMachine;

public enum Drink {

	TEA("T", 0.4), COFFEE("C", 0.6), CHOCOLATE("H", 0.5), ORANGE_JUICE("O", 0.6);

	private String code;
	private double price;

	Drink(String code, double price) {
		this.code = code;
		this.price = price;
	}

	public String code() {
		return code;
	}

	public double price() {
		return price;
	}
}
