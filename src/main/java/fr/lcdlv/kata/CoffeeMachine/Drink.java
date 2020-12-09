package fr.lcdlv.kata.CoffeeMachine;

public enum Drink {

	TEA("T", 0.4), COFFEE("C", 0.6), CHOCOLATE("CH", 0.5);

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
