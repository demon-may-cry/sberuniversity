package ru.sberuniversity.lambdastreamapi;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personCollection = new ArrayList<>();

        personCollection.add(new Person("John", 25));
        personCollection.add(new Person("Alice", 30));
        personCollection.add(new Person("Bob", 28));
        personCollection.add(new Person("Charlie", 32));
        personCollection.add(new Person("David", 27));
        personCollection.add(new Person("Eve", 31));
        personCollection.add(new Person("Frank", 29));
        personCollection.add(new Person("Grace", 33));
        personCollection.add(new Person("Hannah", 26));
        personCollection.add(new Person("Isabella", 34));

        Streams.of(personCollection)
                .filter(person -> person.getAge() >= 30)
                .transform(p -> new Person(p.getName().toUpperCase(), p.getAge() + 10))
                .toMap(Person::getName, Person::getAge).forEach((name, age) -> System.out.println(name + ": " + age));
    }
}