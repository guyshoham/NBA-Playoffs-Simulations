import java.util.Arrays;

public class PlayoffPicture {

    private Series[] round1, round2, confFinals;
    private Series finals;


    public PlayoffPicture(Boolean isBet) {
        this.round1 = new Series[8];
        round1[0] = new Series(Constants.E18);
        round1[1] = new Series(Constants.E45);
        round1[2] = new Series(Constants.E36);
        round1[3] = new Series(Constants.E27);
        round1[4] = new Series(Constants.W18);
        round1[5] = new Series(Constants.W45);
        round1[6] = new Series(Constants.W36);
        round1[7] = new Series(Constants.W27);
        this.round2 = new Series[4];
        round2[0] = new Series();
        round2[1] = new Series();
        round2[2] = new Series();
        round2[3] = new Series();
        this.confFinals = new Series[2];
        confFinals[0] = new Series();
        confFinals[1] = new Series();
        this.finals = new Series();
        if (!isBet) {
            editPlayoff();
        }
    }

    private void editPlayoff() {
        //edit to up-to-date playoff bracket

        //round1
        //MIL - DET
        round1[0].setSeries(Constants.E18, 4, 0);
        //BOS - IND
        round1[1].setSeries(Constants.E45, 4, 0);
        //PHI - BKN
        round1[2].setSeries(Constants.E36, 4, 1);
        //TOR - ORL
        round1[3].setSeries(Constants.E27, 4, 1);
        //GS - LAC
        round1[4].setSeries(Constants.W18, 4, 2);
        //HOU - UTA
        round1[5].setSeries(Constants.W45, 4, 1);
        //POR - OKC
        round1[6].setSeries(Constants.W36, 4, 1);
        //DEN - SA
        round1[7].setSeries(Constants.W27, 4, 3);

        //round2
        //MIL - BOS
        round2[0].setSeries(Constants.ESM1, 4, 1);
        //PHI - TOR
        round2[1].setSeries(Constants.ESM2, 3, 3);
        //GS - HOU
        round2[2].setSeries(Constants.WSM1, 4, 2);
        //POR - DEN
        round2[3].setSeries(Constants.WSM2, 3, 3);

        //confFinals
        //confFinals[0].setSeries(0, 0);
        //confFinals[1].setSeries(0, 0);

        //finals
        //finals.setSeries(0, 0);
    }

    public Series[] getRound1() {
        return round1;
    }

    public Series[] getRound2() {
        return round2;
    }

    public Series[] getConfFinals() {
        return confFinals;
    }

    public Series getFinals() {
        return finals;
    }

    public void qualifyTeams() {
        round2[0].setSeriesTeams(round1[0].getWinnerTeam(), round1[1].getWinnerTeam());
        round2[1].setSeriesTeams(round1[2].getWinnerTeam(), round1[3].getWinnerTeam());
        round2[2].setSeriesTeams(round1[4].getWinnerTeam(), round1[5].getWinnerTeam());
        round2[3].setSeriesTeams(round1[6].getWinnerTeam(), round1[7].getWinnerTeam());

        confFinals[0].setSeriesTeams(round2[0].getWinnerTeam(), round2[1].getWinnerTeam());
        confFinals[1].setSeriesTeams(round2[2].getWinnerTeam(), round2[3].getWinnerTeam());

        finals.setSeriesTeams(confFinals[0].getWinnerTeam(), confFinals[1].getWinnerTeam());
    }

    @Override
    public String toString() {
        String retVal = "";
        retVal += "PlayoffPicture{" +
                "\nround1=" + Arrays.toString(round1);
        if (round2[0].getTeam1().toString() != null || round2[0].getTeam2().toString() != null ||
                round2[1].getTeam1().toString() != null || round2[1].getTeam2().toString() != null||
                round2[2].getTeam1().toString() != null || round2[2].getTeam2().toString() != null||
                round2[3].getTeam1().toString() != null || round2[3].getTeam2().toString() != null) {
            retVal += "\nround2=" + Arrays.toString(round2);
        }
        if (confFinals[0].getTeam1().toString() != null || confFinals[0].getTeam2().toString() != null ||
                confFinals[1].getTeam1().toString() != null || confFinals[1].getTeam2().toString() != null) {
            retVal += "\nconfFinals=" + Arrays.toString(confFinals);
        }
        if (finals.getTeam1().toString() != null && finals.getTeam2().toString() != null) {
            retVal += "\nfinals=" + finals;
        }
        retVal += '}';

        return retVal;
    }

    public void setPicture(PlayoffPicture sec) {
        for (int i = 0; i < round1.length; i++) {
            round1[i].setSeries(sec.getRound1()[i]);
        }
        for (int i = 0; i < round2.length; i++) {
            round2[i].setSeries(sec.getRound2()[i]);
        }
        for (int i = 0; i < confFinals.length; i++) {
            confFinals[i].setSeries(sec.getConfFinals()[i]);
        }
        finals.setSeries(sec.getFinals());
    }
}
