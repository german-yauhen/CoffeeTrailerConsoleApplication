/**
 * Person.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.person;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.PackageAbility;

/**
 * This class describes an entity <b>Person</b>. This is the parent class for
 * Packer class.
 * 
 * @author Hermanovich Y.
 * @version 1.0
 * @see Packer
 */
public abstract class Employee implements PackageAbility {
	protected String name;
	protected double age;
	protected double monthlyPay;

	/**
	 * Creates new entity of the class <b>{@code Person}</b>
	 */
	public Employee() {
		super();
	} 

	/**
	 * Creates new entity (object) of class <b>{@code Person}</b> with the
	 * following characters and initializes its.
	 * 
	 * @param name
	 *            Persons name.
	 * @param age
	 *            Person's age.
	 * @param monthlyPay
	 *            Person's monthlyPay
	 */
	public Employee(String name, double age, double monthlyPay) {
		super();
		this.name = name;
		this.age = age;
		this.monthlyPay = monthlyPay;
	}

	/**
	 * @return name Person's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Person's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return age Person's age
	 */
	public double getAge() {
		return age;
	}

	/**
	 * @param age
	 *            Person's age to set
	 */
	public void setAge(double age) {
		this.age = age;
	}

	/**
	 * @return monthPay Person's montPay
	 */
	public double getMonthlyPay() {
		return monthlyPay;
	}

	/**
	 * @param monthlyPay
	 *            Person's montPay to set
	 */
	public void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(age);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(monthlyPay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Double.doubleToLongBits(age) != Double.doubleToLongBits(other.age))
			return false;
		if (Double.doubleToLongBits(monthlyPay) != Double.doubleToLongBits(other.monthlyPay))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
