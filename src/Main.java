import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    public static final double OPTIONS = Math.pow(8, 8);


    public static void main(String[] args) {
        Player[] players = initPlayers();

        long simulationStart = System.currentTimeMillis();
        ArrayList<PlayoffPicture> options = startSimulation();
        long simulationEnd = System.currentTimeMillis();
        long simulationTotal = simulationEnd - simulationStart;

        long calculationStart = System.currentTimeMillis();
        calculateScore(options, players);
        long calculationEnd = System.currentTimeMillis();
        long calculationTotal = calculationEnd - calculationStart;

        printResult(players, options.size());
        System.out.println("\nsimulation time: " + simulationTotal / 1000 + "s");
        System.out.println("calculateScore time: " + calculationTotal / 1000 + "s");
    }

    private static ArrayList<PlayoffPicture> startSimulation() {
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

        return options;
    }

    private static void calculateScore(ArrayList<PlayoffPicture> options, Player[] players) {
        for (PlayoffPicture option : options) {
            calculate(option, players);
        }
    }

    private static void printResult(Player[] players, int optionsSize) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%-15s%s%-8s%s%.2f%s\n", players[i], " wins = ", formatter.format(players[i].getWins()),
                    " - ", players[i].getWins() / (double) optionsSize * 100, "%");
        }
    }

    public static PlayoffPicture getNewOption(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean flag;
        PlayoffPicture picture = new PlayoffPicture(false);

        //MIL - DET
        flag = picture.getRound1()[0].setSeries(i1);
        if (!flag) {
            return null;
        }
        //BOS - IND
        flag = picture.getRound1()[1].setSeries(i2);
        if (!flag) {
            return null;
        }
        //PHI - BKN
        flag = picture.getRound1()[2].setSeries(i3);
        if (!flag) {
            return null;
        }
        //TOR - ORL
        flag = picture.getRound1()[3].setSeries(i4);
        if (!flag) {
            return null;
        }
        //GS - LAC
        flag = picture.getRound1()[4].setSeries(i5);
        if (!flag) {
            return null;
        }
        //HOU - UTA
        flag = picture.getRound1()[5].setSeries(i6);
        if (!flag) {
            return null;
        }
        //POR - OKC
        flag = picture.getRound1()[6].setSeries(i7);
        if (!flag) {
            return null;
        }
        //DEN - SA
        flag = picture.getRound1()[7].setSeries(i8);


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

    private static void calculate(PlayoffPicture picture, Player[] players) {
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
        Player[] players = new Player[6];
        players[0] = Player.initGuy();
        players[1] = Player.initOren();
        players[2] = Player.initMaman();
        players[3] = Player.initRittner();
        players[4] = Player.initOrT();
        players[5] = Player.initTom();
        //todo: complete init shit
        //players[5] = Player.initMatan();
        //players[6] = Player.initTom();
        return players;
    }
}
