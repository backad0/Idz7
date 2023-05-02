import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class HouseTest {

    @Test
    public void deserializeHouse() {
        var flatList = new ArrayList<Flat>() {{
            add(new Flat(1, 10, new ArrayList<>() {{
                add(new Person("name", "l_name", "p",new Date(2, 12,2000)));
            }}));
        }};

        var house = new House("1", "some_adr", new Person("name", "l_name", "p", new Date(2, 12,2000)), flatList);

        assertEquals(house, House.deserializeHouse(House.serializeHouse(house)));
    }
}
