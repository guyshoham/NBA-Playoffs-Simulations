package playoffs;

public class Team {
    private String name;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
