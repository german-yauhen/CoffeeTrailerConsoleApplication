	/**
	 * OverLoadException.
	 * 
	 * Version 1.0
	 * 
	 * 14.01.2017
	 * 
	 * Copyright (c) 2017 Hermanovich Y. All rights reserved.
	 */
package by.pvt.hermanovich.coffeetrailer.exceptions;
	/**
	 * @author Hermanovich Y.
	 */
@SuppressWarnings("serial")
public class OverLoadException extends Exception {

		public OverLoadException() {
	        super();
	        // TODO Auto-generated constructor stub
        }

		public OverLoadException(String arg0, Throwable arg1, boolean arg2,
                boolean arg3) {
	        super(arg0, arg1, arg2, arg3);
	        // TODO Auto-generated constructor stub
        }

		public OverLoadException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	        // TODO Auto-generated constructor stub
        }

		public OverLoadException(String arg0) {
	        super(arg0);
	        // TODO Auto-generated constructor stub
        }

		public OverLoadException(Throwable arg0) {
	        super(arg0);
	        // TODO Auto-generated constructor stub
        }
}
