package by.pvt.hermanovich.tools;

import java.io.*;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Box;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Jar;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Parcel;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class InitEmptyPackage implements Messages {

	public void start() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(CHOOSE_KIND_OF_PACKAGE);
			System.out.println(KIND_OF_PACKAGE);
			requestKindEmptyPackage(reader);
			requestPrintListOfEmptyPackages(reader);
		}
		catch (IOException e) {
			Logger.log(e);
		}
	}

	private void requestKindEmptyPackage(BufferedReader reader) throws IOException {
		int numObj = DataBase.listOfCoffee.size();
		int numCoffee = 0;
		while (numObj > 0) {
			System.out.println(REQUEST_FOR + DataBase.listOfCoffee.get(numCoffee).getKind() + ", "
					+ DataBase.listOfCoffee.get(numCoffee).getWeight() + " g, sort "
					+ DataBase.listOfCoffee.get(numCoffee).getSort());
			while (true) {
				try {
					int numKindPackage = Integer.parseInt(reader.readLine());
					String kind;
					EmptyPackage emptyPackage;
					switch (numKindPackage) {
						case 1:
							kind = BOX;
							emptyPackage = new Box(kind, DataBase.listOfCoffee.get(numCoffee).getWeight());
							DataBase.listOfEmptyPackages.add(emptyPackage);
							break;
						case 2:
							kind = JAR;
							emptyPackage = new Jar(kind, DataBase.listOfCoffee.get(numCoffee).getWeight());
							DataBase.listOfEmptyPackages.add(emptyPackage);
							break;
						case 3:
							kind = PARCEL;
							emptyPackage = new Parcel(kind, DataBase.listOfCoffee.get(numCoffee).getWeight());
							DataBase.listOfEmptyPackages.add(emptyPackage);
							break;
						default:
							System.out.println(CHOOSE_THE_CORRECT_KIND);
							continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println(CHOOSE_THE_CORRECT_KIND);
					Logger.log(e);
					continue;
				}
			} // end of inner while
			numCoffee++;
			numObj--;
		} // end of outer while
	}

	private void requestPrintListOfEmptyPackages(BufferedReader reader) throws IOException {
		System.out.println(PRINT_LIST_EMPTY_PACKAGES_REQUEST);
		while (true) {
			try {
				int answer = Integer.parseInt(reader.readLine());
				switch (answer) {
					case 1:
						System.out.println(LIST_EMPTY_PACKAGES);
						DataBase.printListEmptyPackages();
						break;
					case 2:
						break;
					default:
						System.out.println(PRINT_LIST_EMPTY_PACKAGES_REQUEST);
						continue;
				}
			} catch (NumberFormatException e) {
				System.out.println(ERR_COFFEE_OBJ);
				Logger.log(e);
				continue;
			}
			break;
		}
	}
}