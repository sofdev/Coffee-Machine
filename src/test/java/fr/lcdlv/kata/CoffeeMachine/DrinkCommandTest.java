package fr.lcdlv.kata.CoffeeMachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrinkCommandTest {

	DrinkCommand command;
	
	
	@Test
	public void order_with_no_sugar_test() {
		DrinkOrder order = new DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withNoSugar().withCredit(2.0).build();

		command = new DrinkCommand(order);
		String commande = command.commandeFormatter();
		Assertions.assertEquals("CH::", commande);		
	}
	
	@Test
	public void order_with_sugar_test() {
		DrinkOrder order = new DrinkOrderBuilder().withDrink(Drink.TEA).withSugar(2).withCredit(2.0).build();
		
		command = new DrinkCommand(order);
		String commande = command.commandeFormatter();
		Assertions.assertEquals(commande, "T:2:0");
	}
	
	@Test
	public void should_add_stick_to_order_with_sugar() {
		DrinkOrder order = new DrinkOrderBuilder().withDrink(Drink.COFFEE).withSugar(2).withCredit(2.0).build();

		command = new DrinkCommand(order);
		String commande = command.commandeFormatter();
		Assertions.assertEquals(commande, "C:2:0");
	}
	
	@Test
	public void send_command_with_sufficient_money() {
		DrinkOrder order = new DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withNoSugar().withCredit(2.0).build();

		command = new DrinkCommand(order);
		String commandString = command.send();
		Assertions.assertEquals("CH::", commandString);	
		
	}
	
	@Test
	public void send_command_with_insufficient_money() {
		DrinkOrder order = new DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withNoSugar().withCredit(0.1).build();

		command = new DrinkCommand(order);
		String commandString = command.send();
		Assertions.assertEquals("M: No enough credit, please add 0.4 euro", commandString);	
		
	}
	
	 @Test
	  public void forward_custom_message() {
		 command = new DrinkCommand();
	    final String message = command.forwardMessage("Custom message");
	    Assertions.assertEquals(message, "M:Custom message");
	  }
	
}
