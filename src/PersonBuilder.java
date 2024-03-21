import java.util.Optional;

public class PersonBuilder {

    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person(name, surname, Optional.ofNullable(age), Optional.ofNullable(address));
        if (name == null || surname == null) {
            throw new IllegalStateException("Not enough data");
        }
        if (name.length() < 1 || surname.length() < 1 || age < 0) {
            throw new IllegalArgumentException("Incorrect data");
        }
        return person;
    }
}
