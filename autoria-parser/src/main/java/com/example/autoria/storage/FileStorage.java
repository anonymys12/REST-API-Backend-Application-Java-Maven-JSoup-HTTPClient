package com.example.autoria.storage;

import com.example.autoria.model.Car;

import java.io.FileWriter;
import java.util.List;

public class FileStorage {

    public void save(List<Car> cars, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Car car : cars) {
                writer.write(car.toString() + System.lineSeparator());
            }
        } catch (Exception e) {
            throw new RuntimeException("File write error", e);
        }
    }
}
