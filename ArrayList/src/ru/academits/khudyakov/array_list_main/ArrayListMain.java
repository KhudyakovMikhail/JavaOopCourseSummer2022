package ru.academits.khudyakov.array_list_main;

import ru.academits.khudyakov.array_list.ArrayList;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(0);

        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(2, 5);

        System.out.println("Список 1: " + list1);

        ArrayList<Integer> list2 = new ArrayList<>(list1);

        list2.addAll(2, list1);

        System.out.println("Список 2: " + list2);

        ArrayList<Integer> list3 = new ArrayList<>();

        list3.add(2);
        list3.add(3);
        list3.add(4);

        System.out.println("Список 3: " + list3);

        System.out.println(list2.retainAll(list3));
        System.out.println("Список 2 содержащий элементы списка 3: " + list2);
    }
}
