package fr.lcdlv.kata.CoffeeMachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrinkOrderTest {

	@Test
	public void build_order_with_sugar_test() {
		DrinkOrder order = new DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withSugar(1).withCredit(2.0).build();

		Assertions.assertEquals(order.sugarQuantity(), 1);
	}

	@Test
	public void build_order_with_no_sugar_test() {
		DrinkOrder order = new DrinkOrderBuilder().withDrink(Drink.TEA).withNoSugar().withCredit(2.0).build();

		Assertions.assertEquals(order.sugarQuantity(), 0);
	}

}
