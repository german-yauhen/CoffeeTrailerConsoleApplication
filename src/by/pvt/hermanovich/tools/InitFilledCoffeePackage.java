package by.pvt.hermanovich.tools;

import java.io.*;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;
import by.pvt.hermanovich.coffeetrailer.entities.person.Packer;
public class InitFilledCoffeePackage implements Messages {

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
		BufferedReader reader;
		while (true) {
			try {
				reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(REPORT_FILL_COFFEEPACKAGES);
				requestPrintFilledCoffeePackage(reader);
				break;
			}
			catch (IOException e) {
				System.out.println(ERR_COFFEE_OBJ);
				Logger.log(e);
				continue;
			}
		}
	}

	public static void createFilledCoffeePackage(Packer packer) {
		int numObj = DataBase.listOfCoffee.size();
		for (int i = 0; i < numObj; i++) {
			DataBase.listOfFilledCoffeePackages.add(packer.createFilledCoffeePackage(
			        DataBase.listOfEmptyPackages.get(i), DataBase.listOfCoffee.get(i)));
		}
	}

	private void requestPrintFilledCoffeePackage(BufferedReader reader) throws IOException {
		while (true) {
			try {
				int answer = Integer.parseInt(reader.readLine());
				switch (answer) {
					case 1:
						System.out.println(LIST_FILLED_COFFEEPACKAGES);
						DataBase.printListFilledCoffeePackages();
						break;
					case 2:
						break;
					default:
						continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println(ERR_COFFEE_OBJ);
				Logger.log(e);
				continue;
			}
		}
	}
}
