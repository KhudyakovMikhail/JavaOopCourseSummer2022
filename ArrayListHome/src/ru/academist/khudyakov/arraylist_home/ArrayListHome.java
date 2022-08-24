package ru.academist.khudyakov.arraylist_home;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static ArrayList<String> getFileLines(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> lines = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        }
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

        for (Integer element : list) {
            if (!listWithoutDuplicates.contains(element)) {
                listWithoutDuplicates.add(element);
            }
        }

        return listWithoutDuplicates;
    }

    public static void main(String[] args) {
        try {
            ArrayList<String> fileStrings = getFileLines("ArrayListHomeInput.txt");
            System.out.println("Строки файла: " + fileStrings);
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }

        System.out.println();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        deleteEvenNumbers(list);
        System.out.println("Список с удаленными четными числами: " + list);

        list = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 5, 5, 6, 6, 7, 8, 9, 10, 15, 16, 16, 16, 16, 17));

        deleteEvenNumbers(list);
        System.out.println("Список с удаленными четными числами: " + list);
        System.out.println();

        ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(1, 1, 2, 7, 4, 5, 4, 2, 3, 2, 4, 9, 7, 6, 4, 8, 3, 6, 2, 7, 9, 0, 1, 5, 2, 8, 5, 0, 3));

        ArrayList<Integer> listWithoutDuplicates = getListWithoutDuplicates(listWithDuplicates);
        System.out.println("Список без повторений: " + listWithoutDuplicates);
    }
}
