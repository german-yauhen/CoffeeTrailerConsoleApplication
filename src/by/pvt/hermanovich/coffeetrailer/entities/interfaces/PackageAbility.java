/**
 * PackageAbility Interface.
 * 
 * Version 1.0
 * 
 * 14.01.2017
 * 
 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
 */
package by.pvt.hermanovich.coffeetrailer.entities.interfaces;

import by.pvt.hermanovich.coffeetrailer.entities.coffee.Coffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.FilledCoffeePackage;

public interface PackageAbility {
	public abstract FilledCoffeePackage createFilledCoffeePackage(EmptyPackage emptyPackage, Coffee coffee);
}