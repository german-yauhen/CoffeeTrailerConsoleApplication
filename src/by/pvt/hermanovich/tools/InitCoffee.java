package by.pvt.hermanovich.tools;

import java.io.*;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class InitCoffee implements Messages {
	private int numObj;

	public void start() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			requestNumCoffeeObjects(reader);
			requestCoffeeKind(reader);
			requestPrintLisOfCoffee(reader);
		}
		catch (IOException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
		}
	}

	private void requestNumCoffeeObjects(BufferedReader reader) throws IOException {
		System.out.println(NUM_COFFEE_OBJ);
		while (true) {
			try {
				numObj = Integer.parseInt(reader.readLine());
				if (numObj < 1) {
					System.out.println(ERR_COFFEE_OBJ);
					Logger.log(Messages.ERR_COFFEE_OBJ);
					continue;
				}
			}
			catch (NumberFormatException e) {
				System.out.println(ERR_COFFEE_OBJ);
				Logger.log(e);
				continue;
			}
			break;
		}
	}

	private void requestCoffeeKind(BufferedReader reader) throws IOException {
		while (numObj > 0) {
			System.out.println(CHOOSE_KIND_OF_COFFEE + KIND_OF_COFFEE);
			while (true) {
				try {
					int kindCoffeeNum = Integer.parseInt(reader.readLine());
					String kind;
					switch (kindCoffeeNum) {
						case 1:
							kind = GRAIN;
							CoffeeCreator.createCoffee(kind);
							break;
						case 2:
							kind = GRIND;
							CoffeeCreator.createCoffee(kind);
							break;
						case 3:
							kind = SOLUBLE;
							CoffeeCreator.createCoffee(kind);
							break;
						default:
							System.out.println(CHOOSE_THE_CORRECT_KIND);
							continue;
					}
					break;
				}
				catch (NumberFormatException e) {
					System.out.println(CHOOSE_THE_CORRECT_KIND);
					Logger.log(e);
					continue;
				}
			} // end the inner while
			numObj--;
		} // end the outer while
	}

	private void requestPrintLisOfCoffee(BufferedReader reader) throws IOException {
		System.out.println(PRINT_LIST_COFFEE_REQUEST);
		while (true) {
			try {
				int answer = Integer.parseInt(reader.readLine());
				switch (answer) {
					case 1:
						System.out.println(LIST_COFFEE);
						DataBase.printListCoffee();
						break;
					case 2:
						break;
					default:
						System.out.println(PRINT_LIST_COFFEE_REQUEST);
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
