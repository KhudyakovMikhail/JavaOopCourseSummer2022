package ru.academits.khudyakov.hash_table_main;

import ru.academits.khudyakov.hash_table.MyHashTable;

import java.util.Arrays;

public class MyHashTableMain {
    public static void main(String[] args) {
        MyHashTable<Integer> hashTable1 = new MyHashTable<>(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 13, 14));

        hashTable1.addAll(Arrays.asList(15, 18, 19, 20, 1, 7, 14, 0, 23, 38));

        System.out.println(hashTable1.size());
        System.out.println(hashTable1);
        System.out.println();

        Object[] array = hashTable1.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println();

        hashTable1.remove(14);
        hashTable1.remove(20);
        hashTable1.remove(7);
        System.out.println(hashTable1);

        hashTable1.removeAll(Arrays.asList(9, 13, 18, 40));
        System.out.println(hashTable1);
    }
}
