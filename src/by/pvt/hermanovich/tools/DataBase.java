package by.pvt.hermanovich.tools;

import java.util.*;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.Coffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.FilledCoffeePackage;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class DataBase implements Messages {

	public static List<Coffee> listOfCoffee = new ArrayList<>();
	public static List<EmptyPackage> listOfEmptyPackages = new ArrayList<>();
	public static List<FilledCoffeePackage> listOfFilledCoffeePackages = new ArrayList<>();

	public static void printListCoffee() {
		for (int i = 0; i < listOfCoffee.size(); i++) {
			System.out.println((i + 1) + " coffee: " + listOfCoffee.get(i));
		}
	}

	public static void printListEmptyPackages() {
		for (int i = 0; i < listOfEmptyPackages.size(); i++) {
			System.out.println((i + 1) + " empty package:" + listOfEmptyPackages.get(i) + " for "
					+ listOfCoffee.get(i).getKind() + " ("
					+ listOfCoffee.get(i).getSort() + ", "
					+ listOfCoffee.get(i).getWeight() + "g).");
		}
	}

	public static void printListFilledCoffeePackages() {
		Iterator<FilledCoffeePackage> it = listOfFilledCoffeePackages.iterator();
		while (it.hasNext()) {
	   		System.out.println(it.next());
    	}
	}

}
