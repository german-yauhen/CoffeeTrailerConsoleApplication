package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class InitCoffee implements Messages {

	private int numObj;
	private int kindCoffeeNum;
	private int answer;

	public void start() {
		BufferedReader reader = null;
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
		try {
			numObj = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestNumCoffeeObjects(reader);
		}
		if (numObj < 1) {
			System.out.println(ERR_COFFEE_OBJ);
			requestNumCoffeeObjects(reader);
		}
	}

	private void requestCoffeeKind(BufferedReader reader) throws IOException {
		System.out.println(CHOOSE_KIND_OF_COFFEE);
		System.out.println(KIND_OF_COFFEE);
		try {
			kindCoffeeNum = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(CHOOSE_THE_CORRECT_KIND);
			Logger.log(e);
			requestCoffeeKind(reader);
		}
		if (kindCoffeeNum < 1 || kindCoffeeNum > 3) {
			System.out.println(CHOOSE_THE_CORRECT_KIND);
			requestCoffeeKind(reader);
		}
		String kind = null;
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
				break;
		}
		numObj--;
		if (numObj > 0) {
			requestCoffeeKind(reader);
		}
	}

	private void requestPrintLisOfCoffee(BufferedReader reader) throws IOException {
		System.out.println(PRINT_LIST_COFFEE_REQUEST);
		try {
			answer = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestPrintLisOfCoffee(reader);
		}
		if (answer < 1 || answer > 2) {
			System.out.println(ERR_COFFEE_OBJ);
			requestPrintLisOfCoffee(reader);
		}
		try {
			switch (answer) {
				case 1:
					System.out.println(LIST_COFFEE);
					DataBase.printListCoffee();
					break;
				case 2:
					break;
				default:
					break;
			}
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestPrintLisOfCoffee(reader);
		}
	}
}
