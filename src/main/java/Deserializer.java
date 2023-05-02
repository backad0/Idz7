import java.io.*;
import java.lang.reflect.Type;

public class Deserializer {
    public static Object deserialize(String filename) throws IOException, ClassNotFoundException, ClassCastException {
        try (ObjectInput input = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            return (Object) input.readObject();
        }
    }

}
