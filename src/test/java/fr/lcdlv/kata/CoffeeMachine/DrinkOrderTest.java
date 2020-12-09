package fr.lcdlv.kata.CoffeeMachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrinkOrderTest {

	@Test
	public void build_order_with_sugar_test() {
		DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withSugar(1).withCredit(2.0).build();

		Assertions.assertEquals(order.sugarQuantity(), 1);
	}

	@Test
	public void build_order_with_no_sugar_test() {
		DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.TEA).withNoSugar().withCredit(2.0).build();

		Assertions.assertEquals(order.sugarQuantity(), 0);
	}
	
	@Test
	public void build_extra_hot_coffee_order_with_sugar_test() {
		DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.COFFEE).withExtraHot(true).withSugar(1).withCredit(2.0).build();

		Assertions.assertEquals(order.sugarQuantity(), 1);
		Assertions.assertTrue(order.isExtraHot());
	}
	
	
	@Test
	public void build_order_with_orange_juice() {
		DrinkOrder order = new DrinkOrder.JuiceBuilder().withCredit(2.0).build();
		Assertions.assertEquals(order.sugarQuantity(), 0);
		Assertions.assertEquals(order.drink(), Drink.ORANGE_JUICE);
		Assertions.assertFalse(order.isExtraHot());
	}

}
