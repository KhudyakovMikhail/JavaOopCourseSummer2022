package ru.academist.khudyakov.arraylist_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static ArrayList<String> getFileLines(String name) {
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(name))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден");
        }

        return lines;
    }


    public static void deleteEvenNumbers(ArrayList<Integer> list) {
        int i = 0;

        while (i < list.size()) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public static ArrayList<Integer> getListWithoutDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(list.size());
        ArrayList<Integer> listCopy = new ArrayList<>(list);

        while (!listCopy.isEmpty()) {
            listWithoutDuplicates.add(listCopy.get(0));
            listCopy.removeAll(listWithoutDuplicates);
        }

        return listWithoutDuplicates;
    }

    public static void main(String[] args) {
        ArrayList<String> fileStrings = getFileLines("ArrayListHomeInput.txt");
        System.out.println(fileStrings);
        System.out.println();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        deleteEvenNumbers(list);
        System.out.println(list);

        list = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 5, 5, 6, 6, 7, 8, 9, 10, 15, 16, 16, 16, 16, 17));

        deleteEvenNumbers(list);
        System.out.println(list);
        System.out.println();

        ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 7, 4, 5, 4, 2, 3, 2, 4, 9, 7, 6, 4, 8, 3, 6, 2, 7, 9, 0, 1, 5, 2, 8, 5, 0, 3));

        ArrayList<Integer> listWithoutDuplicates = getListWithoutDuplicates(listWithDuplicates);
        System.out.println(listWithoutDuplicates);
    }
}
