package fr.lcdlv.kata.CoffeeMachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DrinkCommandTest {

	DrinkCommand command;

	@Nested
	@DisplayName("Tests ceses for iteration2 features")
	class iteration2 {

		@Test
		public void will_make_one_coffee_with_two_sugar_and_stick() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.COFFEE).withSugar(2).withCredit(1.0)
					.build();

			command = new DrinkCommand(order);
			String commande = command.send();
			Assertions.assertEquals(commande, "C:2:0");
		}

		@Test
		public void will_make_one_chocolate_with_no_sugar() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withNoSugar()
					.withCredit(1.0).build();

			command = new DrinkCommand(order);
			String commande = command.send();
			Assertions.assertEquals(commande, "H::");
		}

		@Test
		public void will_make_one_tea_with_one_sugar_and_stick() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.TEA).withSugar(1).withCredit(1.0)
					.build();

			command = new DrinkCommand(order);
			String commande = command.send();
			Assertions.assertEquals(commande, "T:1:0");
		}

		@Test
		public void should_add_stick_to_order_with_sugar() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.COFFEE).withSugar(2).withCredit(2.0)
					.build();

			command = new DrinkCommand(order);
			String commande = command.commandeFormatter();
			Assertions.assertEquals(commande, "C:2:0");
		}

		@Test
		public void send_command_with_sufficient_money() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withNoSugar()
					.withCredit(2.0).build();

			command = new DrinkCommand(order);
			String commandString = command.send();
			Assertions.assertEquals("H::", commandString);

		}

		@Test
		public void send_command_with_insufficient_money() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withNoSugar()
					.withCredit(0.1).build();

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

	@Nested
	@DisplayName("Tests ceses for iteration3 features")
	class iteration3 {

		@Test
		public void will_make_orange_juice() {
			DrinkOrder order = new DrinkOrder.JuiceBuilder().withCredit(2.0).build();

			command = new DrinkCommand(order);
			String commande = command.send();
			Assertions.assertEquals(commande, "O::");
		}

		@Test
		public void will_make_extra_hot_coffee() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.COFFEE).withExtraHot(true)
					.withNoSugar().withCredit(1.0).build();

			command = new DrinkCommand(order);
			String commande = command.send();
			Assertions.assertEquals(commande, "Ch::");
		}

		@Test
		public void will_make_extra_hot_chocolate_with_one_sugar_and_stick() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.CHOCOLATE).withExtraHot(true)
					.withSugar(1).withCredit(1.0).build();

			command = new DrinkCommand(order);
			String commande = command.send();
			Assertions.assertEquals(commande, "Hh:1:0");
		}

		@Test
		public void will_make_extra_hot_tea_with_two_sugar_and_stick() {
			DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.TEA).withExtraHot(true).withSugar(2)
					.withCredit(1.0).build();

			command = new DrinkCommand(order);
			String commande = command.send();
			Assertions.assertEquals(commande, "Th:2:0");
		}
	}
}
