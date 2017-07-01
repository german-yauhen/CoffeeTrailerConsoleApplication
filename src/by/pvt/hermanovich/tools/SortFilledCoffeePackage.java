package by.pvt.hermanovich.tools;

import java.util.Collections;
import java.util.Comparator;

import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.FilledCoffeePackage;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class SortFilledCoffeePackage implements Messages {

	public void start() {
		
		System.out.println(DELIMETER);
		System.out.println(SORT_FILLED_COFFEE_PACKAGES_COST);
	  Comparator<FilledCoffeePackage> comparatorCost = new Comparator<FilledCoffeePackage>() {
      public int compare(FilledCoffeePackage filledCoffeePackage1, FilledCoffeePackage filledCoffeePackage2) {
	      return Double.compare(filledCoffeePackage1.getCoffee().getCost(), filledCoffeePackage2.getCoffee().getCost());
      }
		};
		Collections.sort(DataBase.listOfFilledCoffeePackages, comparatorCost);
		DataBase.printListFilledCoffeePackages();
		
		System.out.println(SORT_FILLED_COFFEE_PACKAGES_WEIGHT);
		Comparator<FilledCoffeePackage> comparatorWeight = new Comparator<FilledCoffeePackage>() {
      public int compare(FilledCoffeePackage filledCoffeePackage1, FilledCoffeePackage filledCoffeePackage2) {
	      return Double.compare(filledCoffeePackage1.getCoffee().getWeight(), filledCoffeePackage2.getCoffee().getWeight());
      }
		};
		Collections.sort(DataBase.listOfFilledCoffeePackages, comparatorWeight);
		DataBase.printListFilledCoffeePackages();
		System.out.println(DELIMETER);
  }
	
}
