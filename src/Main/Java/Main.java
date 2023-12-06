package Main.Java;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Path pathOfFile = Paths.get("Z:\\Java\\My_Projects\\testEx\\src\\Main\\Resourses\\app.properties.txt");
        Converter converter = new Converter(pathOfFile);
        Map<String, String> conversionMap = converter.getMap();
        System.out.println(conversionMap.toString());

    }
}