package by.pvt.hermanovich.tools;

import java.io.*;
import java.util.Iterator;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.Coffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.GrainCoffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.GroundCoffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffee.SolubleCoffee;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Box;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.EmptyPackage;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Jar;
import by.pvt.hermanovich.coffeetrailer.entities.coffeepackages.Parcel;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;
import by.pvt.hermanovich.coffeetrailer.entities.person.Packer;
import by.pvt.hermanovich.enums.Brand;
import by.pvt.hermanovich.enums.Sort;

public class ReaderFromFile implements Messages {

	private static File fileCoffeeInput = new File("src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\input\\Coffee.txt");
	private static File fileEmptyPackageInput = new File("src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\input\\EmptyCoffeePackages.txt");

	public void start() {
		try {
			readCoffeeFromFile(fileCoffeeInput);
			readEmptyPackagesFromFile(fileEmptyPackageInput);
			System.out.println(DELIMETER);
			System.out.println(REPORT_READ_COFFEE);
			DataBase.printListCoffee();
			System.out.println(REPORT_READ_EMPTY_PACKAGES);
			DataBase.printListEmptyPackages();
			Packer packer = new Packer("Myself", 30, 800);
			InitFilledCoffeePackage.createFilledCoffeePackage(packer);
			System.out.println(REPORT_READ_FILLED_COFFEE_PACKAGES);
			DataBase.printListFilledCoffeePackages();
			System.out.println(DELIMETER);
		}
		catch (IOException e) {
			Logger.log(e);
		}
	}
	
	public void readCoffeeFromFile(File file) throws FileNotFoundException {
		Coffee tempCoffee = null;
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new FileReader(fileCoffeeInput));
			while(buffReader.ready()) {
				String stringFromFile = buffReader.readLine();
				String[] splitStringFromFile = stringFromFile.split(" ");
				tempCoffee = setKindOfCoffee(splitStringFromFile, tempCoffee);
				tempCoffee.setKind(splitStringFromFile[0] + " " + splitStringFromFile[1]);
				tempCoffee.setWeight(Double.parseDouble(splitStringFromFile[3]));
				setCostOfCoffee(tempCoffee, splitStringFromFile);
				setSortOfCoffee(tempCoffee, splitStringFromFile);
				setBrandOfCoffee(tempCoffee, splitStringFromFile);
				DataBase.listOfCoffee.add(tempCoffee);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found..." + fileCoffeeInput.getName() + " To inspect available of the current file see the directiory src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\input\\");
			Logger.log(e);
			throw e;
		} catch (IOException e) {
			Logger.log(e);
			System.out.println("There was an input-output error " + fileCoffeeInput.getName() + "For information see the file log.txt");
		} finally {
			try {
				if (buffReader != null) {
					buffReader.close();
				}
			}
			catch (Exception e) {
				System.out.println("There was a closing the stream error.");
			}
		}
	}

	public void readEmptyPackagesFromFile(File file) throws FileNotFoundException {
	  EmptyPackage tempEmptyPackage = null;
	  BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new FileReader(fileEmptyPackageInput));
			while(buffReader.ready()) {
				String stringFromFile = buffReader.readLine();
				String[] splitStringFromFile = stringFromFile.split(" ");
				tempEmptyPackage = setKindOfEmptyPackage(tempEmptyPackage, splitStringFromFile);
				tempEmptyPackage.setKind(splitStringFromFile[1]);
				DataBase.listOfEmptyPackages.add(tempEmptyPackage);
			}
			Iterator<EmptyPackage> it = DataBase.listOfEmptyPackages.iterator();
			for (int i = 0; i < DataBase.listOfEmptyPackages.size(); i++) {
				EmptyPackage tempPackage = it.next();
				tempPackage.setCapacity(DataBase.listOfCoffee.get(i).getWeight());
				if (tempPackage instanceof Box) {
					tempPackage.setCost(tempPackage.getCapacity() * Box.costPerGramm);
				} else if (tempPackage instanceof Jar) {
					tempPackage.setCost(tempPackage.getCapacity() * Jar.costPerGramm);
				} else if (tempPackage instanceof Parcel) {
					tempPackage.setCost(tempPackage.getCapacity() * Parcel.costPerGramm);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found..." + fileCoffeeInput.getName() + " To inspect available of the current file see the directiory src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\input\\");
			Logger.log(e);
			throw e;
		} catch (IOException e) {
			Logger.log(e);
			System.out.println("There was an input-output error " + fileCoffeeInput.getName() + "For information see the file log.txt");
		} finally {
			try {
				if (buffReader != null) {
					buffReader.close();
				}
			}
			catch (Exception e) {
				System.out.println("There was a closing the stream error.");
			}
		}
  }

	private EmptyPackage setKindOfEmptyPackage(EmptyPackage tempEmptyPackage, String[] splitStringFromFile) {
	  switch (splitStringFromFile[1]) {
	  	case BOX:
	  		tempEmptyPackage = new Box();
	  		break;
	  	case JAR:
	  		tempEmptyPackage = new Jar();
	  		break;
	  	case PARCEL:
	  		tempEmptyPackage = new Parcel();
	  		break;
	  	default:
	  		break;
	  }
		return tempEmptyPackage;
	}

	private void setBrandOfCoffee(Coffee tempCoffee, String[] splitStringFromFile) {
	  switch (splitStringFromFile[8]) {
	  	case "ILLY":
	  		tempCoffee.setBrand(Brand.ILLY);
	  		break;
	  	case "LAVAZZA":
	  		tempCoffee.setBrand(Brand.LAVAZZA);
	  		break;
	  	case "COMPAGNIA_DELL_ARABICA":
	  		tempCoffee.setBrand(Brand.COMPAGNIA_DELL_ARABICA);;
	  		break;
	  	default:
	  		break;
	  }
	}

	private void setSortOfCoffee(Coffee tempCoffee, String[] splitStringFromFile) {
	  switch (splitStringFromFile[5].toUpperCase()) {
	  	case "ARABICA":
	  		tempCoffee.setSort(Sort.ARABICA);
	  		break;
	  	case "ROBUSTA":
	  		tempCoffee.setSort(Sort.ROBUSTA);
	  		break;
	  	case "BLENDED":
	  		tempCoffee.setSort(Sort.BLENDED);
	  		break;
	  	default:
	  		break;
	  }
	}

	private void setCostOfCoffee(Coffee tempCoffee, String[] splitStringFromFile) {
	  switch (splitStringFromFile[0]) {
	  	case "Grain":
	  		tempCoffee.setCost(GrainCoffee.costPerGramm * tempCoffee.getWeight());
	  		break;
	  	case "Grind":
	  		tempCoffee.setCost(GroundCoffee.costPerGramm * tempCoffee.getWeight());
	  		break;
	  	case "Soluble":
	  		tempCoffee.setCost(SolubleCoffee.costPerGramm * tempCoffee.getWeight());
	  		break;
	  	default:
	  		break;
	  }
	}

	private Coffee setKindOfCoffee(String[] splitStringFromFile, Coffee tempCoffee) {
	  switch (splitStringFromFile[0]) {
	  	case "Grain":
	  		tempCoffee = new GrainCoffee();
	  		break;
	  	case "Grind":
	  		tempCoffee = new GroundCoffee();
	  		break;
	  	case "Soluble":
	  		tempCoffee = new SolubleCoffee();
	  	default:
	  		break;
	  }
		return tempCoffee;
	}

}
