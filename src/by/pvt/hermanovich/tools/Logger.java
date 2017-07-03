package by.pvt.hermanovich.tools;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public class Logger implements Messages {

	private static BufferedWriter writer = null;
	static {
		File logFile = new File("src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\log\\Log.txt");
		try {
			logFile.createNewFile();
		}
		catch (IOException e) {
			System.out.println(ERR_CREATE_LOG);
		}
	}

	private Logger() {
	}

	public static void log(final Throwable exc) {
		final StringWriter err = new StringWriter();
		exc.printStackTrace(new PrintWriter(err));
		try {
			writer = new BufferedWriter(
								new OutputStreamWriter(
									new FileOutputStream("src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\log\\Log.txt", true), "utf-8"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			writer.write(sdf.format(Calendar.getInstance().getTime()));
			writer.write(err.toString() + "\n");
		}
		catch (IOException e) {
			Logger.log(e);
		}
		finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				System.out.println("There is a closing thread error: " + e);
				Logger.log(e);
			}
		}
	}
	
	public static void log(final String logMessage) {
		try {
			writer = new BufferedWriter(
	  		 				new OutputStreamWriter(
	  		 						new FileOutputStream("src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\log\\Log.txt", true), "utf-8"));
	  		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	  		writer.write(sdf.format(Calendar.getInstance().getTime()));
	  		writer.write(logMessage);
    	} catch (IOException e) {
	   		 Logger.log(e);
   		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				System.out.println("There is a closing thread error: " + e);
				Logger.log(e);
			}
		}
	}
}
