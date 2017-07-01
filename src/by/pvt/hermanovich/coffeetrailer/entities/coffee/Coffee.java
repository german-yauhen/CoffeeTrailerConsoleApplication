/**
 * Coffee.
 * 
 * Version 1.0
 * 
 * 13.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.coffee;

import by.pvt.hermanovich.enums.Brand;
import by.pvt.hermanovich.enums.Sort;

/**
 * This class describes an entity <b>Coffee</b>. This class is a parent class
 * and subscribes all characters and methods for objects extended from it.
 * 
 * @author Hermanovich Y.
 * @version 1.0
 * @see by.pvt.hermanovich.coffeetrailer.entities.coffee.GrainCoffee
 * @see by.pvt.hermanovich.coffeetrailer.entities.coffee.GroundCoffee
 * @see by.pvt.hermanovich.coffeetrailer.entities.coffee.SolubleCoffee
 * @see Brand
 * @see Sort
 */
public abstract class Coffee {
	protected String kind;
	protected double weight;
	protected double cost;
	protected Sort sort;
	protected Brand brand;

	/**
	 * Creates new entity of the class <b>{@code Coffee}</b>
	 */
	public Coffee() {
		super();
	}

	/**
	 * Creates new entity (object) of the class <b>{@code Coffee}</b> with the
	 * following characters and initializes it.
	 * 
	 * @param kind
	 *          A kind of coffee, for example grain, grind or soluble coffee.
	 * @param brand
	 *          A brand of coffee. Takes from Enum.Brand
	 * @param sort
	 *          Sort of coffee. Takes from Enum.Sort
	 * @param cost
	 */
	public Coffee(String kind, double weight, Sort sort, Brand brand) {
		super();
		this.kind = kind;
		this.weight = weight;
		this.sort = sort;
		this.brand = brand;
	}

	public abstract double getCost();
	
	public abstract void setCost(double cost);

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + ((brand == null) ? 0 : brand.hashCode());
	  result = prime * result + ((kind == null) ? 0 : kind.hashCode());
	  result = prime * result + ((sort == null) ? 0 : sort.hashCode());
	  long temp;
	  temp = Double.doubleToLongBits(weight);
	  result = prime * result + (int) (temp ^ (temp >>> 32));
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
	  Coffee other = (Coffee) obj;
	  if (brand != other.brand)
		  return false;
	  if (kind == null) {
		  if (other.kind != null)
			  return false;
	  } else if (!kind.equals(other.kind))
		  return false;
	  if (sort != other.sort)
		  return false;
	  if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
		  return false;
	  return true;
  }
	
	public String toString() {
		return (kind + ", sort " + sort + ", manufactured by " + brand + ", cost per " + weight + "g" + " (without a package) is " + cost + " byn.");
	}
	
}
