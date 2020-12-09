package fr.lcdlv.kata.CoffeeMachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DrinkOrderTest {
	
	@Test
	public void order_with_no_sugar_test() {
		DrinkOrder order = new DrinkOrder(Drink.CHOCOLATE, 0, 2.0);
		String commande = order.commandeFormatter();
		Assertions.assertEquals("CH::", commande);		
	}
	
	@Test
	public void order_with_sugar_test() {
		DrinkOrder order = new DrinkOrder(Drink.TEA, 2, 2.0);
		String commande = order.commandeFormatter();
		Assertions.assertEquals("2", commande.split(":")[1]);
	}
	
	@Test
	public void should_add_stick_to_order_with_sugar() {
		DrinkOrder order = new DrinkOrder(Drink.COFFEE, 2, 2.0);
		String commande = order.commandeFormatter();
		Assertions.assertEquals("1", commande.split(":")[2]);
	}
	

}
