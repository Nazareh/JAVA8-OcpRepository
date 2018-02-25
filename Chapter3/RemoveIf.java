import java.util.List;

import java.util.ArrayList;

class RemoveIf {
	
	public static void main (String[] args){
		List<String> list = new ArrayList<>();
		list.add("Magician");
		list.add("Assistant");
		System.out.println(list); // [Magician, Assistant]
		list.removeIf(s -> s.startsWith("A"));
		System.out.println(list); // [Magician]
	
	}
	
}

