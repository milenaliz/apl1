package apl1;

public class Student {
    private String name;
    private String lastName;
    private int yearOfStudy;
    private double średnia;
    private Promotor promotor;

    @Label(value = "Promotor", order = 0)
    public Promotor getPromotor() {
        return promotor;
    }

    @Writable(value = "Promotor", order = 0)
    public Student setPromotor(Promotor promotor) {
        this.promotor = promotor;
        return this;
    }

    @Label(value = "imię", order = 0)
    public String getName() {
        return name;
    }

    @Label(value = "nazwisko", order = 0)
    public String getLastName() {
        return lastName;
    }

    @Label(value = "rok studiów", order = 0)
    public int getYear() {
        return yearOfStudy;
    }

    @Label(value = "średnia ocen", order = 3)
    public double getŚrednia() {
        return średnia;
    }

    @Writable(value = "imię", order = 0)
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    @Writable(value = "nazwisko", order = 0)
    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Writable(value = "rok studiów", order = 0)
    public Student setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
        return this;
    }

    @Writable(value = "średnia", order = 0)
    public Student setŚrednia(double średnia) {
        this.średnia = średnia;
        return this;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + yearOfStudy +
                '}';
    }
}
