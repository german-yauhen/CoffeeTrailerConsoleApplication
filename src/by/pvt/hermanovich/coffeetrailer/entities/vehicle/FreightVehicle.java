/**
 * FreightVehicle.
 * 
 * Version 1.0
 * 
 * 14.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.vehicle;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.MovAbility;
import by.pvt.hermanovich.coffeetrailer.exceptions.OverLoadException;

/**
 * Abstract class FreightVehicle includes and describes all types of vehicles
 * intend for transportation the goods.
 * 
 * @author Hermanovich Y.
 */
public abstract class FreightVehicle implements MovAbility {
	protected String model;
	protected double capacity;
	protected double amount;

	public abstract void amountControl();

	public abstract void loadGoods() throws OverLoadException;

	public abstract void unloadGoods();

	public abstract void sortGoods();

	public FreightVehicle() {
		super();
	}

	public FreightVehicle(String model, double capacity, double amount) {
		super();
		this.model = model;
		this.capacity = capacity;
		this.amount = amount;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
