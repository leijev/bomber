package com.example.pythonbomber.utils;

public class NewName {
    Integer len;
    public NewName(Integer len) {
        this.len = len;
    }
    public String generate() {
        char[] letters = {'q', 'w','e','r', 't','y','u', 'i','o','p', 'a','s','d', 'f','g'};
        String username = "";
        for (int i = 0; i < len;i++) {
            username += letters[i];
        }
        return username;
    }
    public String getName() {
        String[] names = new String[]{"Лёша", "Тёма", "Вадик", "Вова", "Валя", "Даня", "Деня", "Дима", "Егор", "Кира", "Лёня", "Макс", "Мотя", "Никита", "Олег", "Паша"};
        int random = (int) Math.random() * names.length;
        return names[random];
    }
}
