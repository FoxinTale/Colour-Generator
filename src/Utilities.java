import javax.swing.*;
import java.awt.*;

public class Utilities {
    public static void fillArray(float[] hsv, float h, float s, float v){
        hsv[0] = h;
        hsv[1] = s;
        hsv[2] = v;
    }


    // HSV and HSB are apparently the same thing, but "hsvValues" looked strange.
    public static void fillColourInfo(JTextField rgbText, JTextField hexText, JTextField hsvText, JPanel colourPanel, float[] hsbValues){
        Color colour = new Color(Color.HSBtoRGB(hsbValues[0] / 360, hsbValues[1], hsbValues[2]));
        int r = colour.getRed();
        int g = colour.getGreen();
        int b = colour.getBlue();

        String hex = String.format("#%02x%02x%02x", r, g, b);
        rgbText.setText("(" + r + " , " + g + " , " + b + ")");
        hexText.setText(hex);
        hsvText.setText(String.format("%.1f%n, %.1f%n, %.1f%n", hsbValues[0], hsbValues[1] *= 100,hsbValues[2] *= 100));
        colourPanel.setBackground(Color.decode(hex));
    }
}
