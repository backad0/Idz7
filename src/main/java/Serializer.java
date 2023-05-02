import java.io.*;
import java.lang.reflect.Type;

public class Serializer {
    public static void serialize(Object classObject, String filename) throws IOException {
        try (ObjectOutput output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
            output.writeObject(classObject);
        }
    }

}
