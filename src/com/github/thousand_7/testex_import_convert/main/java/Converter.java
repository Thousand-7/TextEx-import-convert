package com.github.thousand_7.testex_import_convert.main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    class Converter{
    private Path pathOfFile;
    Converter(Path path){
        pathOfFile = path;
    }

    public Path getPathOfFile() {
        return pathOfFile;
    }

    public void setPathOfFile(Path pathOfFile) {
        this.pathOfFile = pathOfFile;
    }
    public Map<String, String> getMap(){
        try(Stream<String> stream = Files.newBufferedReader(pathOfFile).lines()) {
            return stream.map(x -> x.split("=")).collect(Collectors.toMap(x -> x[0], x-> x[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}