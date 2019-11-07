public class Series {
    private Team team1, team2;
    private int team1Wins, team2Wins;

    public Series(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        team1Wins = 0;
        team2Wins = 0;
    }

    public Series() {
        this(new Team(), new Team());
    }

    public Series(Series series) {
        this(series.getTeam1(), series.getTeam2());
    }

    public static int compareSeries(Series picture, Series bet, int round) {
        int score = 0;
        boolean flag = false;

        switch (round) {
            case 1:
                //round1
                if ((bet.getTeam1Wins() + picture.getTeam1Wins() == 8 && bet.getTeam1().equals(picture.getTeam1())) ||
                        (bet.getTeam2Wins() + picture.getTeam2Wins() == 8 && bet.getTeam2().equals(picture.getTeam2()))) {
                    score += 2;
                    flag = true;
                }
                if (flag && bet.getTeam1Wins() == picture.getTeam1Wins() && bet.getTeam2Wins() == picture.getTeam2Wins()
                        && bet.getTeam1().equals(picture.getTeam1()) && bet.getTeam2().equals(picture.getTeam2())) {
                    score += 2;
                }
                break;
            case 2:
                //round2
                if ((bet.getTeam1Wins() + picture.getTeam1Wins() == 8 && bet.getTeam1().equals(picture.getTeam1())) ||
                        (bet.getTeam2Wins() + picture.getTeam2Wins() == 8 && bet.getTeam2().equals(picture.getTeam2()))) {
                    score += 3;
                    flag = true;
                }
                if (flag && bet.getTeam1Wins() == picture.getTeam1Wins() && bet.getTeam2Wins() == picture.getTeam2Wins()
                        && bet.getTeam1().equals(picture.getTeam1()) && bet.getTeam2().equals(picture.getTeam2())) {
                    score += 2;
                }
                break;
            case 3:
                //confFinals
                if ((bet.getTeam1Wins() + picture.getTeam1Wins() == 8 && bet.getTeam1().equals(picture.getTeam1())) ||
                        (bet.getTeam2Wins() + picture.getTeam2Wins() == 8 && bet.getTeam2().equals(picture.getTeam2()))) {
                    score += 4;
                    flag = true;
                }
                if (flag && bet.getTeam1Wins() == picture.getTeam1Wins() && bet.getTeam2Wins() == picture.getTeam2Wins()
                        && bet.getTeam1().equals(picture.getTeam1()) && bet.getTeam2().equals(picture.getTeam2())) {
                    score += 2;
                }
                break;
            case 4:
                //finals
                if ((bet.getTeam1Wins() + picture.getTeam1Wins() == 8 && bet.getTeam1().equals(picture.getTeam1())) ||
                        (bet.getTeam2Wins() + picture.getTeam2Wins() == 8 && bet.getTeam2().equals(picture.getTeam2()))) {
                    score += 4;
                    flag = true;
                }
                if (flag && bet.getTeam1Wins() == picture.getTeam1Wins() && bet.getTeam2Wins() == picture.getTeam2Wins()
                        && bet.getTeam1().equals(picture.getTeam1()) && bet.getTeam2().equals(picture.getTeam2())) {
                    score += 3;
                }

                if (flag) {
                    if (bet.getTeam2Wins() + picture.getTeam2Wins() == 8 && bet.getTeam2().toString().equals(Constants.GS.toString())) {
                        score += 3;
                    } else {
                        score += 7;
                    }
                }
                break;
            default:
                break;
        }
        return score;
    }

    public void setSeriesTeams(Team team1Wins, Team team2Wins) {
        this.team1 = team1Wins;
        this.team2 = team2Wins;
    }

    public void setSeries(Team team1, Team team2, int team1Wins, int team2Wins) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Wins = team1Wins;
        this.team2Wins = team2Wins;
    }

    public void setSeries(Series series, int team1Wins, int team2Wins) {
        this.setSeries(series.getTeam1(), series.getTeam2(), team1Wins, team2Wins);
    }

    public void setSeries(Series series) {
        this.setSeries(series.getTeam1(), series.getTeam2(), series.getTeam1Wins(), series.getTeam2Wins());
    }

    public boolean setSeries(int magicNum) {
        switch (magicNum) {
            case 1:
                if (this.isSeriesDone()) {
                    return team1Wins == 4 && team2Wins == 0;
                } else {
                    if (team2Wins == 0) {
                        team1Wins = 4;
                        return true;
                    } else {
                        return false;
                    }
                }
            case 2:
                if (this.isSeriesDone()) {
                    return team1Wins == 4 && team2Wins == 1;
                } else {
                    if (team2Wins <= 1) {
                        team1Wins = 4;
                        team2Wins = 1;
                        return true;
                    } else {
                        return false;
                    }
                }
            case 3:
                if (this.isSeriesDone()) {
                    return team1Wins == 4 && team2Wins == 2;
                } else {
                    if (team2Wins <= 2) {
                        team1Wins = 4;
                        team2Wins = 2;
                        return true;
                    } else {
                        return false;
                    }
                }
            case 4:
                if (this.isSeriesDone()) {
                    return team1Wins == 4 && team2Wins == 3;
                } else {
                    if (team2Wins <= 3) {
                        team1Wins = 4;
                        team2Wins = 3;
                        return true;
                    } else {
                        return false;
                    }
                }
            case 5:
                if (this.isSeriesDone()) {
                    return team1Wins == 0 && team2Wins == 4;
                } else {
                    if (team1Wins == 0) {
                        team2Wins = 4;
                        return true;
                    } else {
                        return false;
                    }
                }
            case 6:
                if (this.isSeriesDone()) {
                    return team1Wins == 1 && team2Wins == 4;
                } else {
                    if (team1Wins <= 1) {
                        team1Wins = 1;
                        team2Wins = 4;
                        return true;
                    } else {
                        return false;
                    }
                }
            case 7:
                if (this.isSeriesDone()) {
                    return team1Wins == 2 && team2Wins == 4;
                } else {
                    if (team1Wins <= 2) {
                        team1Wins = 2;
                        team2Wins = 4;
                        return true;
                    } else {
                        return false;
                    }
                }
            case 8:
                if (this.isSeriesDone()) {
                    return team1Wins == 3 && team2Wins == 4;
                } else {
                    if (team1Wins <= 3) {
                        team1Wins = 3;
                        team2Wins = 4;
                        return true;
                    } else {
                        return false;
                    }
                }
            default:
                return true;
        }
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Wins() {
        return team1Wins;
    }

    public int getTeam2Wins() {
        return team2Wins;
    }

    public Team getWinnerTeam() {
        if (team1Wins == 4) {
            return team1;
        } else if (team2Wins == 4) {
            return team2;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "{" + team1 + ":" + team1Wins + ", " + team2 + ":" + team2Wins + '}';
    }

    public boolean isSeriesDone() {
        return team1Wins == 4 || team2Wins == 4;
    }
}
