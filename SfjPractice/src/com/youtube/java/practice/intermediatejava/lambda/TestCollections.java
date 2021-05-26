package com.youtube.java.practice.intermediatejava.lambda;

import java.util.*;

public class TestCollections {

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();

        words.add("Here");
        words.add("we");
        words.add("go");
        words.add("again");

        // 1.
        for (int i = 0; i < words.size(); i++)
            System.out.println(words.get(i));

        // 2.
        for (String s : words)
            System.out.println(s);

        // 3.
        words.forEach(s -> System.out.println(s));


        // 4.
        System.out.println(words);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(31, "Balint"));
        people.add(new Person(25, "Daniel"));
        people.add(new Person(43, "Levente"));
        people.add(new Person(18, "Tamas"));

        // Sorting with just lambda expression
        people.sort((p1, p2) -> p2.getAge() - p1.getAge());
        people.forEach(s -> System.out.println(s.getName() + " " +s.getAge()));

        // Collections.sort(people);

        people.sort(Person.NameComparator);
        for (int j  = 0; j < people.size(); j++)
            System.out.println(people.get(j));

        people.sort(Person.AgeComparator);
        for (int j  = 0; j < people.size(); j++)
            System.out.println(people.get(j));

        // LinkedList and Iterator
        LinkedList<String> listNames = new LinkedList<>();
        listNames.add("Thomas");
        listNames.add("Jessica");
        listNames.add("Bob");
        Iterator<String> it = listNames.iterator();

        while (it.hasNext()) {
            String actual = it.next();
            if (actual.equals("Jessica")) {
                it.remove();
            } else {
                System.out.println(actual);
            }
        }

        // Queue
        Queue<String> qu = new PriorityQueue<>((a, b) -> a.length() - b.length());
        qu.offer("First Bunnyyyyyyyyyyyyyyyyyyyyyyyyy");
        System.out.println(qu);
        qu.offer("Second Pall");
        System.out.println(qu);
        qu.offer("Third Friend");
        System.out.println(qu);

        System.out.println(qu.peek());

        qu.poll();
        System.out.println(qu);
        qu.offer("VIP Johnny");
        System.out.println(qu);
        qu.poll();
        System.out.println(qu);

        // Stack
        Stack<String> st = new Stack<>();
        st.push("Bottom");
        st.push("Middle");
        st.push("Top");

        System.out.println(st);
        st.pop();
        printStack(st);

        // Set
        String[] array = {"Dummy", "Array", "Or", "List", "List", "Elements"};
        List<String> list = Arrays.asList(array);
        System.out.println("List: " + list);

        Set<String> set = new HashSet<>(list);
        System.out.println("Set: " + set);
        Set<String> setOrdered = new LinkedHashSet<>(list);
        System.out.println("Set with order: " + setOrdered);

        // Map
        Map<String, Integer> testMap = new LinkedHashMap<>();
        testMap.put("Brown", 10);
        testMap.put("Yellow", 15);
        testMap.put("Red", 20);
        System.out.println(testMap);
        System.out.println(testMap.remove("Yellow"));

        Iterator iter = testMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

    }

    public static void printStack(Stack<String> st) {
        System.out.println(st.isEmpty() ? "The stack is empty" : st.toString());
    }
}
