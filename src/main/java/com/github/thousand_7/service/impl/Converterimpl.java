package com.github.thousand_7.service.impl;

import com.github.thousand_7.service.Converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class Converterimpl implements Converter {
    private Path pathOfFile;
    public Converterimpl(Path path){
        pathOfFile = path;
    }

    public Path getPathOfFile() {
        return pathOfFile;
    }

    public void setPathOfFile(Path pathOfFile) {
        this.pathOfFile = pathOfFile;
    }
    @Override
    public Map<String, String> getMap(){
        try(Stream<String> stream = Files.newBufferedReader(pathOfFile).lines()) {
            return stream.map(x -> x.split("=")).collect(Collectors.toMap(x -> x[0], x-> x[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}