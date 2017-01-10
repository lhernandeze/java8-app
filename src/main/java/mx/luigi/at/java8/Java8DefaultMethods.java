package mx.luigi.at.java8;

public class Java8DefaultMethods {
	public static void main(String args[]) {
		Vehicle v = new Car();
		v.print();
	}
}

interface Vehicle {
	default void print() {
		System.out.println("I'm a vehicle!");
	}
	
	static void blowHorn() {
		System.out.println("Blowing Horn!!");
	}
}

interface FourWheeler {
	default void print() {
		System.out.println("I'm a four Wheeler!");
	}
}

class Car implements Vehicle, FourWheeler {
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("I'm a Car!");
	}
}
