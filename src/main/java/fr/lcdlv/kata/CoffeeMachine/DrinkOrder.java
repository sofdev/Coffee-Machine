package fr.lcdlv.kata.CoffeeMachine;

public class DrinkOrder {

	private final Drink drink;
	private int sugarQuantity;
	private Double credit;
	private boolean extraHot = false;

	public DrinkOrder(DrinkOrderBuilder drinkOrder) {
		this.drink = drinkOrder.drink;
		this.sugarQuantity = drinkOrder.sugarQuantity;
		this.credit = drinkOrder.credit;
		this.extraHot = drinkOrder.extraHot;
	}

	public DrinkOrder(JuiceBuilder juiceBuilder) {
		this.drink = Drink.ORANGE_JUICE;
		this.credit = juiceBuilder.credit;
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

	public boolean isExtraHot() {
		return extraHot;
	}

	public static class JuiceBuilder {
		private Double credit;

		public JuiceBuilder withCredit(Double credit) {
			this.credit = credit;
			return this;
		}

		public DrinkOrder build() {
			return new DrinkOrder(this);
		}
	}

	public static class DrinkOrderBuilder {
		private Drink drink;
		private int sugarQuantity;
		private Double credit;
		private boolean extraHot = false;

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

		public DrinkOrderBuilder withExtraHot(boolean extraHost) {
			this.extraHot = extraHost;
			return this;

		}

		public DrinkOrder build() {
			return new DrinkOrder(this);
		}
	}

}
