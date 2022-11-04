package org.example.service;

import java.util.List;

public interface FileReaderCsv {
    List<String[]> readCsvFile(String fileName);
}
