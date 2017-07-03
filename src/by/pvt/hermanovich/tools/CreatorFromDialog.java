package by.pvt.hermanovich.tools;

public class CreatorFromDialog {
	public void start() {
		InitCoffee initCoffee = new InitCoffee();
		initCoffee.start();
		InitEmptyPackage initEmptyPackage = new InitEmptyPackage();
		initEmptyPackage.start();
		InitFilledCoffeePackage initFilledCoffeePackage = new InitFilledCoffeePackage();
		initFilledCoffeePackage.start();
	}
}
