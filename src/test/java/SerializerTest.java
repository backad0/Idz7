import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class SerializerTest {

    @Test
    public void serializePerson() throws IOException, ClassNotFoundException {
        Person person = new Person("Иван", "Иванов", "Иванович" , new Date(1, 1, 2000));
        Serializer.serialize(person, "person");
        assertEquals(person, Deserializer.deserialize("person"));
    }

    @Test
    public void serializeFlat() throws IOException, ClassNotFoundException{
        ArrayList<Person> tenants = new ArrayList<>();
        Collections.addAll(tenants, new Person("Иван", "Иванов", "Иванович",new Date(1, 1, 2000)),
                new Person("Иван1", "Иванов1", "Иванович1",new Date(1, 1, 2000)));
        Flat flat = new Flat(1, 15, tenants);
        Serializer.serialize(flat, "flat");
        assertEquals(flat, Deserializer.deserialize("flat"));
    }

    @Test
    public void serializeHouse() throws IOException, ClassNotFoundException{
        ArrayList<Person> tenants1 = new ArrayList<>();
        ArrayList<Person> tenants2 = new ArrayList<>();
        Collections.addAll(tenants1, new Person("Иван", "Иванов", "Иванович",new Date(1, 1, 2000)),
                new Person("Иван1", "Иванов1", "Иванович1",new Date(1, 1, 2000)));
        Collections.addAll(tenants2, new Person("Иван2", "Иванов2", "Иванович2",new Date(1, 1, 2000)),
                new Person("Иван3", "Иванов3", "Иванович3",new Date(1, 1, 2000)));
        Flat flat1 = new Flat(1, 10, tenants1);
        Flat flat2 = new Flat(2, 15, tenants2);
        ArrayList<Flat> flats = new ArrayList<>();
        Collections.addAll(flats, flat1, flat2);
        House house = new House("111111111111111", "Marks street 1",
                new Person("Иван", "Иванов", "Иванович",new Date(1, 1, 2000)), flats );
        Serializer.serialize(house, "house");
        assertEquals(house, Deserializer.deserialize("house"));
    }
}
