package by.pvt.hermanovich.tools;

import java.io.*;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class MainMenu implements Messages {
	
	public void start() {
		BufferedReader reader;
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
		while (true) {
			try {
				int enterNumb = Integer.parseInt(reader.readLine());
				switch (enterNumb) {
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
						Logger.log(REPORT_END_OF_APPLICATION);
						System.exit(0);
					default:
						System.out.println(ERR_COFFEE_OBJ);
						Logger.log(Messages.ERR_COFFEE_OBJ);
						continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println(ERR_COFFEE_OBJ);
				continue;
			}
		}
  	}
}
