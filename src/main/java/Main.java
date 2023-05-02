import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        Person person0 = new Person("Иван", "Иванов","Иванович", new Date(7, 13, 2003));
        Person person1 = new Person("Саша", "Сашов","Сашович", new Date(3, 17, 2001));
        ArrayList<Person> people0 = new ArrayList<>();
        Collections.addAll(people0, person0, person1);
        Flat flat0 = new Flat(1, 89, people0);
        Person person2 = new Person("Андрей", "Андреев","Андреевич", new Date(9, 23, 2002));
        ArrayList<Person> people1 = new ArrayList<>();
        Collections.addAll(people1, person2);
        Flat flat1 = new Flat(2, 64, people1);
        ArrayList<Flat> flats = new ArrayList<>();
        Collections.addAll(flats, flat0, flat1);
        House house = new House("1", "ул. Ленина", person0, flats);
        House.saveHouseToCSV(house);
        System.out.println(person0.getSurname());

    }
}
