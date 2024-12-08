package ru.sberuniversity.classesandpackages;

public class Main {
    public static void main(String[] args) {
        System.out.println("<---Child no constructor--->");
        Child childNoConstructor = new Child();

        System.out.println("<---Child name constructor--->");
        Child childNameConstructor = new Child("Ivan");
    }
}