/**
 * Trailer.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.vehicle;

import java.util.List;

import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.FilledCoffeePackage;
import by.pvt.hermanovich.coffeetrailer.exceptions.OverLoadException;

/**
 * This class describes an entity <b>Trailer</b>. This class has and also
 * subscribes the method to sort the goods according to the task.
 * 
 * @author Hermanovich Y.
 * @version 1.0
 */
public class Trailer extends FreightVehicle {
	private List<EmptyPackage> coffeePackages;

	/**
	 * Creates new entity (object) of the class <b>{@code Trailer}</b>
	 */
	public Trailer() {
		super();
	} // end of default constructor

	/**
	 * Creates new entity (object) of class <b>{@code Trailer}</b> with the
	 * following characters, according to the task, and initializes its.
	 * 
	 * @param capacity
	 *            A capacity of trailer, which contains Coffee Packages filled
	 *            with coffee.
	 * @param amount
	 *            A total amount of money for buying coffee in belarussian
	 *            monetary units - byn
	 * @param coffeePackagies
	 *            Lists of Coffee Packages filled with coffee.
	 * @param model
	 */
	public Trailer(double capacity, double amount, List<EmptyPackage> coffeePackagies, String model) {
		super();
		this.capacity = capacity;
		this.amount = amount;
		this.model = model;
		this.coffeePackages = coffeePackagies;
	}

	public void loadGoods() {
	}

	public void loadGoods(List<FilledCoffeePackage> coffeePackages) throws OverLoadException {
		if (coffeePackages.isEmpty()) {
			throw new OverLoadException();
		} else {

		}

	}

	@Override
	public void move() {
	}

	@Override
	public void amountControl() {

	}

	@Override
	public void unloadGoods() {
	}

	@Override
	public void sortGoods() {

	}

	/**
	 * @return capacity the capacity of trailer
	 */
	public double getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity
	 *            the capacity of trailer to set
	 */
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return amount 
	 * 				the total amount of money for buying coffee
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the total amount of money of money to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the list of coffee packages filling with coffee
	 */
	public List<EmptyPackage> getCofeePackage() {
		return coffeePackages;
	}

	/**
	 * @param cofeePackage
	 *            the list of coffee packages to set
	 */
	public void setCofeePackage(List<EmptyPackage> cofeePackage) {
		this.coffeePackages = cofeePackage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(capacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((coffeePackages == null) ? 0 : coffeePackages.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trailer other = (Trailer) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (Double.doubleToLongBits(capacity) != Double.doubleToLongBits(other.capacity))
			return false;
		if (coffeePackages == null) {
			if (other.coffeePackages != null)
				return false;
		} else if (!coffeePackages.equals(other.coffeePackages))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trailer [coffeePackages=" + coffeePackages + ", model=" + model + ", capacity="
		        + capacity + ", amount=" + amount + "]";
	}
}