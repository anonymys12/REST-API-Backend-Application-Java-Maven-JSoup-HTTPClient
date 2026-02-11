package com.example.autoria;

import com.example.autoria.model.Car;
import com.example.autoria.parser.AutoRiaParser;
import com.example.autoria.service.CarService;
import com.example.autoria.util.TextUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AutoRiaParser parser = new AutoRiaParser();
        CarService service = new CarService();

        // Збираємо всі сторінки Peugeot 406
        List<Car> cars = parser.parseAllPages();
        System.out.println("Total Peugeot 406 found: " + cars.size());

        // Топ 5 найдешевших
        List<Car> cheapest = service.cheapest(cars, 5);
        System.out.println("Top 5 cheapest Peugeot 406:");
        cheapest.forEach(System.out::println);

        // Зберігаємо усі результати в текстовий файл
        TextUtil.saveToTextFile(cars, "peugeot406.txt");
    }
}
