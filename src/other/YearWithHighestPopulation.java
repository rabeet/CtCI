package other;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class YearWithHighestPopulation {
	
	
	List<Person> people = new ArrayList<Person>();
	
	public int yearWithHighest(List<Person> list) {
		
		// sort by the year born
		Collections.sort(list);
		
		// create the interval list
		List<Interval> intervals = new ArrayList<Interval>();
		
		// populate the interval list
		Interval val = new Interval(list.get(0).yb, list.get(0).yd);
		for (Person person: list) {
			if (person.yb < val.e) {
				val.e = person.yd;
			} else {
				intervals.add(val);
				val = new Interval(-1,-1);
			}
		}
		
		return 0;
	}
	
}

class Person implements Comparable<Person>{
	String name;
	int yb, yd;
	
	public Person(String name, int yb, int yd) {
		this.name = name;
		this.yb = yb;
		this.yd = yd;
	}
	public Person(int yb, int yd) {
		this.yb = yb;
		this.yd = yd;
	}
	@Override
	public int compareTo(Person o) {
		return this.yb - o.yb;
	}
}

class Interval implements Comparable<Interval>{
	
	int s;
	int e;
	
	public Interval() {
		
	}
	
	public Interval(int start, int end) {
		this.s = start;
		this.e = end;
	}
	
	public int compareTo(Interval i1) {
		return this.s - i1.s;
	}
}