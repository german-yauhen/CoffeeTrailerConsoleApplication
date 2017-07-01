/**
 * Packer.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.person;

import by.pvt.hermanovich.coffeetrailer.entities.coffee.Coffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.FilledCoffeePackage;

/**
 * This class describes an entity <b>Packer</b>. This class is a descendant
 * class (child) from the parent class Person. This class has and also
 * subscribes the method to create and calculate summary cost of a coffee
 * package filling with coffee.
 * 
 * @author Hermanovich Y.
 * @version 1.0
 * @see Packer
 */
public class Packer extends Employee {

	private EmptyPackage emptyPackage;
	private Coffee coffee;

	/**
	 * Creates new entity of the class <b>{@code Packer}</b>
	 */
	public Packer() {
		super();
	} // end of default constructor

	/**
	 * Creates new entity (object) of class <b>{@code Packer}</b> with the
	 * following characters and initializes its.
	 * 
	 * @param name
	 *            Packer's name.
	 * @param age
	 *            Packer's age.
	 * @param monthlyPay
	 *            Packer's monthlyPay
	 */

	public Packer(String name, double age, double monthlyPay) {
		super(name, age, monthlyPay);
	}

	/**
	 * The method called createFilledCoffeePackage creates new object coffee
	 * package filled with coffee.
	 */
	public FilledCoffeePackage createFilledCoffeePackage(EmptyPackage emptyPackage, Coffee coffee) {
		return new FilledCoffeePackage(emptyPackage, coffee);
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public EmptyPackage getEmptyPackage() {
		return emptyPackage;
	}

	public void setEmptyPackage(EmptyPackage emptyPackage) {
		this.emptyPackage = emptyPackage;
	}

}
