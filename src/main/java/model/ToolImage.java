package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ToolImage {

    ArrayList<ImageReference> listImageReference;

    public ToolImage() throws IOException {
        listImageReference=new ArrayList<>();

        try {
            listImageReference.add(new ImageReference("https://images2.imgbox.com/2b/b6/F2xYwcRP_o.jpg","background-test-1280x720.jpg"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/c2/18/x0rU3BH1_o.png","back-120x80.jpg"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/57/3f/FF5uhuk0_o.jpg","homepage-1280x720.jpg"));

            listImageReference.add(new ImageReference("https://images2.imgbox.com/b7/e2/4uDJ6cAi_o.png","porthole-k1-180x160.png"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/27/7e/hNkjOxu6_o.png","porthole-23-180x160.png"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/21/e3/VgBhwZxT_o.png","porthole-4-180x160.png"));

            listImageReference.add(new ImageReference("https://images2.imgbox.com/f3/f5/84zI2fbr_o.jpg","standard-k1-1280x720.jpg"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/2a/38/wI9ktsA8_o.jpg","standard-23-1280x720.jpg"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/33/bc/opvy8SBx_o.jpg","standard-4-1280x720.jpg"));
            
            listImageReference.add(new ImageReference("https://images2.imgbox.com/6e/2e/KC4qdwrS_o.png","background-tutorial-k1-1280x720.png"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/c7/fe/2HOVDODs_o.png","background-tutorial-23-1280x720.png"));
            listImageReference.add(new ImageReference("https://images2.imgbox.com/7f/ee/PSeneN3c_o.png","background-tutorial-4-1280x720.png"));
            
        } catch (Exception e) {

        }
    }

    public ArrayList<ImageReference> getListImageReference() {
        return listImageReference;
    }
}
