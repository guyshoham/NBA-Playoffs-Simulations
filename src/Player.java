public class Player {
    private String name;
    private PlayoffPicture bet;
    private int wins, score;

    public Player(String name) {
        this.name = name;
        wins = 0;
        score = 0;
    }

    public void setBet(PlayoffPicture bet) {
        this.bet = bet;
    }

    public PlayoffPicture getBet() {
        return bet;
    }

    public void addWin() {
        wins++;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void resetScore() {
        setScore(0);
    }

    public int getWins() {
        return wins;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                '}';
    }
}
