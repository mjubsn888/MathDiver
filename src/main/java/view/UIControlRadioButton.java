package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class UIControlRadioButton {

    public static String getSelectedRadioButtonText(ButtonGroup buttonGroup)
    {
        String s="";
        ArrayList<AbstractButton> listRadioButtons=Collections.list(buttonGroup.getElements());
        for (AbstractButton button:listRadioButtons){
            if(button.isSelected()){
                s=button.getText();
            }
        }
        return s;
    }

/*    public void disableRadioButtonGroup(ButtonGroup buttonGroup){

        for (int i = 0; i < buttonGroup.getButtonCount(); i++) {

            buttonGroup.
            buttonGroup.getElements()
        }

        jRadioButtonA.setEnabled(false);
        jRadioButtonB.setEnabled(false);
        jRadioButtonC.setEnabled(false);
        jRadioButtonD.setEnabled(false);
    }*/
}
