/**
 * InitCoffee
 * 
 * Version 1.0
 * 
 * 16.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 * */
package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.pvt.hermanovich.coffeetrailer.entities.coffee.Coffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.GrainCoffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.GroundCoffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.SolubleCoffee;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;
import by.pvt.hermanovich.enums.Brand;
import by.pvt.hermanovich.enums.Sort;

public class CoffeeCreator implements Messages {

	private static int sortNum;
	private static int brandNum;
	private static double buffWeight;

	public static void createCoffee(String kind) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			Double weight = requestCoffeeWeight(reader);
			Sort sort = requestCoffeeSort(reader);
			Brand brand = requestCoffeeBrand(reader);
			addToDataBase(kind, weight, sort, brand);
		}
		catch (IOException e) {
			System.out.println(WRONG_DATA);
			Logger.log(e);
		}
	}

	private static Double requestCoffeeWeight(BufferedReader reader) throws IOException {
		System.out.print(ENTER_WEIGHT_OF_COFFEE);
		try {
			buffWeight = Double.parseDouble(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestCoffeeWeight(reader);
		}
		double weight = buffWeight;
		if (weight <= 0) {
			System.out.println(ERR_COFFEE_OBJ);
			requestCoffeeWeight(reader);
		}
		return weight;
	}

	private static Sort requestCoffeeSort(BufferedReader reader) throws IOException {
		System.out.println(CHOOSE_SORT_OF_COFFEE);
		System.out.println(SORT_OF_COFFEE);
		try {
			sortNum = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(CHOOSE_THE_CORRECT_SORT);
			Logger.log(e);
			requestCoffeeSort(reader);
		}
		if (sortNum < 1 || sortNum > 3) {
			System.out.println(CHOOSE_THE_CORRECT_SORT);
			requestCoffeeSort(reader);
		}
		Sort sort = null;
		switch (sortNum) {
			case 1:
				sort = Sort.ARABICA;
				break;
			case 2:
				sort = Sort.ROBUSTA;
				break;
			case 3:
				sort = Sort.BLENDED;
				break;
			default:
				System.out.println(CHOOSE_THE_CORRECT_SORT);
				break;
		}
		return sort;
	}

	private static Brand requestCoffeeBrand(BufferedReader reader) throws IOException {
		System.out.println(CHOOSE_BRAND_OF_COFFEE);
		System.out.println(BRAND_OF_COFFEE);
		try {
			brandNum = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(CHOOSE_THE_CORRECT_BRAND);
			Logger.log(e);
			requestCoffeeBrand(reader);
		}
		if (brandNum < 1 || brandNum > 3) {
			System.out.println(CHOOSE_THE_CORRECT_BRAND);
			requestCoffeeBrand(reader);
		}
		Brand brand = null;
		switch (brandNum) {
			case 1:
				brand = Brand.ILLY;
				break;
			case 2:
				brand = Brand.LAVAZZA;
				break;
			case 3:
				brand = Brand.COMPAGNIA_DELL_ARABICA;
				break;
			default:
				System.out.println(CHOOSE_THE_CORRECT_BRAND);
				break;
		}
		return brand;
	}

	private static void addToDataBase(String kind, Double weight, Sort sort, Brand brand) {
		Coffee coffee = null;
		switch (kind) {
			case GRAIN:
				coffee = new GrainCoffee(kind, weight, sort, brand);
				DataBase.listOfCoffee.add(coffee);
				break;
			case GRIND:
				coffee = new GroundCoffee(kind, weight, sort, brand);
				DataBase.listOfCoffee.add(coffee);
				break;
			case SOLUBLE:
				coffee = new SolubleCoffee(kind, weight, sort, brand);
				DataBase.listOfCoffee.add(coffee);
				break;
			default:
				System.out.println(ERR_KIND_OF_COFFEE);
				break;
		}
		System.out.println(FINAL_CHOICE + coffee);
	}

}
