/**
 * EmptyPackage.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.coffeepackages;

/**
 * This class describes an entity <b>EmptyPackage</b>. This class is a parent
 * class and subscribes all characters and methods for objects extended from it.
 * 
 * @author Hermanovich Y.
 * @version 1.0
 * @see Box
 * @see Jar
 * @see Parcel
 */
public abstract class EmptyPackage {

	protected String kind;
	protected double capacity;
	protected double cost;

	/**
	 * Creates new entity of the class <b>{@code Package}</b>
	 */
	public EmptyPackage() {
		super();
	}

	/**
	 * Creates new entity (object) of class <b>{@code EmptyPackage}</b> with the
	 * following characters and initializes it. This constructor creates the empty
	 * coffee package.
	 *
	 * @param kind A kind of empty coffee package, Box, Jar or Parcel
	 * @param capacity A capacity of empty package depends on chosen quantity of coffee
	 * @param cost A cost of empty package depends on chosen kind of package capacity
	 */

	public EmptyPackage(String kind, double capacity, double cost) {
		super();
		this.kind = kind;
		this.capacity = capacity;
		this.cost = cost;
	}

	// Getters and Setters
	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String type) {
		this.kind = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(capacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmptyPackage other = (EmptyPackage) obj;
		if (Double.doubleToLongBits(capacity) != Double.doubleToLongBits(other.capacity))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		return true;
	}

	public String toString() {
		return " " + kind + " (cost " + String.format("%.2f", cost) + " byn, capacity " + capacity + "g)";
	}
}
