package ro.ase.acs.classes;

import ro.ase.acs.interfaces.ValuesWriter;

import java.util.List;
import java.util.Map;

public class ConsoleWriter implements ValuesWriter {
    @Override
    public void displaySetResult(List<Map<String, Object>> rows) {
        rows.forEach(map -> map.forEach((key, value) -> System.out.println(key + ": " + value)));
    }
}
