package by.pvt.hermanovich.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class MainMenu implements Messages {

	private int answer;
	
	public void start() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(DELIMETER);
			System.out.println(MAIN_MENU_TEXT);
			System.out.println(DELIMETER);
			ManagerObjects manager = new ManagerObjects();
			requestMainMenu(reader, manager);
			System.out.println(REPORT_END_OF_APPLICATION);
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
		}
	}

	private void requestMainMenu(BufferedReader reader, ManagerObjects manager) throws IOException {
		try {
			answer = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			Logger.log(e);
			requestMainMenu(reader, manager);
		}
		if (answer < 0 || answer > 2) {
			System.out.println(ERR_COFFEE_OBJ);
			requestMainMenu(reader, manager);
		}
		try {
			switch (answer) {
				case 1:
					CreatorFromDialog creatorFromDialog = new CreatorFromDialog();
					creatorFromDialog.start();
					manager.start();
					break;
				case 2:
					ReaderFromFile readerFromFile = new ReaderFromFile();
					readerFromFile.start();
					manager.start();
					break;
				case 0:
					System.out.println(REPORT_END_OF_APPLICATION);
					System.exit(0);
				default:
					break;
			}
		}
		catch (NumberFormatException e) {
			System.out.println(ERR_COFFEE_OBJ);
			requestMainMenu(reader, manager);
		}
	  
  }

}
