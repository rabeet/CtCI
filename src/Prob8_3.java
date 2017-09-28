import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Prob8_3 {

	/*
	 * 8.3: Generate all subsets of a set There are 2^n subsets of a set.
	 * Basically total subsequences +1 (indicating an empty set).
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		List<Integer> ls = list.subList(0, 2);
		System.out.println(ls.toString());
		List<List<Integer>> alist = getSubsets(list);
		for (List l : alist) {
			System.out.println(l.toString());
		}
		
		SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		map.put(1, 2);
		map.put(2, 2);
		map.put(3, 2);
		map.put(0, 2);
		
		Set<Integer> s = map.keySet();
		for (Integer i : s) {
			System.out.println(i);
		}
	}

	public static List<List<Integer>> getSubsets(List<Integer> list) {
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				List<Integer> slist = getSubsets(list, i, j);
				ans.add(slist);
			}
		}
		ans.add(new ArrayList<>());
		return ans;
	}

	// 1 2
	// 1, 2, 1 2
	// 1, 2, 3: 1, 2, 3, 12, 23, 13,
	// 1, 2, 3, 1 2, 2 3, 1 3, 1 2 3, ,
	public static ArrayList<Integer> getSubsets(List<Integer> mainList, int s, int e) {
		if (s > e)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (s <= e) {
			list.add(mainList.get(s));
			s++;
		}
		return list;
	}
	
	public static ArrayList<Integer> getSubsets(List<Integer> mainList, int s, int e, int b) {
		if (s > e)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (s <= e) {
			list.add(mainList.get(s));
			s++;
		}
		return list;
	}

}
