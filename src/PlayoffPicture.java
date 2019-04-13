import java.util.ArrayList;
import java.util.List;

public class PlayoffPicture {

    private List<Series> round1, round2, confFinals, finals;

    public PlayoffPicture(Boolean isBet) {
        this.round1 = new ArrayList<>();
        round1.add(new Series(Constants.E18));
        round1.add(new Series(Constants.E45));
        round1.add(new Series(Constants.E36));
        round1.add(new Series(Constants.E27));
        round1.add(new Series(Constants.W18));
        round1.add(new Series(Constants.W45));
        round1.add(new Series(Constants.W36));
        round1.add(new Series(Constants.W27));
        this.round2 = new ArrayList<>();
        round2.add(new Series());
        round2.add(new Series());
        round2.add(new Series());
        round2.add(new Series());
        this.confFinals = new ArrayList<>();
        confFinals.add(new Series());
        confFinals.add(new Series());
        this.finals = new ArrayList<>();
        finals.add(new Series());
        if (!isBet) {
            editPlayoff();
        }
    }

    private void editPlayoff() {
        //just temporary editing

        round1.get(0).setSeries(2, 0);
        round1.get(1).setSeries(2, 0);
        round1.get(2).setSeries(2, 0);
        round1.get(3).setSeries(2, 0);
        round1.get(4).setSeries(0, 2);
        round1.get(5).setSeries(2, 0);
        round1.get(6).setSeries(0, 2);
        round1.get(7).setSeries(0, 2);
    }

    public List<Series> getRound1() {
        return round1;
    }

    public List<Series> getRound2() {
        return round2;
    }

    public List<Series> getConfFinals() {
        return confFinals;
    }

    public List<Series> getFinals() {
        return finals;
    }

    public void qualifyTeams() {
        round2.get(0).setSeriesTeams(round1.get(0).getWinnerTeam(), round1.get(1).getWinnerTeam());
        round2.get(1).setSeriesTeams(round1.get(2).getWinnerTeam(), round1.get(3).getWinnerTeam());
        round2.get(2).setSeriesTeams(round1.get(4).getWinnerTeam(), round1.get(5).getWinnerTeam());
        round2.get(3).setSeriesTeams(round1.get(6).getWinnerTeam(), round1.get(7).getWinnerTeam());

        confFinals.get(0).setSeriesTeams(round2.get(0).getWinnerTeam(), round2.get(1).getWinnerTeam());
        confFinals.get(1).setSeriesTeams(round2.get(2).getWinnerTeam(), round2.get(3).getWinnerTeam());

        finals.get(0).setSeriesTeams(confFinals.get(0).getWinnerTeam(), confFinals.get(1).getWinnerTeam());
    }

    @Override
    public String toString() {
        return "PlayoffPicture{" +
                "\nround1=" + round1 +
                "\nround2=" + round2 +
                "\nconfFinals=" + confFinals +
                "\nfinals=" + finals +
                '}';
    }
}
