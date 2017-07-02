package by.pvt.hermanovich.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import by.pvt.hermanovich.coffeetrailer.entities.interfaces.Messages;

public final class CleanerOfFile implements Messages {
	public static void cleanFile(File file) throws IOException {
		try (FileWriter cleanerOfFile = new FileWriter(file)) {
	    cleanerOfFile.write("");
    }
    catch (IOException e) {
    	System.out.println(ERR_CLEAN_FILE);
	    Logger.log(e);
    }
	}
}
