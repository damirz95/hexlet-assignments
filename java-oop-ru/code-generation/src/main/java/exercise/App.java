package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car object) throws IOException {
        String saveObject = object.serialize();
        byte[] strToByte = saveObject.getBytes();

        Files.write(path, strToByte);
    }
    public static Car extract(Path path) throws IOException {
        String file = Files.readString(path);
        return Car.unserialize(file);
    }
}
// END
