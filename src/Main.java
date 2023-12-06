import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }
    public static Map<String, String> importDataAndConversion(Path path){
        try(Stream<String> stream = Files.newBufferedReader(path).lines()) {
            return stream.map(x -> x.split("=")).collect(Collectors.toMap(x -> x[0], x-> x[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}