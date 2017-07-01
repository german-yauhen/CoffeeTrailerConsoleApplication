package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Box;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Jar;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Parcel;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class InitEmptyPackage implements Messages {

	public int numKindPackage;
	private int numObj = DataBase.listOfCoffee.size();
	private int numCoffee = 0;
	private int answer;

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
		System.out.println(REQUEST_FOR + DataBase.listOfCoffee.get(numCoffee).getKind() + ", "
																		+ DataBase.listOfCoffee.get(numCoffee).getWeight() + " g, sort "
																		+ DataBase.listOfCoffee.get(numCoffee).getSort());
		try {
			numKindPackage = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(CHOOSE_THE_CORRECT_KIND);
			Logger.log(e);
			requestKindEmptyPackage(reader);
		}
		if (numKindPackage < 1 || numKindPackage > 3) {
			System.out.println(CHOOSE_THE_CORRECT_KIND);
			requestKindEmptyPackage(reader);
		}
		String kind = null;
		EmptyPackage emptyPackage = null;
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
				break;
		}
		numObj--;
		numCoffee++;
		if (numObj > 0) {
			requestKindEmptyPackage(reader);
		}
	}

	private void requestPrintListOfEmptyPackages(BufferedReader reader) throws IOException {
		System.out.println(PRINT_LIST_EMPTY_PACKAGES_REQUEST);
		try {
			answer = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestPrintListOfEmptyPackages(reader);
		}
		if (answer < 1 || answer > 2) {
			System.out.println(ERR_COFFEE_OBJ);
			requestPrintListOfEmptyPackages(reader);
		}
		switch (answer) {
			case 1:
				System.out.println(LIST_EMPTY_PACKAGES);
				DataBase.printListEmptyPackages();
				break;
			case 2:
				break;
			default:
				break;
		}
	}
}