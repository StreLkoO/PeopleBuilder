import java.util.OptionalInt;

public class PeopleBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;

    public PeopleBuilder() {

    }

    public PeopleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PeopleBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PeopleBuilder setAge(int age) {
        if (age >= 0 && age < 100) {
            this.age = OptionalInt.of(age);
            return this;
        } else {
            throw new IllegalArgumentException("Введен недопустимый возраст! (" + age + ")");
        }
    }

    public PeopleBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public People build() {
        if (name == null) {
            throw new IllegalStateException("Поле \"name\" не должно быть пустым!");
        }
        if (surname == null) {
            throw new IllegalStateException("Поле \"surname\" не должно быть пустым!");
        }
        People p;
        if (age.isEmpty()) {
            p = new People(name, surname);
        } else {
            p = new People(name, surname, age.getAsInt());
        }
        p.setAddress(address);
        return p;
    }
}
