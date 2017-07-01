package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class ManagerObjects implements Messages {

	private static File fileFilledCoffeePackages = new File(OUTPUT_FOLDER + "FilledCoffeePackages.txt");
	private int answer;

	public void start() {
		BufferedReader reader = null;
		try {
			System.out.println(REQUEST_SORT_OR_WRITE_UNSORTED);
			reader = new BufferedReader(new InputStreamReader(System.in));
			requestSortOrWrite(reader);
			Serialization ser = new Serialization();
			ser.start();
		}
		catch (Exception e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
		}
	}

	private void requestSortOrWrite(BufferedReader reader) throws IOException {
		CleanerOfFile.cleanFile(fileFilledCoffeePackages);
		WriterToFile writerToFile = new WriterToFile();
		try {
			answer = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestSortOrWrite(reader);
		}
		if (answer < 1 || answer > 2) {
			System.out.println(ERR_COFFEE_OBJ);
			requestSortOrWrite(reader);
		}
		try {
			switch (answer) {
				case 1:
					writerToFile.start();
					break;
				case 2:
					SortFilledCoffeePackage sortFilledCoffeePackage = new SortFilledCoffeePackage();
					sortFilledCoffeePackage.start();
					writerToFile.start();
					break;
				default:
					break;
			}
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestSortOrWrite(reader);
		}
	}
}
