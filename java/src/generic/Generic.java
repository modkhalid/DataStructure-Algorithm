package generic;

public class Generic {
	public static void main(String[] args) throws Exception {
//		GenericPair<Integer,String> gp=new GenericPair<>();
//		gp.data=78;
//		gp.size="78";
//		
//		GenericPair<GenericPair<Integer,Character>,String> g=new GenericPair<>();
//		
//		System.out.println(g.size);
//		
//		g.data=new GenericPair<>();
//		System.out.println(g.data.data);
		
//		LinkedList<String> ll=new LinkedList<>();
//		
//		ll.addFirst("modkhalid");
//		ll.addFirst("anas");
//		ll.display();
		
		
		LinkedList<Car> ll=new LinkedList<>();
		
		ll.addFirst(new Car("red","city100",78));
		ll.addFirst(new Car("green","maruti800",92));
		System.out.println(ll.getNodeAt(0).data.color);
		ll.display();
		
		
	}
	
}


class GenericPair<K,V>{
	K data;
	V size;
	
}


class Car{
	int price;
	String color,name;
	
	public Car(String color,String name,int price) {
		this.color=color;
		this.name=name;
		this.price=price;
	}
	
	public String toString() {
		return "["+this.name+" : "+this.color+" : "+this.price+"]";
	}
}
