package hashMap;

public class HashMapClient {
	public static void main(String[] args) {
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("modkhalid", 60);
		map.put("anas", 20);
		map.put("zain", 25);
		map.put("aman",50);
		System.out.println(map.Allkeys());
		System.out.println(map.removeKey("zain"));
		System.out.println(map.Allkeys());
		
		map.put("khan", 20);
		System.out.println(map.Allkeys());
		map.display();
		
		
	}
}
