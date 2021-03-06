package playoffs;

public class Player implements Comparable<Player> {
    private String name;
    private PlayoffPicture bet;
    private int wins, score;

    public Player(String name) {
        this.name = name;
        wins = 0;
        score = 0;
    }

    public static Player initGuy() {
        Player guy = new Player("Guy Shoham");
        PlayoffPicture guyBet = new PlayoffPicture(true);
        guyBet.getRound1()[0].setSeries(Constants.E18, 4, 1);
        guyBet.getRound1()[1].setSeries(Constants.E45, 4, 2);
        guyBet.getRound1()[2].setSeries(Constants.E36, 4, 2);
        guyBet.getRound1()[3].setSeries(Constants.E27, 4, 1);

        guyBet.getRound1()[4].setSeries(Constants.W18, 4, 0);
        guyBet.getRound1()[5].setSeries(Constants.W45, 4, 2);
        guyBet.getRound1()[6].setSeries(Constants.W36, 2, 4);
        guyBet.getRound1()[7].setSeries(Constants.W27, 4, 2);

        guyBet.getRound2()[0].setSeries(Constants.MIL, Constants.BOS, 4, 2);
        guyBet.getRound2()[1].setSeries(Constants.PHI, Constants.TOR, 2, 4);
        guyBet.getRound2()[2].setSeries(Constants.GS, Constants.HOU, 4, 2);
        guyBet.getRound2()[3].setSeries(Constants.OKC, Constants.DEN, 4, 2);

        guyBet.getConfFinals()[0].setSeries(Constants.MIL, Constants.TOR, 4, 3);
        guyBet.getConfFinals()[1].setSeries(Constants.GS, Constants.OKC, 4, 1);

        guyBet.getFinals().setSeries(Constants.MIL, Constants.GS, 2, 4);
        guy.setBet(guyBet);
        return guy;
    }

    public static Player initOren() {
        Player oren = new Player("Oren Savir");
        PlayoffPicture orenBet = new PlayoffPicture(true);
        orenBet.getRound1()[0].setSeries(Constants.E18, 4, 0);
        orenBet.getRound1()[1].setSeries(Constants.E45, 4, 2);
        orenBet.getRound1()[2].setSeries(Constants.E36, 4, 1);
        orenBet.getRound1()[3].setSeries(Constants.E27, 4, 0);

        orenBet.getRound1()[4].setSeries(Constants.W18, 4, 1);
        orenBet.getRound1()[5].setSeries(Constants.W45, 4, 2);
        orenBet.getRound1()[6].setSeries(Constants.W36, 1, 4);
        orenBet.getRound1()[7].setSeries(Constants.W27, 3, 4);

        orenBet.getRound2()[0].setSeries(Constants.MIL, Constants.BOS, 4, 2);
        orenBet.getRound2()[1].setSeries(Constants.PHI, Constants.TOR, 2, 4);
        orenBet.getRound2()[2].setSeries(Constants.GS, Constants.HOU, 4, 2);
        orenBet.getRound2()[3].setSeries(Constants.OKC, Constants.SA, 4, 2);

        orenBet.getConfFinals()[0].setSeries(Constants.MIL, Constants.TOR, 3, 4);
        orenBet.getConfFinals()[1].setSeries(Constants.GS, Constants.OKC, 4, 1);

        orenBet.getFinals().setSeries(Constants.TOR, Constants.GS, 2, 4);
        oren.setBet(orenBet);
        return oren;
    }

    public static Player initMaman() {
        Player maman = new Player("Roy Maman");
        PlayoffPicture mamanBet = new PlayoffPicture(true);
        mamanBet.getRound1()[0].setSeries(Constants.E18, 4, 0);
        mamanBet.getRound1()[1].setSeries(Constants.E45, 4, 2);
        mamanBet.getRound1()[2].setSeries(Constants.E36, 4, 0);
        mamanBet.getRound1()[3].setSeries(Constants.E27, 4, 0);

        mamanBet.getRound1()[4].setSeries(Constants.W18, 4, 0);
        mamanBet.getRound1()[5].setSeries(Constants.W45, 4, 1);
        mamanBet.getRound1()[6].setSeries(Constants.W36, 4, 3);
        mamanBet.getRound1()[7].setSeries(Constants.W27, 2, 4);

        mamanBet.getRound2()[0].setSeries(Constants.MIL, Constants.BOS, 4, 3);
        mamanBet.getRound2()[1].setSeries(Constants.PHI, Constants.TOR, 2, 4);
        mamanBet.getRound2()[2].setSeries(Constants.GS, Constants.HOU, 4, 2);
        mamanBet.getRound2()[3].setSeries(Constants.POR, Constants.SA, 4, 3);

        mamanBet.getConfFinals()[0].setSeries(Constants.MIL, Constants.TOR, 2, 4);
        mamanBet.getConfFinals()[1].setSeries(Constants.GS, Constants.POR, 4, 1);

        mamanBet.getFinals().setSeries(Constants.TOR, Constants.GS, 4, 1);
        maman.setBet(mamanBet);
        return maman;
    }

    public static Player initRittner() {
        Player rittner = new Player("Or Rittner");
        PlayoffPicture rittnerBet = new PlayoffPicture(true);
        rittnerBet.getRound1()[0].setSeries(Constants.E18, 4, 0);
        rittnerBet.getRound1()[1].setSeries(Constants.E45, 4, 3);
        rittnerBet.getRound1()[2].setSeries(Constants.E36, 4, 1);
        rittnerBet.getRound1()[3].setSeries(Constants.E27, 4, 0);

        rittnerBet.getRound1()[4].setSeries(Constants.W18, 4, 0);
        rittnerBet.getRound1()[5].setSeries(Constants.W45, 4, 2);
        rittnerBet.getRound1()[6].setSeries(Constants.W36, 2, 4);
        rittnerBet.getRound1()[7].setSeries(Constants.W27, 4, 3);

        rittnerBet.getRound2()[0].setSeries(Constants.MIL, Constants.BOS, 4, 1);
        rittnerBet.getRound2()[1].setSeries(Constants.PHI, Constants.TOR, 3, 4);
        rittnerBet.getRound2()[2].setSeries(Constants.GS, Constants.HOU, 4, 2);
        rittnerBet.getRound2()[3].setSeries(Constants.OKC, Constants.DEN, 4, 2);

        rittnerBet.getConfFinals()[0].setSeries(Constants.MIL, Constants.TOR, 2, 4);
        rittnerBet.getConfFinals()[1].setSeries(Constants.GS, Constants.OKC, 4, 1);

        rittnerBet.getFinals().setSeries(Constants.TOR, Constants.GS, 2, 4);
        rittner.setBet(rittnerBet);
        return rittner;
    }

    public static Player initOrT() {
        Player orT = new Player("Or Shilon");
        PlayoffPicture orTBet = new PlayoffPicture(true);
        orTBet.getRound1()[0].setSeries(Constants.E18, 4, 1);
        orTBet.getRound1()[1].setSeries(Constants.E45, 4, 2);
        orTBet.getRound1()[2].setSeries(Constants.E36, 4, 1);
        orTBet.getRound1()[3].setSeries(Constants.E27, 4, 0);

        orTBet.getRound1()[4].setSeries(Constants.W18, 4, 0);
        orTBet.getRound1()[5].setSeries(Constants.W45, 4, 1);
        orTBet.getRound1()[6].setSeries(Constants.W36, 2, 4);
        orTBet.getRound1()[7].setSeries(Constants.W27, 4, 3);

        orTBet.getRound2()[0].setSeries(Constants.MIL, Constants.BOS, 4, 1);
        orTBet.getRound2()[1].setSeries(Constants.PHI, Constants.TOR, 2, 4);
        orTBet.getRound2()[2].setSeries(Constants.GS, Constants.HOU, 4, 2);
        orTBet.getRound2()[3].setSeries(Constants.OKC, Constants.DEN, 4, 2);

        orTBet.getConfFinals()[0].setSeries(Constants.MIL, Constants.TOR, 3, 4);
        orTBet.getConfFinals()[1].setSeries(Constants.GS, Constants.OKC, 4, 1);

        orTBet.getFinals().setSeries(Constants.TOR, Constants.GS, 2, 4);
        orT.setBet(orTBet);
        return orT;
    }

    public static Player initMatan() {
        Player matan = new Player("Matan Shavit");
        PlayoffPicture matanBet = new PlayoffPicture(true);
        matanBet.getRound1()[0].setSeries(Constants.E18, 4, 0);
        matanBet.getRound1()[1].setSeries(Constants.E45, 4, 2);
        matanBet.getRound1()[2].setSeries(Constants.E36, 4, 1);
        matanBet.getRound1()[3].setSeries(Constants.E27, 4, 0);

        matanBet.getRound1()[4].setSeries(Constants.W18, 4, 0);
        matanBet.getRound1()[5].setSeries(Constants.W45, 4, 2);
        matanBet.getRound1()[6].setSeries(Constants.W36, 3, 4);
        matanBet.getRound1()[7].setSeries(Constants.W27, 4, 2);

        matanBet.getRound2()[0].setSeries(Constants.MIL, Constants.BOS, 4, 3);
        matanBet.getRound2()[1].setSeries(Constants.PHI, Constants.TOR, 1, 4);
        matanBet.getRound2()[2].setSeries(Constants.GS, Constants.HOU, 4, 2);
        matanBet.getRound2()[3].setSeries(Constants.OKC, Constants.DEN, 2, 4);

        matanBet.getConfFinals()[0].setSeries(Constants.MIL, Constants.TOR, 2, 4);
        matanBet.getConfFinals()[1].setSeries(Constants.GS, Constants.DEN, 4, 0);

        matanBet.getFinals().setSeries(Constants.TOR, Constants.GS, 1, 4);
        matan.setBet(matanBet);
        return matan;
    }

    public static Player initTom() {
        Player tom = new Player("Tom Sanderovich");
        PlayoffPicture tomBet = new PlayoffPicture(true);
        tomBet.getRound1()[0].setSeries(Constants.E18, 4, 1);
        tomBet.getRound1()[1].setSeries(Constants.E45, 4, 2);
        tomBet.getRound1()[2].setSeries(Constants.E36, 4, 1);
        tomBet.getRound1()[3].setSeries(Constants.E27, 4, 0);

        tomBet.getRound1()[4].setSeries(Constants.W18, 4, 1);
        tomBet.getRound1()[5].setSeries(Constants.W45, 4, 2);
        tomBet.getRound1()[6].setSeries(Constants.W36, 3, 4);
        tomBet.getRound1()[7].setSeries(Constants.W27, 4, 1);

        tomBet.getRound2()[0].setSeries(Constants.MIL, Constants.BOS, 4, 3);
        tomBet.getRound2()[1].setSeries(Constants.PHI, Constants.TOR, 2, 4);
        tomBet.getRound2()[2].setSeries(Constants.GS, Constants.HOU, 4, 2);
        tomBet.getRound2()[3].setSeries(Constants.OKC, Constants.DEN, 3, 4);

        tomBet.getConfFinals()[0].setSeries(Constants.MIL, Constants.TOR, 4, 3);
        tomBet.getConfFinals()[1].setSeries(Constants.GS, Constants.DEN, 4, 1);

        tomBet.getFinals().setSeries(Constants.MIL, Constants.GS, 2, 4);
        tom.setBet(tomBet);
        return tom;
    }

    public PlayoffPicture getBet() {
        return bet;
    }

    public void setBet(PlayoffPicture bet) {
        this.bet = bet;
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

    public void resetWins() {
        setWins(0);
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Player other) {
        return other.getWins() - this.wins;
    }
}
