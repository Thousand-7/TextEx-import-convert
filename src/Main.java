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
        Converter converter = new Converter(pathOfFile);
        Map<String, String> conversionMap = converter.getMap();
        System.out.println(conversionMap.toString());

    }
    public static class Converter{
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
}