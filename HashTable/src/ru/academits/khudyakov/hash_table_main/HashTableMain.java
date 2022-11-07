package ru.academits.khudyakov.hash_table_main;

import ru.academits.khudyakov.hash_table.HashTable;

import java.util.Arrays;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable<Integer> hashTable = new HashTable<>(Arrays.asList(1, 14, null, 4, 11, 63, 21, 34, 5));

        hashTable.addAll(Arrays.asList(18, 20));

        System.out.println("Размер таблицы: " + hashTable.size());
        System.out.println(hashTable);
        System.out.println();

        System.out.println("Удаляем элементы");
        hashTable.remove(20);
        hashTable.removeAll(Arrays.asList(21, 14));
        System.out.println(hashTable);
        System.out.println();

        System.out.println("Размер таблицы: " + hashTable.size());

        System.out.println("Элементы таблицы: ");
        for (Integer e : hashTable) {
            System.out.print(e + " ");
        }
    }
}
