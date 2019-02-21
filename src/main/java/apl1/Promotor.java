package apl1;

public class Promotor {
    private String imię;
    private String nazwisko;
    private int level;

    @Label(value = "imię", order = 0)
    public String getImię() {
        return imię;
    }
    @Label(value = "nazwisko", order = 0)
    public String getNazwisko() {
        return nazwisko;
    }
@Label(value = "level", order = 0)
    public int getLevel() {
        return level;
    }

    @Writable(value = "imię", order = 0)
    public Promotor setImię(String imię) {
        this.imię = imię;
        return this;
    }

    @Writable(value = "nazwisko", order = 0)
    public Promotor setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        return this;
    }

    @Writable(value = "level", order = 0)
    public Promotor setLevel(int level) {
        this.level = level;
        return this;
    }

    @Override
    public String toString() {
        return "Promotor{" +
                "imię='" + imię + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", level=" + level +
                '}';
    }
}
