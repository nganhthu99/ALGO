package assignment_5.code;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		Combinations com = new Combinations();
		com.combinations(a, 3);
		System.out.println("The subsets of " + a + " of size 3 are: \n" + "  "+com.retVal);
	}
	List<List<Integer>> retVal = new ArrayList<>();
	List<Integer> input = null;
	public void combinations(List<Integer> list, int size) {
		//implement
	}
}
