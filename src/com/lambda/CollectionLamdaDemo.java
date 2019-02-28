package com.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionLamdaDemo {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person[]{new Person("Peter", "Patro"),new Person("Jack", "Patro"),
				new Person("Linda", "Patro"), new Person("Peter", "Pradhan"),new Person("Jack", "Pradhan")});
		printConditionally(people, p1-> true);
		Collections.sort(people, (p1,p2) -> p1.getLname().compareTo(p1.getLname()));
		System.out.println("--------------------------");
		printConditionally(people, p1-> p1.getFname().startsWith("S"));
		System.out.println("--------------------------");
		printConditionally(people, p1-> p1.getLname().startsWith("Pat"));
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		performConditionally(people, p1-> true, p1-> System.out.println(p1));
		Collections.sort(people, (p1,p2) -> p1.getLname().compareTo(p1.getLname()));
		System.out.println("--------------------------");
		performConditionally(people, p1-> p1.getFname().startsWith("P"), p1->System.out.println(p1.getFname()));
		System.out.println("--------------------------");
		performConditionally(people, p1-> p1.getLname().startsWith("Pat"), p1-> System.out.println(p1.getLname()));

	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person person :people) {
			if(condition.test(person)) {
				System.out.println(person);
			}
		}
	}

	private static void performConditionally(List<Person> people, Predicate<Person> condition, Consumer<Person> behavior) {
		for(Person person :people) {
			if(condition.test(person)) {
				behavior.accept(person);
			}
		}
	}

	interface Condition{
		boolean test(Person p);
	}
}
