package ru.academits.khudyakov.list_main;

import ru.academits.khudyakov.list.SinglyLinkedList;

import java.util.SortedMap;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.removeHead();

        System.out.println(list);

        list.add("35");
        System.out.println("������ ������� ������: " + list.getHead() + "; ����� ��������� � ������ = " + list.getCount());

        String changedItem = "3";
        System.out.println("������ �������� �������� ��� �������� 0 - " + list.set(0, changedItem) + " �� " + changedItem);

        list.add("2");
        System.out.println("������ ������� ������: " + list.get(0) + "; ������ ������� ������: " + list.get(1) + "; ����� ��������� � ������ = " + list.getCount());

        list.add("1");
        list.add("0");
        System.out.println("�������� ������ : " + list + "; ����� ��������� � ������ = " + list.getCount());

        System.out.println();

        list.add(1, null);
        System.out.println("�������� ������� �� ������� 1: " + list);

        System.out.println("������� ������� �� ������� 1: " + list.remove(1));
        System.out.println("�������� ������: " + list);

        System.out.println("�������� ������� ������� \"5\": " + list.remove("5"));
        System.out.println("�������� ������: " + list);

        SinglyLinkedList<String> copiedList = list.copy();
        System.out.println("����������� ������: " + copiedList);

        list.revert();
        System.out.println("���������� ������: " + list);
    }
}
