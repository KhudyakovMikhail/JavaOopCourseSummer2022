package ru.academits.khudyakov.array_list_main;

import ru.academits.khudyakov.array_list.MyArrayList;

public class MyArrayListMain {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>(0);

        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(2, 5);

        System.out.println("������ 1: " + list1);

        MyArrayList<Integer> list2 = new MyArrayList<>(list1);

        list2.addAll(2, list1);

        System.out.println("������ 2: " + list2);

        MyArrayList<Integer> list3 = new MyArrayList<>();

        list3.add(2);
        list3.add(3);
        list3.add(4);

        System.out.println("������ 3: " + list3);

        list2.retainAll(list3);
        System.out.println("������ 2 ���������� �������� ������ 3: " + list2);
    }
}
