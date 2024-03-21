import java.util.Optional;

public class Person {

    protected final String name;
    protected final String surname;
    protected Optional<Integer> age;
    protected final Optional<String> address;

    public Person(String name, String surname, Optional<Integer> age, Optional<String> address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address.isPresent();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void happyBirthday() {
        if (hasAge()){
            age = Optional.of(age.get() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(String.valueOf(address));
    }

    @Override
    public String toString() {
        String person = "Person [name = " + name +
                ", surname = " + surname +
                ", age = " + age +
                ", address = " + address + "]";
        return person;
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + (surname == null ? 0 : surname.hashCode());
        result = 31 * result + (age.isEmpty() ? 0 : age.hashCode());
        result = 31 * result + (address.isEmpty() ? 0 : address.hashCode());
        return result;
    }
}
