/**
 * Parcel.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.coffeepackages;

import java.io.Serializable;

/**
 * This class describes an entity <b>Parcel</b> package. This class a descendant
 * class (child) from the parent class EmptyPackage.
 * @see by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage
 * @author Hermanovich Y.
 * @version 1.0
 */
public class Parcel extends EmptyPackage implements Serializable {
	/**
	 * 
	 */
  private static final long serialVersionUID = -384043497984134858L;
	public static double costPerGramm = 0.005;

	/**
	 * Creates new entity of the class <b>{@code Parcel}</b>
	 */
	public Parcel() {
		super();
	}

	/**
	 * Creates new entity (object) of class <b>{@code Parcel}</b> with the
	 * following characters and initializes it. This constructor creates the empty
	 * Parcel.
	 * 
	 * @param kind A kind 'Parcel' of empty coffee package 
	 * @param capacity A capacity of empty coffee package depends on quantity of chosen coffee
	 */
	public Parcel(String kind, double capacity) {
		this.kind = kind;
		this.capacity = capacity;
		this.cost = (costPerGramm * capacity);
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		return " " + kind + " (cost " + String.format("%.2f", cost) + " byn, capacity " + capacity + "g)";
	}
}
