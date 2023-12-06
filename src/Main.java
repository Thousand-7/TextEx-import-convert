import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path pathOfFile = Paths.get("Z:\\Java\\My_Projects\\testEx\\resources\\app.properties.txt");
        Map<String, String> conversionMap = importDataAndConversion(pathOfFile);
        System.out.println(conversionMap.toString());

    }
    public static Map<String, String> importDataAndConversion(Path path){
        try(Stream<String> stream = Files.newBufferedReader(path).lines()) {
            return stream.map(x -> x.split("=")).collect(Collectors.toMap(x -> x[0], x-> x[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}