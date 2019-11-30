package playoffs;

public class Constants {

    //Atlantic
    static final Team BOS = new Team("BOS");
    static final Team BKN = new Team("BKN");
    static final Team NY = new Team("NY");
    static final Team PHI = new Team("PHI");
    static final Team TOR = new Team("TOR");

    //Central
    static final Team CHI = new Team("CHI");
    static final Team CLE = new Team("CLE");
    static final Team DET = new Team("DET");
    static final Team IND = new Team("IND");
    static final Team MIL = new Team("MIL");

    //Southeast
    static final Team ATL = new Team("ATL");
    static final Team CHA = new Team("CHA");
    static final Team MIA = new Team("MIA");
    static final Team ORL = new Team("ORL");
    static final Team WAS = new Team("WAS");

    //Northwest
    static final Team DEN = new Team("DEN");
    static final Team MIN = new Team("MIN");
    static final Team OKC = new Team("OKC");
    static final Team POR = new Team("POR");
    static final Team UTA = new Team("UTA");

    //Pacific
    static final Team GS = new Team("GS");
    static final Team LAC = new Team("LAC");
    static final Team LAL = new Team("LAL");
    static final Team PHX = new Team("PHX");
    static final Team SAC = new Team("SAC");

    //Southwest
    static final Team DAL = new Team("DAL");
    static final Team HOU = new Team("HOU");
    static final Team MEM = new Team("MEM");
    static final Team NO = new Team("NO");
    static final Team SA = new Team("SA");

    //Standing
    static final Team EAST1 = MIL;
    static final Team EAST2 = TOR;
    static final Team EAST3 = PHI;
    static final Team EAST4 = BOS;
    static final Team EAST5 = IND;
    static final Team EAST6 = BKN;
    static final Team EAST7 = ORL;
    static final Team EAST8 = DET;
    static final Team WEST1 = GS;
    static final Team WEST2 = DEN;
    static final Team WEST3 = POR;
    static final Team WEST4 = HOU;
    static final Team WEST5 = UTA;
    static final Team WEST6 = OKC;
    static final Team WEST7 = SA;
    static final Team WEST8 = LAC;

    //Round 1
    static final Series E18 = new Series(EAST1, EAST8);
    static final Series E45 = new Series(EAST4, EAST5);
    static final Series E36 = new Series(EAST3, EAST6);
    static final Series E27 = new Series(EAST2, EAST7);
    static final Series W18 = new Series(WEST1, WEST8);
    static final Series W45 = new Series(WEST4, WEST5);
    static final Series W36 = new Series(WEST3, WEST6);
    static final Series W27 = new Series(WEST2, WEST7);

    //Round 2
    static final Series ESM1 = new Series(MIL, BOS);
    static final Series ESM2 = new Series(PHI, TOR);
    static final Series WSM1 = new Series(GS, HOU);
    static final Series WSM2 = new Series(POR, DEN);

    //ConFinals
    static final Series ECF = new Series(MIL, TOR);
    static final Series WCF = new Series(GS, POR);

    //Finals
    static final Series FINALS = new Series(TOR, GS);
}
