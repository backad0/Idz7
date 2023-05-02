import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private String patronymic;
    private String surname;
    private Date birthday;

    @JsonCreator
    public Person(@JsonProperty(value = "name") String name,@JsonProperty(value = "patronymic") String patronymic, @JsonProperty(value = "surname") String surname, @JsonProperty(value = "birthday") Date birthday){
        setName(name);
        setPatronymic(patronymic);
        setSurname(surname);
        setBirthday(birthday);
    }
    /*public Person(String name, String surname, String patronymic, Date birthday){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }*/

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(patronymic, person.patronymic) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, patronymic, surname);
    }
}
