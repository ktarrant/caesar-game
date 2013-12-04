package com.ktarrant.caesar;

public class Logger {
	
	Object source = null;
	
	public Logger (Object source) {
		this.source = source;
	}
	
	public void out(Object msg) {
		Logger.out(this.source, msg);
	}
	
	public void out(Object msg, boolean addEndLine) {
		Logger.out(this.source, msg, addEndLine);
	}
	
	public static void out(Object source, Object msg) {
		out(source, msg, true);
	}
	
	public static void out(Object source, Object msg, boolean addEndline) {
		System.out.print(source);
		System.out.print(" : ");
		System.out.print(msg);
		if (addEndline) System.out.print("\n");
	}
}
