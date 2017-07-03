/**
 * GrindCoffee.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.coffee;

import java.io.Serializable;

import by.pvt.hermanovich.enums.Brand;
import by.pvt.hermanovich.enums.Sort;

/**
 * GrindCoffee class is a descendant class (child) from the parent class Coffee.
 * 
 * @see Coffee
 * @author Hermanovich Y.
 * @version 1.0
 */
public class GroundCoffee extends Coffee implements Serializable {
	/**
	 * 
	 */
  private static final long serialVersionUID = -6076346391315071553L;
	public static double costPerGramm = 0.085;
	public double cost;

	/**
	 * Creates new entity of the class <b>{@code GrindCoffee}</b>
	 */
	public GroundCoffee() {
		super();
	}

	/**
	 * Creates new entity of the class <b>{@code GrindCoffee}</b> and initialized its.
	 * 
	 * @param kind
	 *          Grind coffee.
	 * @param weight
	 *          A weight (quantity) of coffee.
	 * @param sort
	 *          Sort of coffee from Enum.Sort
	 * @param brand
	 *          A brand of coffee from Enum.Brands
	 */
	public GroundCoffee(String kind, double weight, Sort sort, Brand brand) {
		super(kind, weight, sort, brand);
		this.cost = (costPerGramm * weight);
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroundCoffee other = (GroundCoffee) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		return true;
	}

	public String toString() {
		return (kind + ", sort " + sort + ", manufactured by " + brand + ", cost per " + weight + "g" + " (without a package) is " + String.format("%.2f", cost) + " byn.");
	}
}
