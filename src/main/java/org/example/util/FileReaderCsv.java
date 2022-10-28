package org.example.util;

import java.util.List;

public interface FileReaderCsv {
    List<String[]> readCsvFile(String fileName);
}
