
public class SetTester {


	public static void main(String[] args) {


	    //create new SortedSet
		SortedSet set = new SortedSet();

		// Add some items
		set.add("cat");
		set.add("horse");
		set.add("dog");
		set.add("rat");
		set.add("monkey");
		set.add("ape");
		set.add("ape");
		
		System.out.println("=============Contents of Bag==============");
		System.out.println(set);
		System.out.println("Current size of bag = 6? : "+set.getCurrentSize());
		System.out.println("Is Empty = false? : "+set.isEmpty());
		
		System.out.println("\n===============Test of add================");
		System.out.println("set.add(\"bat\") = true? : "+set.add("bat"));
		System.out.println(set);
		
		System.out.println("\n=========Test of Remove(Generic)===========");
		System.out.println("set.remove() = ape? : "+set.remove());
		System.out.println(set);
		
		System.out.println("\n=========Test of Remove(Specific)==========");
		System.out.println("Remove dog = true? : "+set.remove("dog"));
		System.out.println(set);
		System.out.println("Remove apple = false? : "+set.remove("apple"));
		System.out.println(set);
		
		System.out.println("\n=============Test of Contains==============");
		System.out.println("Contains apple = false? : "+set.contains("apple"));
		System.out.println("Contains monkey = true? : "+set.contains("monkey"));
		
		System.out.println("\n=============Test of toArray===============");
		for(String s : set.toArray())
			System.out.print(s+" ");
		
		System.out.println("\n\n==============Test of Clear================");
		set.clear();
		System.out.println("Set now contains : "+set);
		System.out.println("Current size = 0? : "+set.getCurrentSize());
		
		System.out.println("\n=============Test of isEmpty===============");
		System.out.println("Is Empty = true? : "+set.isEmpty());
		
	}
}