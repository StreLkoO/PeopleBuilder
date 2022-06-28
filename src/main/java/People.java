import java.util.OptionalInt;

public class People {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    protected People(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    protected People(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    protected People(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
        this.address = address;
    }

    protected People(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return !getAddress().isEmpty();
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age.ifPresent(x -> x++);
    }

    @Override
    public String toString() {
        String s = "People: " + name + " " + surname;
        if (age.isPresent()) {
            s += " age: " + age.getAsInt();
        }
        if (address != null) {
            s += " from " + address;
        }
        return s;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode()
                + age.hashCode() + address.hashCode();
    }

    public PeopleBuilder newChildBuilder() {
        return new PeopleBuilder().setSurname(this.surname)
                .setAge(0).setAddress(this.getAddress());
    }
}
