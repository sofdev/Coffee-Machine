package fr.lcdlv.kata.CoffeeMachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeMachineApplication.class, args);

		DrinkOrder order = new DrinkOrder.DrinkOrderBuilder().withDrink(Drink.COFFEE).withExtraHot(true).withNoSugar()
				.withCredit(2.0).build();
		DrinkCommand command = new DrinkCommand(order);
		String result = command.send();
		
		System.out.println("#####################################");
		System.out.println("Drink Maker will make "+ Drink.COFFEE + " with "+ order.sugarQuantity() + "sugar ===>  "+result);
	}

}
