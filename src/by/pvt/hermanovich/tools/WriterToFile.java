package by.pvt.hermanovich.tools;

import java.io.*;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class WriterToFile implements Messages {

	private static File fileFilledCoffeePackages = new File(OUTPUT_FOLDER + "FilledCoffeePackages.txt");

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

	private void requestWriteToFile(BufferedReader reader) throws IOException {
		while (true) {
			try {
				int answer = Integer.parseInt(reader.readLine());
				switch (answer) {
					case 1:
						writeToFile(fileFilledCoffeePackages);
						break;
					case 2:
						break;
					default:
						continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println(ERR_COFFEE_OBJ);
				Logger.log(e);
				continue;
			}
		}
	}

	private void writeToFile(File file) {
		int numObj = DataBase.listOfFilledCoffeePackages.size();
		PrintWriter printWriter = null;
		try {
			CleanerOfFile.cleanFile(file);
			printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < numObj; i++) {
				printWriter.print(DataBase.listOfFilledCoffeePackages.get(i) + "\n");
			}
			System.out.println(REPORT_WRITE + file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
