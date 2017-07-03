package by.pvt.hermanovich.coffeetrailer.entities.interfaces;

public interface Messages {
	
	public final String DELIMETER = "=============================================";
	public final String MAIN_MENU_TEXT = "You are in CoffeeTrailer application menu.\n"
																			+ "Now you have to choose one of options:\n"
																			+	"1. Create coffee objects and packages from dialiog menu.\n"
																			+ "2. Read and create coffee and packages from files.\n"
																			+ "0. Exit.";
	
	public final String INPUT_FOLDER = "src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\input\\";
	public final String OUTPUT_FOLDER = "src\\by\\pvt\\hermanovich\\coffeetrailer\\files\\output\\";
	
	public final String REQUEST_FOR = "Please, choose an empty package for ";
	public final String NUM_COFFEE_OBJ = "How many kinds of coffee (objects) do you want to choose? ";
	public final String ERR_COFFEE_OBJ = "\nYou've entered incorrect value. Please, try to enter a correct value again.";
	public final String CHOOSE_KIND_OF_COFFEE = "\nNow you have to choose a new kind of coffee from list:\n";
	public final String CHOOSE_KIND_OF_PACKAGE = "\nNow you have to choose an empty coffee package for the every kind of coffee you've chosen.";
	public final String KIND_OF_COFFEE = "1 - Grain Coffee" + "\n"
																						+ "2 - Grind Coffee"+ "\n"
																						+ "3 - Soluble Coffee";
	public final String GRAIN = "Grain Coffee";
	public final String GRIND = "Grind Coffee";
	public final String SOLUBLE = "Soluble Coffee";
	public final String CHOOSE_SORT_OF_COFFEE = "\nNow you have to choose a sort of coffee from list:\n";
	public final String SORT_OF_COFFEE = "1 - Arabica" + "\n"
																						+ "2 - Robusta" + "\n"
																						+ "3 - Blended";
	public final String ERR_KIND_OF_COFFEE = "\nWrong kind of coffee.";
	public final String WRONG_DATA = "\nYou've entered incorrect value. Please, try to enter a correct value again.";
	public final String CHOOSE_BRAND_OF_COFFEE = "\nNow you have to choose a brand of coffee from list:\n";
	public final String BRAND_OF_COFFEE = "1 - ILLY" + "\n"
																							+ "2 - LAVAZZA" + "\n"
																							+ "3 - COMPAGNIA DELL ARABICA";
	public final String ENTER_WEIGHT_OF_COFFEE = "\nEnter a weight (quantity) of coffee, g: ";
	public final String CHOOSE_THE_CORRECT_KIND = "Sorry, you've made the wrong choice. Select the correct kind.";
	public final String CHOOSE_THE_CORRECT_SORT = "Sorry, you've made the wrong choice. Select the correct sort.";
	public final String CHOOSE_THE_CORRECT_BRAND = "Sorry, you've made the wrong choice. Select the correct brand.";
	public final String KIND_OF_PACKAGE = "1 - Box" + "\n"
																			+ "2 - Jar" + "\n"
																			+ "3 - Parcel";
	public final String BOX = "Box";
	public final String JAR = "Jar";
	public final String PARCEL = "Parcel";
	public final String FINAL_CHOICE = "\nYou've chosen: ";
	public final String PRINT_LIST_COFFEE_REQUEST = "\nDo you want to print the list of chosen coffee objects ( 1 - yes or 2 - no )?";
	public final String LIST_COFFEE = "\nList of coffee objects you've chosen has the following view:";
	public final String PRINT_LIST_EMPTY_PACKAGES_REQUEST = "\nDo you want to print the list of chosen coffee packages ( 1 - yes or 2 - no )?";
	public final String LIST_EMPTY_PACKAGES = "\nList of coffee packages you've chosen has the following view:";
	public final String REQUEST_FILL_COFFEEPACKAGES = "\nNow your coffee is packing up. Wait some moment, please.";	
	public final String REPORT_FILL_COFFEEPACKAGES = "\nYour coffee has packed up and is loading into a trailer for the shipping.\nWould you like to get a report about filled coffee packages ( 1 - yes or 2 - no )?";
	public final String LIST_FILLED_COFFEEPACKAGES = "\nList of the filled coffee packages you've chosen has the following view:";
	public final String REQUEST_WRITE_TO_FILE = "\nWould you like to write the information about filled coffee packages in file ( 1 - yes or 2 - no )?";
	public final String REQUEST_SERIALIZATION = "\nDo you want to write the filled coffee packages objects in file ( 1 - yes or 2 - no )?";
	public final String REQUEST_SORT_OR_WRITE_UNSORTED = "\nWould you like to sort the list of filled coffee packages (1 - Not Sort or 2 - Sort )?";
	public final String REPORT_WRITE = "The information was written in the file. For information see ";
	public final String ERR_CREATE_LOG = "Error. The log file couldn't be created.";
	public final String REQUEST_READ_FROM_FILE = "\nWould you like to read the information about coffee and coffee packages from file ( 1 - yes or 2 - no )?";
	public final String ERR_CREATE_FILE_OBJECT = "There is no possible to create the file: ";
	public final String ERR_SERIALIZATION_OBJECT = "The class doesn't support serialization operation.";
	public final String REPORT_READ_COFFEE = "The list of coffee objects read from a file has the following view:";
	public final String REPORT_READ_EMPTY_PACKAGES = "\nThe list of empty coffee packages read from a file has the following view:";
	public final String REPORT_READ_FILLED_COFFEE_PACKAGES = "\nThe list of filled coffee packages has the following view:";
	public final String ERR_CLEAN_FILE = "\nThere is an error with cleaning file.";
	public final String SORT_FILLED_COFFEE_PACKAGES_COST = "The list of filled coffee packages sorted by total price has the following view:";
	public final String SORT_FILLED_COFFEE_PACKAGES_WEIGHT = "\nThe list of filled coffee packages sorted by weight has the following view:";
	public final String REPORT_END_OF_APPLICATION = "\nThe work of application ended.";
}
