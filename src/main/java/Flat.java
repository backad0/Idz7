import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Flat implements Serializable {
    private int number;
    private  double square;
    private ArrayList<Person> tenants;

    @JsonCreator
    public Flat(@JsonProperty(value = "number") int number,@JsonProperty(value = "square") double square,@JsonProperty(value = "tenants") ArrayList<Person> tenants) {
        this.number = number;
        this.square = square;
        this.tenants = tenants;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public ArrayList<Person> getTenants() {
        return tenants;
    }

    public void setTenants(ArrayList<Person> tenants) {
        this.tenants = tenants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && Double.compare(flat.square, square) == 0 && Objects.equals(tenants, flat.tenants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, square, tenants);
    }
}
