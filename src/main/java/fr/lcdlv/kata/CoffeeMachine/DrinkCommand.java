package fr.lcdlv.kata.CoffeeMachine;

public class DrinkCommand {

	private DrinkOrder order;

	public DrinkCommand(DrinkOrder order) {
		this.order = order;
	}

	public DrinkCommand() {
	}

	public String commandeFormatter() {
		return String.format("%s:%s:%s", this.order.drink().code().concat(order.isExtraHot() ? "h" : ""),
				this.order.sugarQuantity() > 0 ? this.order.sugarQuantity() : "",
				this.order.sugarQuantity() > 0 ? 0 : "");
	}

	public String send() {
		StringBuilder commandString = new StringBuilder();
		if (order.credit() < order.drink().price()) {
			double missingCredit = order.drink().price() - order.credit();
			commandString.append(forwardMessage(String.format(" No enough credit, please add %s euro", missingCredit)));
		} else {

			commandString.append(commandeFormatter());
		}
		return commandString.toString();
	}

	public String forwardMessage(String message) {
		return "M:" + message;
	}
}
