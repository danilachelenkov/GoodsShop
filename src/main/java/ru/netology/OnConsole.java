package ru.netology;

public class OnConsole implements Printable {
    @Override
    public void show(String msg) {
        System.out.println(msg);
    }
}
