/**
 * FilledCoffeePackage.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.coffeepackages;

import java.io.Serializable;

import by.pvt.hermanovich.coffeetrailer.entities.coffee.Coffee;

/**
 * This class describes an entity <b>FilledCoffeePackage</b>. This class
 * describes the coffee package filled with coffee.
 * 
 * @author Hermanovich Y.
 * @version 1.0
 * @see EmptyPackage
 * @see Box
 * @see Jar
 * @see Parcel
 */
public class FilledCoffeePackage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9045870361968032695L;
	private static int countPackage = 0;
	private int id;
	private EmptyPackage emptyPackage;
	private Coffee coffee;

	/**
	 * Creates new entity of the class <b>{@code FilledCoffeePackage}</b>
	 */
	public FilledCoffeePackage() {
		super();
	}

	/**
	 * Creates new entity (object) of class <b>{@code FilledCoffeePackage}</b>
	 * with the following characters and initializes it. The constructor creates
	 * the coffee package filled with coffee, using foregoing characters and new
	 * objects (emptyPackage and coffee) as incoming arguments. This constructor
	 * uses by Packer Class method which calculates full cost of coffee package.
	 * 
	 * @see by.pvt.hermanovich.coffeetrailer.entities.Packer.
	 * @param id (static) A serial number of coffee package filled with coffee.
	 * @param emptyPackage An incoming coffeePackage object.
	 * @param coffee An incoming coffee object.
	 */
	public FilledCoffeePackage(EmptyPackage emptyPackage, Coffee coffee) {
		this.emptyPackage = emptyPackage;
		this.coffee = coffee;
	}

	{
		countPackage++;
		id = countPackage;
	}

	private double getCost() {
		return (emptyPackage.getCost() + coffee.getCost());
	}

	public static int getCount() {
		return countPackage;
	}

	public static void setCount(int countPackage) {
		FilledCoffeePackage.countPackage = countPackage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmptyPackage getEmptyPackage() {
		return emptyPackage;
	}

	public void setEmptyPackage(EmptyPackage emptyPackage) {
		this.emptyPackage = emptyPackage;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public String toString() {
		return ( "CoffeePackage #" + id + " (" + emptyPackage.getKind() + ")" + ": cost " + getCost() + " byn"
														+ ", weight " + coffee.getWeight() + " g" + "; filled with " + coffee.getKind()
														+ ", sort " + coffee.getSort() + ", manufactured by " + coffee.getBrand() );
	}
}
