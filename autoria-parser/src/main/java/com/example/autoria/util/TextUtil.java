package com.example.autoria.util;

import com.example.autoria.model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextUtil {

    public static void saveToTextFile(List<Car> cars, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Car car : cars) {
                writer.write(car.toString() + System.lineSeparator());
            }
            System.out.println("Saved " + cars.size() + " cars to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
