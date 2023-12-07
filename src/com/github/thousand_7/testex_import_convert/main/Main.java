package com.github.thousand_7.testex_import_convert.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Path pathOfFile = Paths.get("Z:\\Java\\My_Projects\\testEx\\src\\com\\github\\thousand_7\\testex_import_convert\\main\\resourses\\app.properties.txt");
        Converter converter = new Converter(pathOfFile);
        Map<String, String> conversionMap = converter.getMap();
        System.out.println(conversionMap.toString());

    }
}