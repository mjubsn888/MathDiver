package model;

import java.util.ArrayList;

public class ToolArrayList {


    public static int getNbrOfContinuousTrueValue(ArrayList<Boolean> listBoolean) {

        ArrayList<Boolean> listBooleanReversed = new ArrayList<>();
        for (int i = listBoolean.size() - 1; i >= 0; i--) {
            listBooleanReversed.add(listBoolean.get(i));
        }
        int size = listBooleanReversed.size();

        if (size == 0) {
            return size;
        }

        int total = 0;

        for (boolean b : listBooleanReversed) {
            if (b) {
                total += 1;
            } else {
                break;
            }
        }
        return total;
    }



}
