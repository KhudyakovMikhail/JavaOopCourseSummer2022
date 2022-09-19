package ru.academits.khudyakov.lambdas_main;

import ru.academits.khudyakov.lambdas.Person;

import java.util.*;
import java.util.stream.Collectors;

public class LambdasMain {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Максим", 17),
                new Person("Елена", 33),
                new Person("Иван", 42),
                new Person("Ольга", 26),
                new Person("Дмитрий", 33),
                new Person("Иван", 80),
                new Person("Кристина", 39),
                new Person("Даниил", 9),
                new Person("Владислав", 65),
                new Person("Кристина", 16)
        );

        // А получить список уникальных имен
        List<String> uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .toList();

        System.out.println("Список уникальных имен: " + uniqueNames);

        // Б вывести список уникальных имен в формате:
        // Имена: Иван, Сергей, Петр.
        String uniqueNamesString = uniqueNames.stream()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(uniqueNamesString);

        // B получить список людей младше 18, посчитать для них средний возраст
        List<Person> youngerThan18Peoples = persons.stream()
                .filter(person -> person.getAge() < 18)
                .toList();

        System.out.println(youngerThan18Peoples);

        OptionalDouble youngerThan18PeoplesAverageAge = youngerThan18Peoples.stream()
                .mapToInt(Person::getAge)
                .average();

        System.out.println(youngerThan18PeoplesAverageAge);

        // Г при помощи группировки получить Map, в котором ключи - имена, а значения - средний возраст
        Map<String, Double> averageAgeByNames = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        System.out.println(averageAgeByNames);

        // Д получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        persons.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .sorted((person1, person2) -> person2.getAge() - person1.getAge())
                .forEach(System.out::println);
    }
}
