package ru.academist.khudyakov;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static ArrayList<String> readFileStringsToArrayList(String name) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(name))) {
            ArrayList<String> strings = new ArrayList<>();

            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }

            return strings;
        }
    }

    public static void deleteAllEvenNumbers(ArrayList<Integer> arrayList) {
        int i = 0;

        while (i < arrayList.size()) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            } else {
                i++;
            }
        }
    }

    public static ArrayList<Integer> getNoDuplicateArrayList(ArrayList<Integer> arrayList) {
        ArrayList<Integer> noDuplicateArrayList = new ArrayList<>();

        while (!arrayList.isEmpty()) {
            noDuplicateArrayList.add(arrayList.get(0));

            ArrayList<Integer> elementList = new ArrayList<>();
            elementList.add(arrayList.get(0));
            arrayList.removeAll(elementList);
        }

        return noDuplicateArrayList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> fileStrings = readFileStringsToArrayList("ArrayListHomeInput.txt");
        System.out.println(fileStrings.get(0));
        System.out.println(fileStrings.get(fileStrings.size() - 1));
        System.out.println();

        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list1.add(i);
        }

        deleteAllEvenNumbers(list1);
        System.out.println(list1);

        list1 = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 5, 5, 6, 6, 7, 8, 9, 10, 15, 16, 16, 16, 16, 17));

        deleteAllEvenNumbers(list1);
        System.out.println(list1);
        System.out.println();

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 7, 4, 5, 4, 2, 3, 2, 4, 9, 7, 6, 4, 8, 3, 6, 2, 7, 9, 0, 1, 5, 2, 8, 5, 0, 3));

        ArrayList<Integer> list3 = getNoDuplicateArrayList(list2);

        System.out.println(list3);
        System.out.println(list2);
    }
}
