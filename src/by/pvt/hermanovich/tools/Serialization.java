package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.List;

import by.pvt.hermanovich.coffeetrailer.entities.coffee.Coffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.FilledCoffeePackage;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class Serialization implements Messages {
	
	private int answer;
	
	public void start() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(REQUEST_SERIALIZATION);
			requestSerialization(reader);
			System.out.println(REPORT_WRITE + OUTPUT_FOLDER + "***.ser files");
		}
		catch (IOException e) {
			Logger.log(e);
		}
	}
	
	private void requestSerialization(BufferedReader reader) throws IOException {
		try {
			answer = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestSerialization(reader);
		}
		if (answer < 1 || answer > 2) {
			System.out.println(ERR_COFFEE_OBJ);
			requestSerialization(reader);
		}
		switch (answer) {
			case 1:
				coffeeSerialization(DataBase.listOfCoffee);
				emptyPackagesSerialization(DataBase.listOfEmptyPackages);
				filledCoffeePackagesSerialization(DataBase.listOfFilledCoffeePackages);
				break;
			case 2:
				break;
			default:
				break;
		}
	}

	public static void filledCoffeePackagesSerialization(List<FilledCoffeePackage> listOfFilledCoffeePackages) throws IOException {
		File serFilledPackagesFile = new File(OUTPUT_FOLDER + "FilledCoffeePackages.ser");
		CleanerOfFile.cleanFile(serFilledPackagesFile);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serFilledPackagesFile))) {
			for (FilledCoffeePackage filledCoffeePackage : listOfFilledCoffeePackages) {
				objectOutputStream.writeObject(filledCoffeePackage);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(ERR_CREATE_FILE_OBJECT + e);
			Logger.log(e);
		}
		catch (NotSerializableException e) {
			System.out.println(ERR_SERIALIZATION_OBJECT + e);
			Logger.log(e);
		}
		catch (IOException e) {
			Logger.log(e);
		}
	}

	public static void emptyPackagesSerialization(List<EmptyPackage> listOfEmptyPackages) throws IOException {
		File serEmptyPackagesFile = new File(OUTPUT_FOLDER + "EmptyPackages.ser");
		CleanerOfFile.cleanFile(serEmptyPackagesFile);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serEmptyPackagesFile))) {
				for (EmptyPackage emptyPackage : listOfEmptyPackages) {
					objectOutputStream.writeObject(emptyPackage);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(ERR_CREATE_FILE_OBJECT + e);
			Logger.log(e);
		}
		catch (NotSerializableException e) {
			System.out.println(ERR_SERIALIZATION_OBJECT + e);
			Logger.log(e);
		}
		catch (IOException e) {
			System.out.println(e);
			Logger.log(e);
		}
	}

	public static void coffeeSerialization(List<Coffee> listOfCoffee) throws IOException {
		File serCoffeeFile = new File(OUTPUT_FOLDER + "Coffee.ser");
		CleanerOfFile.cleanFile(serCoffeeFile);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serCoffeeFile))) {
			for (Coffee coffee : listOfCoffee) {
				objectOutputStream.writeObject(coffee);
      }
		}
		catch (FileNotFoundException e) {
			System.out.println(ERR_CREATE_FILE_OBJECT + e);
			Logger.log(e);
		}
		catch (NotSerializableException e) {
			System.out.println(ERR_SERIALIZATION_OBJECT + e);
			Logger.log(e);
		}
		catch (IOException e) {
			System.out.println(e);
			Logger.log(e);
		}
	}

}
