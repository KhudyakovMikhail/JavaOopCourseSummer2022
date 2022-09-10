package ru.academits.khudyakov.lambdas_main;

import ru.academits.khudyakov.lambdas.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class LambdasMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Максим", 17));
        persons.add(new Person("Елена", 33));
        persons.add(new Person("Иван", 42));
        persons.add(new Person("Ольга", 26));
        persons.add(new Person("Дмитрий", 33));
        persons.add(new Person("Иван", 80));
        persons.add(new Person("Кристина", 39));
        persons.add(new Person("Даниил", 9));
        persons.add(new Person("Владислав", 65));
        persons.add(new Person("Кристина", 16));

        // А
        List<String> uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .toList();

        System.out.println("Список уникальных имен: " + uniqueNames);

        // Б
        String uniqueNamesString = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(uniqueNamesString);

        // В
        List<Person> youngerThan18Peoples = persons.stream()
                .filter(person -> person.getAge() < 18).toList();

        System.out.println(youngerThan18Peoples);

        OptionalDouble youngerThan18PeoplesAverageAge = youngerThan18Peoples.stream()
                .mapToInt(Person::getAge)
                .average();

        System.out.println(youngerThan18PeoplesAverageAge);

        // Г
        Map<String, Double> averageAgeByName = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        System.out.println(averageAgeByName);

        // Д
        persons.stream()
                .filter(person -> person.getAge() > 20)
                .filter(person -> person.getAge() < 45)
                .sorted((person1, person2) -> person2.getAge() - person1.getAge())
                .forEach(System.out::println);
    }
}
