package ru.academits.khudyakov.lambdas_main;

import ru.academits.khudyakov.lambdas.Person;

import java.util.*;
import java.util.stream.Collectors;

public class LambdasMain {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("������", 17),
                new Person("�����", 33),
                new Person("����", 42),
                new Person("�����", 26),
                new Person("�������", 33),
                new Person("����", 80),
                new Person("��������", 39),
                new Person("������", 9),
                new Person("���������", 65),
                new Person("��������", 16)
        );

        // � �������� ������ ���������� ����
        List<String> uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .toList();

        System.out.println("������ ���������� ����: " + uniqueNames);

        // � ������� ������ ���������� ���� � �������:
        // �����: ����, ������, ����.
        String uniqueNamesString = uniqueNames.stream()
                .collect(Collectors.joining(", ", "�����: ", "."));

        System.out.println(uniqueNamesString);

        // B �������� ������ ����� ������ 18, ��������� ��� ��� ������� �������
        List<Person> youngerThan18Peoples = persons.stream()
                .filter(person -> person.getAge() < 18)
                .toList();

        System.out.println(youngerThan18Peoples);

        OptionalDouble youngerThan18PeoplesAverageAge = youngerThan18Peoples.stream()
                .mapToInt(Person::getAge)
                .average();

        System.out.println(youngerThan18PeoplesAverageAge);

        // � ��� ������ ����������� �������� Map, � ������� ����� - �����, � �������� - ������� �������
        Map<String, Double> averageAgeByNames = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        System.out.println(averageAgeByNames);

        // � �������� �����, ������� ������� �� 20 �� 45, ������� � ������� �� ����� � ������� �������� ��������
        persons.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .sorted((person1, person2) -> person2.getAge() - person1.getAge())
                .forEach(System.out::println);
    }
}
