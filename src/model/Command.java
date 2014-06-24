package model;

public class Command extends Object {
	String str;

	public Command(String st) {
		str = st;
	}

	@Override
	public String toString() {
		return str;
	}
}
