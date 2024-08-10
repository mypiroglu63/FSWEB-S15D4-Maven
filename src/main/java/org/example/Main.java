package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        WorkintechList<String> list = new WorkintechList<>();
        list.add("C");
        list.add("A");
        list.add("B");
        list.add("A");

        System.out.println(list);
        list.remove("B");
        System.out.println(list);

        list.add("D");
        System.out.println(list);

        System.out.println("------------------");

        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(checkForPalindrome("Racecar")); // true
        System.out.println(checkForPalindrome("hello")); // false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?")); // true

        System.out.println("-----------------------------");

        System.out.println(convertDecimalToBinary(5));  // Çıktı: 101
        System.out.println(convertDecimalToBinary(6));  // Çıktı: 110
        System.out.println(convertDecimalToBinary(13)); // Çıktı: 1101
    }

    public static boolean checkForPalindrome(String input) {

        String cleanedInput = input.toLowerCase().replaceAll("[^a-z]", "");


        String reversedInput = new StringBuilder(cleanedInput).reverse().toString();


        return cleanedInput.equals(reversedInput);
    }

    public static String convertDecimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder binaryString = new StringBuilder();

        while (decimalNumber > 0) {
            binaryString.insert(0, decimalNumber % 2);
            decimalNumber = decimalNumber / 2;
        }

        return binaryString.toString();
    }


    public static class WorkintechList<T extends Comparable<T>> extends ArrayList<T> {

        @Override
        public boolean add(T element) {
            if (!this.contains(element)) {
                super.add(element);
                this.sort();
                return true;
            }
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            boolean isModified = false;
            for (T element : c) {
                if (this.add(element)) {
                    isModified = true;
                }
            }
            return isModified;
        }

        public void sort() {
            Collections.sort(this);
        }

        @Override
        public boolean remove(Object o) {
            boolean isRemoved = super.remove(o);
            if (isRemoved) {
                this.sort();
            }
            return isRemoved;
        }

        @Override
        public T set(int index, T element) {
            if (!this.contains(element)) {
                T oldElement = super.set(index, element);
                this.sort();
                return oldElement;
            }
            return null;
        }
    }
}
