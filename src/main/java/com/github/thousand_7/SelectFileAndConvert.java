package com.github.thousand_7;

import com.github.thousand_7.service.Converter;
import com.github.thousand_7.service.impl.Converterimpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class SelectFileAndConvert {
    public static void main(String[] args) {
        Path pathOfFile = Paths.get("Z:\\Java\\My_Projects\\testEx\\src\\main\\resources\\app.properties.txt");
        Converter converter = new Converterimpl(pathOfFile);
        Map<String, String> conversionMap = converter.getMap();
        System.out.println(conversionMap.toString());
    }
}