package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStream {

    public void writeCSV(String filename, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { // true để ghi tiếp vào file
            writer.write(data);
            writer.newLine();
        }
    }

    public List<String[]> readCSV(String filename) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }
        }
        return data;
    }
}