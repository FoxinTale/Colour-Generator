import javax.swing.*;
import java.awt.*;

public class ColourConversion {
    public static String RGBHSV(float[] hsv){

        float h = hsv[0];
        float s = hsv[1];
        float v = hsv[2];
        return String.format("%.1f%n, %.1f%n, %.1f%n", h *= 360, s *= 100,v *= 100);
    }

    public static float[] getComplimentaryColour(float [] hsv){
        float h = hsv[0];
        h *= 360;

        float[] complimentaryHSV = new float [3];
        if(h <= 180){
            h += 180.0;
        } else {
            h -= 180.0;
        }

        complimentaryHSV[0] = h;
        complimentaryHSV[1] = hsv[1];
        complimentaryHSV[2] = hsv[2];

        return complimentaryHSV;
    }

    public static float[] getTriadicColourOne(float[] hsv){
        float h = hsv[0];
        h *= 360;

        float[] triadicHSVOne = new float[3];

        h += 120;
        if(h >= 360){
            h -= 360;
        }

        triadicHSVOne[0] = h;
        triadicHSVOne[1] = hsv[1];
        triadicHSVOne[2] = hsv[2];
        float s = triadicHSVOne[1] *= 100;
        float v = triadicHSVOne[2] *= 100;

        System.out.println(h + " , " + s + " , " + v);

        return triadicHSVOne;
    }

    public static float[] getTriadicColourTwo(float[] hsv){
        float h = hsv[0];
        h *= 360;

        float[] triadicHSVTwo = new float[3];

        h -= 120;
        if(h <= 0){
            h += 360;
        }

        triadicHSVTwo[0] = h;
        triadicHSVTwo[1] = hsv[1];
        triadicHSVTwo[2] = hsv[2];
        float s = triadicHSVTwo[1] *= 100;
        float v = triadicHSVTwo[2] *= 100;

        System.out.println(h + " , " + s + " , " + v);

        return triadicHSVTwo;
    }


    public static void fillColourInfo(JTextField rgbText, JTextField hexText,JTextField hsvText, JPanel colourPanel, float[] hsbValues){
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