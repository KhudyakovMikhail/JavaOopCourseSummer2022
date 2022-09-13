package ru.academits.khudyakov.list_main;

import ru.academits.khudyakov.list.SinglyLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        System.out.println(list);

        list.addFirst("35");
        System.out.println("������ ������� ������: " + list.getFirst() + "; ����� ��������� � ������ = " + list.getCount());

        String changedItem = "3";
        System.out.println("������ �������� �������� ��� �������� 0 - " + list.set(0, changedItem) + " �� " + changedItem);

        list.addFirst("2");
        System.out.println("������ ������� ������: " + list.get(0) + "; ������ ������� ������: " + list.get(1) + "; ����� ��������� � ������ = " + list.getCount());

        list.addFirst("1");
        list.addFirst("0");
        System.out.println("�������� ������ : " + list + "; ����� ��������� � ������ = " + list.getCount());

        System.out.println();

        list.add(1, null);
        System.out.println("�������� ������� �� ������� 1: " + list);

        list.add(3, null);
        System.out.println("�������� ������� �� ������� 3: " + list);

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
