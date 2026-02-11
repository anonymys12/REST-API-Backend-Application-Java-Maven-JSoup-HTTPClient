package com.example.autoria.service;

import com.example.autoria.model.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    // Фільтр по бренду і моделі
    public List<Car> filterByBrandModel(List<Car> cars, String brand, String model) {
        return cars.stream()
                .filter(c -> c.getBrand().equalsIgnoreCase(brand))
                .filter(c -> c.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    // Повертає топ найдешевших
    public List<Car> cheapest(List<Car> cars, int limit) {
        return cars.stream()
                .sorted(Comparator.comparingInt(c -> parsePrice(c.getPrice())))
                .limit(limit)
                .collect(Collectors.toList());
    }

    // Допоміжний метод: "2 500 $" -> 2500
    private int parsePrice(String price) {
        try {
            return Integer.parseInt(price.replaceAll("[^\\d]", ""));
        } catch (Exception e) {
            return Integer.MAX_VALUE; // якщо не вдалося спарсити
        }
    }
}
