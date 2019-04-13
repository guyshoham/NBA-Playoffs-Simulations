import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    public static final double OPTIONS = Math.pow(8, 8);


    public static void main(String[] args) {
        Player[] players = initPlayers();
        startSimulation(players);
    }

    private static void startSimulation(Player[] players) {
        long startTimeSimulation = System.currentTimeMillis();
        ArrayList<PlayoffPicture> options = new ArrayList<>();
        int count = 0;
        for (int i1 = 1; i1 <= 8; i1++) {
            for (int i2 = 1; i2 <= 8; i2++) {
                for (int i3 = 1; i3 <= 8; i3++) {
                    for (int i4 = 1; i4 <= 8; i4++) {
                        for (int i5 = 1; i5 <= 8; i5++) {
                            for (int i6 = 1; i6 <= 8; i6++) {
                                for (int i7 = 1; i7 <= 8; i7++) {
                                    for (int i8 = 1; i8 <= 8; i8++) {
                                        PlayoffPicture picture = getNewOption(i1, i2, i3, i4, i5, i6, i7, i8);
                                        if (picture != null) {
                                            options.add(picture);
                                        }
                                        if (count % 100000 == 0) {
                                            System.out.printf("Simulating 1st round... %.2f%s\n", (count / OPTIONS * 100), "%");
                                            //System.out.println("Free Memory Left: " + Runtime.getRuntime().freeMemory());
                                        }
                                        count++;
                                        /*for (int i9 = 1; i9 <= 8; i9++) {
                                            for (int i10 = 1; i10 <= 8; i10++) {
                                                for (int i11 = 1; i11 <= 8; i11++) {
                                                    for (int i12 = 1; i12 <= 8; i12++) {
                                                        for (int i13 = 1; i13 <= 8; i13++) {
                                                            for (int i14 = 1; i14 <= 8; i14++) {
                                                                for (int i15 = 1; i15 <= 8; i15++) {
                                                                    options.add(getNewOption(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15));
                                                                    System.out.println(count);
                                                                    System.out.printf("%.2f%s\n", (count / Math.pow(8, 15)), "%");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }*/
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }//end of simulation loops

        DecimalFormat formatter = new DecimalFormat("#,###,###");
        int optionsSize = options.size();
        System.out.println("\n1st round simulation has done with " + formatter.format(optionsSize) + " possible options.\n");

        long startTimeCalculationScore = System.currentTimeMillis();
        for (PlayoffPicture option : options) {
            calculateScore(option, players);
        }
        long endTimeCalculationScore = System.currentTimeMillis();
        long totalTimeCalculationScore = endTimeCalculationScore - startTimeCalculationScore;

        System.out.printf("%-15s%-8s%s%.2f%s\n", "Guy wins = ", formatter.format(players[0].getWins()), " - ", players[0].getWins() / (double) optionsSize * 100, "%");
        System.out.printf("%-15s%-8s%s%.2f%s\n", "Oren wins = ", formatter.format(players[1].getWins()), " - ", players[1].getWins() / (double) optionsSize * 100, "%");
        System.out.printf("%-15s%-8s%s%.2f%s\n", "Maman wins = ", formatter.format(players[2].getWins()), " - ", players[2].getWins() / (double) optionsSize * 100, "%");
        System.out.printf("%-15s%-8s%s%.2f%s\n", "Rittner wins = ", formatter.format(players[3].getWins()), " - ", players[3].getWins() / (double) optionsSize * 100, "%");
        System.out.printf("%-15s%-8s%s%.2f%s\n", "OrT wins = ", formatter.format(players[4].getWins()), " - ", players[4].getWins() / (double) optionsSize * 100, "%");
        //System.out.printf("%-15s%-8s%s%.2f%s\n", "Matan wins = ", formatter.format(players[5].getWins()), " - ", players[5].getWins() / (double) optionsSize * 100, "%");
        //System.out.printf("%-15s%-8s%s%.2f%s\n", "Tom wins = ", formatter.format(players[6].getWins()), " - ", players[6].getWins() / (double) optionsSize * 100, "%");

        long endTimeSimulation = System.currentTimeMillis();
        long totalTimeSimulation = endTimeSimulation - startTimeSimulation;
        System.out.println("\nsimulation time: " + totalTimeSimulation / 1000 + "s");
        System.out.println("calculateScore time: " + totalTimeCalculationScore / 1000 + "s");
    }

    public static PlayoffPicture getNewOption(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean flag;
        PlayoffPicture picture = new PlayoffPicture(false);

        flag = picture.getRound1()[0].setSeries(i1);
        if (!flag)
            return null;
        flag = picture.getRound1()[1].setSeries(i2);
        if (!flag)
            return null;
        flag = picture.getRound1()[2].setSeries(i3);
        if (!flag)
            return null;
        flag = picture.getRound1()[3].setSeries(i4);
        if (!flag)
            return null;
        flag = picture.getRound1()[4].setSeries(i5);
        if (!flag)
            return null;
        flag = picture.getRound1()[6].setSeries(i7);
        if (!flag)
            return null;
        flag = picture.getRound1()[7].setSeries(i8);
        if (!flag)
            return null;
        flag = picture.getRound1()[5].setSeries(i6);

        if (flag) {
            return picture;
        } else {
            return null;
        }
    }

    public static PlayoffPicture getNewOption(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8,
                                              int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        PlayoffPicture picture = new PlayoffPicture(false);

        picture.getRound1()[0].setSeries(i1);
        picture.getRound1()[1].setSeries(i2);
        picture.getRound1()[2].setSeries(i3);
        picture.getRound1()[3].setSeries(i4);
        picture.getRound1()[4].setSeries(i5);
        picture.getRound1()[5].setSeries(i6);
        picture.getRound1()[6].setSeries(i7);
        picture.getRound1()[7].setSeries(i8);

        picture.getRound2()[0].setSeries(i9);
        picture.getRound2()[1].setSeries(i10);
        picture.getRound2()[2].setSeries(i11);
        picture.getRound2()[3].setSeries(i12);

        picture.getConfFinals()[0].setSeries(i13);
        picture.getConfFinals()[1].setSeries(i14);

        picture.getFinals().setSeries(i15);

        return picture;
    }

    private static void calculateScore(PlayoffPicture picture, Player[] players) {
        for (Player player : players) {
            for (int i = 0; i < 8; i++) {
                player.addScore(Series.compareSeries(picture.getRound1()[i], player.getBet().getRound1()[i], 1));
            }
            for (int i = 0; i < 4; i++) {
                player.addScore(Series.compareSeries(picture.getRound2()[i], player.getBet().getRound2()[i], 2));
            }
            for (int i = 0; i < 2; i++) {
                player.addScore(Series.compareSeries(picture.getConfFinals()[i], player.getBet().getConfFinals()[i], 3));
            }
            player.addScore(Series.compareSeries(picture.getFinals(), player.getBet().getFinals(), 4));
        }

        //check player with highest score
        if (!allZero(players)) {
            int max = 0, maxPlayer = 0;
            for (int i = 0; i < players.length; i++) {
                if (players[i].getScore() > max) {
                    max = players[i].getScore();
                    maxPlayer = i;
                }
            }

            //add win to player with highest score
            players[maxPlayer].addWin();
            //System.out.println("player[" + players.get(maxPlayer).getName() + "," + max + "]");
        }

        //reset players' score
        for (Player player : players) {
            player.resetScore();
        }
    }

    private static boolean allZero(Player[] players) {
        for (Player player : players) {
            if (player.getScore() != 0) {
                return false;
            }
        }
        return true;
    }

    private static Player[] initPlayers() {
        Player[] players = new Player[5];
        players[0] = (initGuy());
        players[1] = (initOren());
        players[2] = (initMaman());
        players[3] = (initRittner());
        players[4] = (initOrT());
        //todo: complete init shit
        //players[5] = (initMatan());
        //players[6] = (initTom());
        return players;
    }

    private static Player initGuy() {
        Player guy = new Player("Guy Shoham");
        PlayoffPicture guyBet = new PlayoffPicture(true);
        guyBet.getRound1()[0].setSeries(4, 0);
        guyBet.getRound1()[1].setSeries(4, 2);
        guyBet.getRound1()[2].setSeries(4, 1);
        guyBet.getRound1()[3].setSeries(4, 0);
        guyBet.getRound1()[4].setSeries(4, 0);
        guyBet.getRound1()[5].setSeries(4, 2);
        guyBet.getRound1()[6].setSeries(2, 4);
        guyBet.getRound1()[7].setSeries(4, 3);
        guyBet.qualifyTeams();
        guyBet.getRound2()[0].setSeries(4, 1);
        guyBet.getRound2()[1].setSeries(2, 4);
        guyBet.getRound2()[2].setSeries(4, 2);
        guyBet.getRound2()[3].setSeries(4, 2);
        guyBet.qualifyTeams();
        guyBet.getConfFinals()[0].setSeries(4, 3);
        guyBet.getConfFinals()[1].setSeries(4, 2);
        guyBet.qualifyTeams();
        guyBet.getFinals().setSeries(2, 4);
        guy.setBet(guyBet);
        return guy;
    }

    private static Player initOren() {
        Player oren = new Player("Oren Savir");
        PlayoffPicture orenBet = new PlayoffPicture(true);
        orenBet.getRound1()[0].setSeries(4, 0);
        orenBet.getRound1()[1].setSeries(4, 2);
        orenBet.getRound1()[2].setSeries(4, 1);
        orenBet.getRound1()[3].setSeries(4, 0);
        orenBet.getRound1()[4].setSeries(4, 1);
        orenBet.getRound1()[5].setSeries(4, 2);
        orenBet.getRound1()[6].setSeries(1, 4);
        orenBet.getRound1()[7].setSeries(4, 3);
        orenBet.qualifyTeams();
        orenBet.getRound2()[0].setSeries(4, 2);
        orenBet.getRound2()[1].setSeries(2, 4);
        orenBet.getRound2()[2].setSeries(4, 2);
        orenBet.getRound2()[3].setSeries(4, 3);
        orenBet.qualifyTeams();
        orenBet.getConfFinals()[0].setSeries(3, 4);
        orenBet.getConfFinals()[1].setSeries(4, 1);
        orenBet.qualifyTeams();
        orenBet.getFinals().setSeries(2, 4);
        oren.setBet(orenBet);
        return oren;
    }

    private static Player initMaman() {
        Player maman = new Player("Roy Maman");
        PlayoffPicture mamanBet = new PlayoffPicture(true);
        mamanBet.getRound1()[0].setSeries(4, 0);
        mamanBet.getRound1()[1].setSeries(4, 2);
        mamanBet.getRound1()[2].setSeries(4, 0);
        mamanBet.getRound1()[3].setSeries(4, 0);
        mamanBet.getRound1()[4].setSeries(4, 1);
        mamanBet.getRound1()[5].setSeries(4, 1);
        mamanBet.getRound1()[6].setSeries(4, 3);
        mamanBet.getRound1()[7].setSeries(2, 4);
        mamanBet.qualifyTeams();
        mamanBet.getRound2()[0].setSeries(4, 3);
        mamanBet.getRound2()[1].setSeries(2, 4);
        mamanBet.getRound2()[2].setSeries(4, 2);
        mamanBet.getRound2()[3].setSeries(4, 3);
        mamanBet.qualifyTeams();
        mamanBet.getConfFinals()[0].setSeries(2, 4);
        mamanBet.getConfFinals()[1].setSeries(4, 1);
        mamanBet.qualifyTeams();
        mamanBet.getFinals().setSeries(4, 1);
        maman.setBet(mamanBet);
        return maman;
    }

    private static Player initRittner() {
        Player rittner = new Player("Or Rittner");
        PlayoffPicture rittnerBet = new PlayoffPicture(true);
        rittnerBet.getRound1()[0].setSeries(4, 0);
        rittnerBet.getRound1()[1].setSeries(4, 3);
        rittnerBet.getRound1()[2].setSeries(4, 1);
        rittnerBet.getRound1()[3].setSeries(4, 0);
        rittnerBet.getRound1()[4].setSeries(4, 0);
        rittnerBet.getRound1()[5].setSeries(4, 2);
        rittnerBet.getRound1()[6].setSeries(2, 4);
        rittnerBet.getRound1()[7].setSeries(4, 3);
        rittnerBet.qualifyTeams();
        rittnerBet.getRound2()[0].setSeries(4, 1);
        rittnerBet.getRound2()[1].setSeries(3, 4);
        rittnerBet.getRound2()[2].setSeries(4, 2);
        rittnerBet.getRound2()[3].setSeries(4, 2);
        rittnerBet.qualifyTeams();
        rittnerBet.getConfFinals()[0].setSeries(2, 4);
        rittnerBet.getConfFinals()[1].setSeries(4, 1);
        rittnerBet.qualifyTeams();
        rittnerBet.getFinals().setSeries(2, 4);
        rittner.setBet(rittnerBet);
        return rittner;
    }

    private static Player initOrT() {
        Player orT = new Player("or shilon");
        PlayoffPicture orTBet = new PlayoffPicture(true);
        orTBet.getRound1()[0].setSeries(4, 1);
        orTBet.getRound1()[1].setSeries(4, 2);
        orTBet.getRound1()[2].setSeries(4, 1);
        orTBet.getRound1()[3].setSeries(4, 0);
        orTBet.getRound1()[4].setSeries(4, 0);
        orTBet.getRound1()[5].setSeries(4, 1);
        orTBet.getRound1()[6].setSeries(2, 4);
        orTBet.getRound1()[7].setSeries(4, 3);
        orTBet.qualifyTeams();
        orTBet.getRound2()[0].setSeries(4, 1);
        orTBet.getRound2()[1].setSeries(2, 4);
        orTBet.getRound2()[2].setSeries(4, 2);
        orTBet.getRound2()[3].setSeries(4, 2);
        orTBet.qualifyTeams();
        orTBet.getConfFinals()[0].setSeries(3, 4);
        orTBet.getConfFinals()[1].setSeries(4, 1);
        orTBet.qualifyTeams();
        orTBet.getFinals().setSeries(2, 4);
        orT.setBet(orTBet);
        return orT;
    }

    private static Player initMatan() {
        Player matan = new Player("Matan Shavit");
        PlayoffPicture matanBet = new PlayoffPicture(true);
        matanBet.getRound1()[0].setSeries(4, 1);
        matanBet.getRound1()[1].setSeries(4, 2);
        matanBet.getRound1()[2].setSeries(4, 1);
        matanBet.getRound1()[3].setSeries(4, 0);
        matanBet.getRound1()[4].setSeries(4, 0);
        matanBet.getRound1()[5].setSeries(4, 1);
        matanBet.getRound1()[6].setSeries(2, 4);
        matanBet.getRound1()[7].setSeries(4, 3);
        matanBet.qualifyTeams();
        matanBet.getRound2()[0].setSeries(4, 1);
        matanBet.getRound2()[1].setSeries(2, 4);
        matanBet.getRound2()[2].setSeries(4, 2);
        matanBet.getRound2()[3].setSeries(4, 2);
        matanBet.qualifyTeams();
        matanBet.getConfFinals()[0].setSeries(3, 4);
        matanBet.getConfFinals()[1].setSeries(4, 1);
        matanBet.qualifyTeams();
        matanBet.getFinals().setSeries(2, 4);
        matan.setBet(matanBet);
        return matan;
    }

    private static Player initTom() {
        Player tom = new Player("Tom Sanderovich");
        PlayoffPicture tomBet = new PlayoffPicture(true);
        tomBet.getRound1()[0].setSeries(4, 1);
        tomBet.getRound1()[1].setSeries(4, 2);
        tomBet.getRound1()[2].setSeries(4, 1);
        tomBet.getRound1()[3].setSeries(4, 0);
        tomBet.getRound1()[4].setSeries(4, 0);
        tomBet.getRound1()[5].setSeries(4, 1);
        tomBet.getRound1()[6].setSeries(2, 4);
        tomBet.getRound1()[7].setSeries(4, 3);
        tomBet.qualifyTeams();
        tomBet.getRound2()[0].setSeries(4, 1);
        tomBet.getRound2()[1].setSeries(2, 4);
        tomBet.getRound2()[2].setSeries(4, 2);
        tomBet.getRound2()[3].setSeries(4, 2);
        tomBet.qualifyTeams();
        tomBet.getConfFinals()[0].setSeries(3, 4);
        tomBet.getConfFinals()[1].setSeries(4, 1);
        tomBet.qualifyTeams();
        tomBet.getFinals().setSeries(2, 4);
        tom.setBet(tomBet);
        return tom;
    }
}
