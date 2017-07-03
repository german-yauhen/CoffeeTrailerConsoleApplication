/**
 * Jar.
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
 * This class describes an entity <b>Jar</b> package. This class a descendant
 * class (child) from the parent class EmptyPackage.
 * @see by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage
 * @author Hermanovich Y.
 * @version 1.0
 */
public class Jar extends EmptyPackage implements Serializable {
	/**
	 * 
	 */
  private static final long serialVersionUID = -282627437538930313L;
	public static double costPerGramm = 0.01;

	/**
	 * Creates new entity of the class <b>{@code Jar}</b>
	 */
	public Jar() {
		super();
	}

	/**
	 * Creates new entity (object) of class <b>{@code Jar}</b> with the following
	 * characters and initializes it. This constructor creates the empty Jar.
	 * 
	 * @param kind A kind 'Jar' of empty coffee package 
	 * @param capacity A capacity of empty coffee package depends on quantity of chosen coffee
	 */
	public Jar(String kind, double capacity) {
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
