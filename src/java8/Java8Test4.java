package java8;

public class Java8Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vechile = new Car();
		vechile.print();
	}

}


interface Vehicle {
	default void print() {
		System.out.println("I am a vehicle");
	}
	
	static void blowHorn() {
		System.out.println("Blowing horn!");
	}
}

interface FourWheeler {
	default void print() {
		System.out.println("I am a four wheeler!");
	}
}

class Car implements Vehicle, FourWheeler {
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("I am a car");
	}
}