package model;

public class MapDiffVarTyp {

    public static String mapIntegerToString(int i) {
        String s = "";

        if (i == 1) {
            s = "A";
        } else if (i == 2) {
            s = "B";
        } else if (i == 3) {
            s = "C";
        } else if (i == 4) {
            s = "D";
        } else {
            s = "";
        }
        return s;
    }
}


