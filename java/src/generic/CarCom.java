package generic;

import java.util.Comparator;

//import L23_April21.FxnGeneric.Car;

public class CarCom {
	int price, speed;
	String name;

	public CarCom(String name, int price, int speed) {
		this.name = name;
		this.price = price;
		this.speed = speed;

	}

	@Override
	public String toString() {
		return this.name;
	}

	public int compareTo(CarCom other) {
		return this.speed - other.speed;
	}

	public static <T> void display(T arr[]) {
		for (T val : arr)
			System.out.println(val + " ");
	}

	public static void main(String[] args) {
//		CarCom c1=new CarCom("HOnda", 45, 900);
//		CarCom c2=new CarCom("Maruti", 65, 800);
//		System.out.println(c1.compareTo(c2));
//		String arr[] = { "Modkhaid", "Anas", "zain", "asif" };
//		Integer arr[] = { 1, 5, 9, 7, 8, 3, 4, 6, 12, 20 };
		car cars[] = new car[5];
		cars[0] = new car("a", 100, 267);
		cars[1] = new car("a", 500, 2000);
		cars[2] = new car("U", 700, 100);
		cars[3] = new car("Q", 200, 200);
		cars[4] = new car("J", 900, 340);
		display(cars);
		System.out.println();
		bubbleSort(cars, new nameCompare());
		display(cars);
		System.out.println();
		bubbleSort(cars, new priceCompare());
		display(cars);

	}

	public static <T extends Comparable<T>> void bubbleSort(T arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

	public static <T> void bubbleSort(T arr[], Comparator<T> comp) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (comp.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}

class car implements Comparable<car> {

	String name;
	int speed;
	int price;

	public car(String name, int speed, int price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + " S:" + this.speed + " P:" + this.price;
	}

	@Override
	public int compareTo(car other) {

		// return this.price-other.price;//for number compare
		return this.name.compareTo(other.name);// for string comparison
	}

}

class nameCompare implements Comparator<car> {

	@Override
	public int compare(car c0, car c1) {
		return c0.name.compareTo(c1.name);
	}

}

class priceCompare implements Comparator<car> {

	@Override
	public int compare(car arg0, car arg1) {
		return arg0.price - arg1.price;
	}

}