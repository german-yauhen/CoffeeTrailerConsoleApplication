package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class WriterToFile implements Messages {

	private static File fileFilledCoffeePackages = new File(OUTPUT_FOLDER + "FilledCoffeePackages.txt");
	private int numObj = DataBase.listOfFilledCoffeePackages.size();
	private int answer;

	public void start() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(REQUEST_WRITE_TO_FILE);
			requestWriteToFile(reader);
		}
		catch (IOException e) {
			Logger.log(e);
		}
	}

	/**
	 * 
	 * @param reader
	 * @throws IOException
	 */
	private void requestWriteToFile(BufferedReader reader) throws IOException {
		try {
			answer = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestWriteToFile(reader);
		}
		if (answer < 1 || answer > 2) {
			System.out.println(ERR_COFFEE_OBJ);
			requestWriteToFile(reader);
		}
		switch (answer) {
			case 1:
				writeToFile(fileFilledCoffeePackages);
				break;
			case 2:
				break;
			default:
				break;
		}
	}

	/**
	 * This method describes /....../
	 * @param file An incoming file
	 * @throws IOException Throwning exceptions
	 */
	private void writeToFile(File file) throws IOException {
		CleanerOfFile.cleanFile(file);
		FileWriter fileWriter = null;
		BufferedWriter buffWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(file);
			buffWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(buffWriter);
			for (int i = 0; i < numObj; i++) {
				printWriter.print(DataBase.listOfFilledCoffeePackages.get(i) + "\n");
			}
			System.out.println(REPORT_WRITE + file.getPath());
		}
		catch (IOException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			writeToFile(fileFilledCoffeePackages);
		}
		finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
