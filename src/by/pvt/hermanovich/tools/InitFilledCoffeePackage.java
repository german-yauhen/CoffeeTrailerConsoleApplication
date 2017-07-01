package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;
import by.pvt.hermanovich.coffeetrailer.entities.person.Packer;

public class InitFilledCoffeePackage implements Messages {

	private static int numObj = DataBase.listOfCoffee.size();
	private int answer;

	public void start() {
		System.out.println(REQUEST_FILL_COFFEEPACKAGES);
		try {
			Thread.sleep(1500);
		}
		catch (InterruptedException e) {
			Logger.log(e);
		}
		Packer packer = new Packer("Yauheni", 30, 800);
		createFilledCoffeePackage(packer);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(REPORT_FILL_COFFEEPACKAGES);
			requestPrintFilledCoffeePackage(reader);
		}
		catch (IOException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
		}
	}

	public static void createFilledCoffeePackage(Packer packer) {
		for (int i = 0; i < numObj; i++) {
			DataBase.listOfFilledCoffeePackages.add(packer.createFilledCoffeePackage(
			        DataBase.listOfEmptyPackages.get(i), DataBase.listOfCoffee.get(i)));
		}
	}

	private void requestPrintFilledCoffeePackage(BufferedReader reader) throws IOException {
		try {
			answer = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestPrintFilledCoffeePackage(reader);
		}
		if (answer < 1 || answer > 2) {
			System.out.println(ERR_COFFEE_OBJ);
			requestPrintFilledCoffeePackage(reader);
		}
			switch (answer) {
				case 1:
					System.out.println(LIST_FILLED_COFFEEPACKAGES);
					DataBase.printListFilledCoffeePackages();
					break;
				case 2:
					break;
				default:
					break;
			}
	}
}
