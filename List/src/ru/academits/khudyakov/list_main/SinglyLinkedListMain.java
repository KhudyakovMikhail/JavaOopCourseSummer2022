package ru.academits.khudyakov.list_main;

import ru.academits.khudyakov.list.SinglyLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        System.out.println(list);

        list.addFirst("35");
        System.out.println("Первый элемент списка: " + list.getFirst() + "; число элементов в списке = " + list.getCount());

        String changedItem = "3";
        System.out.println("Меняем значение элемента под индексом 0 - " + list.set(0, changedItem) + " на " + changedItem);

        list.addFirst("2");
        System.out.println("Первый элемент списка: " + list.get(0) + "; второй элемент списка: " + list.get(1) + "; число элементов в списке = " + list.getCount());

        list.addFirst("1");
        list.addFirst("0");
        System.out.println("Элементы списка : " + list + "; число элементов в списке = " + list.getCount());

        System.out.println();

        list.add(1, null);
        System.out.println("Добавили элемент по индексу 1: " + list);

        list.add(3, null);
        System.out.println("Добавили элемент по индексу 3: " + list);

        System.out.println("Удаляем элемент по индексу 1: " + list.remove(1));
        System.out.println("Элементы списка: " + list);

        System.out.println("Пытаемся удалить элемент \"5\": " + list.remove("5"));
        System.out.println("Элементы списка: " + list);

        SinglyLinkedList<String> copiedList = list.copy();
        System.out.println("Скопировали список: " + copiedList);

        list.revert();
        System.out.println("Развернули список: " + list);
    }
}
