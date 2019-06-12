import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    static final int DELAY_ROUND = 1000;
    static final int DELAY_PRINT = 100;
    static final String DATE = "11/6/19";

    public static void main(String[] args) throws Exception {
        long simulationStart, simulationEnd, simulationTotal;
        int min, sec;
        Player[] players = initPlayers();

        PlayoffPicture picture = new PlayoffPicture(false);
        System.out.println("Date: " + DATE);
        System.out.println(picture);

        simulationStart = System.currentTimeMillis();
        ArrayList<PlayoffPicture> firstRound = startFirstRoundSimulation();
        calculateScore(firstRound, players);
        printResult(firstRound, players);

        simulationEnd = System.currentTimeMillis();
        simulationTotal = simulationEnd - simulationStart;
        min = (int) (simulationTotal / 1000 / 60);
        sec = (int) ((simulationTotal / 1000) % 60);
        System.out.println("\nsimulation time: " + min + "m " + sec + "s");
        resetWins(players);
        sleep(DELAY_ROUND);

        simulationStart = System.currentTimeMillis();
        ArrayList<PlayoffPicture> secondRound = startSecondRoundSimulation(firstRound);
        calculateScore(secondRound, players);
        printResult(secondRound, players);

        simulationEnd = System.currentTimeMillis();
        simulationTotal = simulationEnd - simulationStart;
        min = (int) (simulationTotal / 1000 / 60);
        sec = (int) ((simulationTotal / 1000) % 60);
        System.out.println("\nsimulation time: " + min + "m " + sec + "s");
        resetWins(players);
        sleep(DELAY_ROUND);

        simulationStart = System.currentTimeMillis();
        ArrayList<PlayoffPicture> conFinals = startConfSimulation(secondRound);
        calculateScore(conFinals, players);
        printResult(conFinals, players);

        simulationEnd = System.currentTimeMillis();
        simulationTotal = simulationEnd - simulationStart;
        min = (int) (simulationTotal / 1000 / 60);
        sec = (int) ((simulationTotal / 1000) % 60);
        System.out.println("\nsimulation time: " + min + "m " + sec + "s");
        resetWins(players);
        sleep(DELAY_ROUND);

        simulationStart = System.currentTimeMillis();
        ArrayList<PlayoffPicture> finals = startFinalsSimulation(conFinals);
        calculateScore(finals, players);
        printResult(finals, players);

        simulationEnd = System.currentTimeMillis();
        simulationTotal = simulationEnd - simulationStart;
        min = (int) (simulationTotal / 1000 / 60);
        sec = (int) ((simulationTotal / 1000) % 60);
        System.out.println("\nsimulation time: " + min + "m " + sec + "s");
        resetWins(players);
        sleep(DELAY_ROUND);
    }

    private static void resetWins(Player[] players) {
        for (Player player : players) {
            player.resetWins();
        }
    }

    private static ArrayList<PlayoffPicture> startFirstRoundSimulation() {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        ArrayList<PlayoffPicture> firstRound = new ArrayList<>();
        long count = 0, lastSize = 0;
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
                                            firstRound.add(picture);
                                        }
                                        count++;
                                        if (count % 100000 == 0) {
                                            if (lastSize != firstRound.size()) {
                                                System.out.printf("%s%s%.2f%s\n", formatter.format(firstRound.size()), " possible options (", (count / Math.pow(8, 8) * 100), "%).");
                                                lastSize = firstRound.size();
                                                //System.out.println("Free Memory Left: " + Runtime.getRuntime().freeMemory());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }//end of 1st round simulation loops

        System.out.println("\n1st round simulation has done with " + formatter.format(firstRound.size()) + " possible options.\n");

        return firstRound;
    }

    private static ArrayList<PlayoffPicture> startSecondRoundSimulation(ArrayList<PlayoffPicture> firstRound) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        ArrayList<PlayoffPicture> secondRound = new ArrayList<>();
        long count = 0, lastSize = 0;

        for (PlayoffPicture sec : firstRound) {
            sec.qualifyTeams();
        }

        for (PlayoffPicture sec : firstRound) {
            for (int i9 = 1; i9 <= 8; i9++) {
                for (int i10 = 1; i10 <= 8; i10++) {
                    for (int i11 = 1; i11 <= 8; i11++) {
                        for (int i12 = 1; i12 <= 8; i12++) {
                            PlayoffPicture picture = getNewOption(sec, i9, i10, i11, i12);
                            if (picture != null) {
                                secondRound.add(picture);
                            }
                            count++;
                            if (count % 100000 == 0) {
                                if (lastSize != secondRound.size()) {
                                    System.out.printf("%s%s%.2f%s\n", formatter.format(secondRound.size()), " possible options (", (count / (firstRound.size() * Math.pow(8, 4)) * 100), "%).");
                                    lastSize = secondRound.size();
                                    //System.out.println("Free Memory Left: " + Runtime.getRuntime().freeMemory());
                                }
                            }
                        }
                    }
                }
            }
        }//end of 2nd round simulation loops

        System.out.println("\n2nd round simulation has done with " + formatter.format(secondRound.size()) + " possible options.\n");

        return secondRound;
    }

    private static ArrayList<PlayoffPicture> startConfSimulation(ArrayList<PlayoffPicture> secondRound) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        ArrayList<PlayoffPicture> confRound = new ArrayList<>();
        long count = 0, lastSize = 0;

        for (PlayoffPicture sec : secondRound) {
            sec.qualifyTeams();
        }

        for (PlayoffPicture conf : secondRound) {
            for (int i13 = 1; i13 <= 8; i13++) {
                for (int i14 = 1; i14 <= 8; i14++) {
                    PlayoffPicture picture = getNewOption(conf, i13, i14);
                    if (picture != null) {
                        confRound.add(picture);
                    }
                    count++;
                    if (count % 100000 == 0) {
                        if (lastSize != confRound.size()) {
                            System.out.printf("%s%s%.2f%s\n", formatter.format(confRound.size()), " possible options (", (count / (secondRound.size() * Math.pow(8, 2)) * 100), "%).");
                            lastSize = confRound.size();
                            //System.out.println("Free Memory Left: " + Runtime.getRuntime().freeMemory());
                        }
                    }
                }
            }
        }//end of conFinals round simulation loops

        System.out.println("\nconfFinals round simulation has done with " + formatter.format(confRound.size()) + " possible options.\n");

        return confRound;
    }

    private static ArrayList<PlayoffPicture> startFinalsSimulation(ArrayList<PlayoffPicture> confRound) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        ArrayList<PlayoffPicture> finalsRound = new ArrayList<>();
        long count = 0, lastSize = 0;

        for (PlayoffPicture sec : confRound) {
            sec.qualifyTeams();
        }

        for (PlayoffPicture finals : confRound) {
            for (int i15 = 1; i15 <= 8; i15++) {
                PlayoffPicture picture = getNewOption(finals, i15);
                if (picture != null) {
                    finalsRound.add(picture);
                }
                count++;
                if (count % 100000 == 0) {
                    if (lastSize != finalsRound.size()) {
                        System.out.printf("%s%s%.2f%s\n", formatter.format(finalsRound.size()), " possible options (", (count / (confRound.size() * Math.pow(8, 1)) * 100), "%).");
                        lastSize = finalsRound.size();
                        //System.out.println("Free Memory Left: " + Runtime.getRuntime().freeMemory());
                    }
                }
            }//end of finals round simulation loops
        }

        System.out.println("\nfinals round simulation has done with " + formatter.format(finalsRound.size()) + " possible options.\n");

        return finalsRound;
    }

    public static PlayoffPicture getNewOption(PlayoffPicture finals, int i15) {
        boolean flag;
        PlayoffPicture picture = new PlayoffPicture(false);
        picture.setPicture(finals);

        //finals
        flag = picture.getFinals().setSeries(i15);
        if (!flag) {
            return null;
        }

        return picture;
    }

    public static PlayoffPicture getNewOption(PlayoffPicture conf, int i13, int i14) {
        boolean flag;
        PlayoffPicture picture = new PlayoffPicture(false);
        picture.setPicture(conf);

        //conFinals
        flag = picture.getConfFinals()[0].setSeries(i13);
        if (!flag) {
            return null;
        }
        //conFinals
        flag = picture.getConfFinals()[1].setSeries(i14);
        if (!flag) {
            return null;
        }

        return picture;
    }

    private static PlayoffPicture getNewOption(PlayoffPicture sec, int i9, int i10, int i11, int i12) {
        boolean flag;
        PlayoffPicture picture = new PlayoffPicture(false);
        picture.setPicture(sec);

        //round2
        flag = picture.getRound2()[0].setSeries(i9);
        if (!flag) {
            return null;
        }
        //round2
        flag = picture.getRound2()[1].setSeries(i10);
        if (!flag) {
            return null;
        }
        //round2
        flag = picture.getRound2()[2].setSeries(i11);
        if (!flag) {
            return null;
        }
        //round2
        flag = picture.getRound2()[3].setSeries(i12);
        if (!flag) {
            return null;
        }

        return picture;
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

    private static void calculateScore(ArrayList<PlayoffPicture> options, Player[] players) {
        System.out.println("Calculating results...\n");

        for (PlayoffPicture option : options) {
            calculate(option, players);
        }
    }

    private static void printResult(ArrayList<PlayoffPicture> options, Player[] players) throws Exception {
        int numOfWins = 0;
        List<Player> sortedPlayers = new ArrayList<>();
        for (Player player : players) {
            numOfWins += player.getWins();
            sortedPlayers.add(player);
        }

        Collections.sort(sortedPlayers);

        DecimalFormat formatter = new DecimalFormat("#,###,###");
        for (Player player : sortedPlayers) {
            System.out.printf("%-15s wins = %-9s%s%.2f%s\n", player, formatter.format(player.getWins()),
                    " - ", player.getWins() / (double) options.size() * 100, "%");
            sleep(DELAY_PRINT);
        }
        sleep(DELAY_PRINT);
        System.out.printf("Total = %.2f%s\n", numOfWins / (double) options.size() * 100, "%");
    }

    private static void calculate(PlayoffPicture picture, Player[] players) {
        picture.qualifyTeams();
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
            ArrayList<Player> winners = new ArrayList<>();
            int max = 0;
            for (Player player : players) {
                if (player.getScore() > max) {
                    winners.clear();
                    max = player.getScore();
                    winners.add(player);
                } else if (player.getScore() == max) {
                    winners.add(player);
                }
            }

            //add win to players with highest score
            for (Player winner : winners) {
                winner.addWin();
            }
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
        Player[] players = new Player[7];
        players[0] = Player.initGuy();
        players[1] = Player.initOren();
        players[2] = Player.initMaman();
        players[3] = Player.initRittner();
        players[4] = Player.initOrT();
        players[5] = Player.initMatan();
        players[6] = Player.initTom();
        return players;
    }

    private static void sleep(int time) throws Exception {
        TimeUnit.MILLISECONDS.sleep(time);
    }

}
