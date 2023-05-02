import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


public class House implements Serializable {
    private String cNumber;
    private String address;
    private Person headOfTheHouse;
    private ArrayList<Flat> flats;


    @JsonCreator
    public House(@JsonProperty(value = "cNumber") String cNumber,@JsonProperty(value = "address") String address, @JsonProperty(value = "headOfTheHouse") Person headOfTheHouse, @JsonProperty(value = "flats") ArrayList<Flat> flats){
        setcNumber(cNumber);
        setAddress(address);
        setHeadOfTheHouse(headOfTheHouse);
        setFlats(flats);
    }

    /*public House(String cNumber, String address, Person headOfTheHouse, ArrayList<Flat> flats) {
        this.cNumber = cNumber;
        this.address = address;
        this.headOfTheHouse = headOfTheHouse;
        this.flats = flats;
    }*/

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getHeadOfTheHouse() {
        return headOfTheHouse;
    }

    public void setHeadOfTheHouse(Person headOfTheHouse) {
        this.headOfTheHouse = headOfTheHouse;
    }

    public ArrayList<Flat> getFlats() {
        return flats;
    }

    public void setFlats(ArrayList<Flat> flats) {
        this.flats = flats;
    }

    public static void saveHouseToCSV(House house) {
        try (var fileOS = new PrintWriter(new FileOutputStream(String.format("house_%s.csv", house.getcNumber())))) {
            fileOS.print(String.format(";Данные о доме:\n;\nКадастровый номер:;%s;\nАдрес:;%s;\nСтарший по дому:;%s %s\n;\n",
                    house.getcNumber(), house.getAddress(),
                    house.getHeadOfTheHouse().getSurname(), house.getHeadOfTheHouse().getName()));
            fileOS.print("№;Площадь кв.м;Владельцы\n");
            for (Flat flat : house.getFlats()) {
                fileOS.print(String.format("%d;%.0f;", flat.getNumber(), flat.getSquare()));
                for (Person person : flat.getTenants()) {
                    fileOS.print(String.format("%s %c. ", person.getSurname(), person.getName().charAt(0)));
                }
                fileOS.print(";\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static House deserializeHouse(String json){
        try {
            return new ObjectMapper().readValue(json, House.class);
        } catch (IOException e){
            throw new RuntimeException("Deserialize error");
        }
    }
    public static String serializeHouse(House house){
        try {
            return new ObjectMapper().writeValueAsString(house);
        } catch (IOException e){
            throw new RuntimeException("Serialize error");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cNumber, house.cNumber) && Objects.equals(address, house.address) && Objects.equals(headOfTheHouse, house.headOfTheHouse) && Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cNumber, address, headOfTheHouse, flats);
    }
}
