package org.example.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.example.service.FileWriterCsv;

public class CsvFileWriter implements FileWriterCsv {
    @Override
    public void writeToFile(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}
