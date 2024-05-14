import java.awt.*;

public class ColourConversion {
    // For some reason on this, directly accessing the array caused issues to modifying the variables so I had to make new ones.

    public static String rgbToHSV(float[] hsv){
        float h = hsv[0];
        float s = hsv[1];
        float v = hsv[2];
        return String.format("%.1f%n, %.1f%n, %.1f%n", h * 360, s * 100, v * 100);
    }

    // I do not know if I will ever need these, but they will be kept around regardless.
    public static float[] rgbToCMYK(Color c) {
        float[] cmyk = new float[4];
        float key;
        float red = (float) c.getRed() / 255;
        float green = (float) c.getGreen() / 255;
        float blue = (float) c.getBlue() / 255;

        float max = Math.max(Math.max(red, green), blue);

        key = 1 - max;

        if (key == 1) {
            cmyk[0] = 0;
            cmyk[1] = 0;
            cmyk[2] = 0;
        } else {
            cmyk[0] = (1 - red - key) / (1 - key);
            cmyk[1] = (1 - green - key) / (1 - key);
            cmyk[2] = (1 - blue - key) / (1 - key);
        }

        cmyk[3] = key;
        return cmyk;
    }

    public static int[] cmykToRGB(float[] cmyk) {
        float key = cmyk[3];
        float value;
        int[] rgb = new int[3];

        /*
            Oh boy, this one is a beast.
            This first started as three or four lines of code total.
            I fully admit, I have no idea exactly what is going on with this bit of code (or, moreso why it is what it is).
            I adapted it from Javascript from W3colors.js

            255-((Math.min(1, ((cmyk[i] * (1 - key)) + key))) * 255)

            The middle bit, cmyk[i] * (1 - key) takes the value and multiples it by 1 - the key value.

            Afterwards, we take that and add the key.
            Then we take this number and use Math.min on this and 1. The result is multiplied by 255.
            Finally, this whole mess is subtracted from 255 and rounded to get an RGB value.
         */
        for( int i = 0; i < 3; i++){
            value = 255-((Math.min(1, ((cmyk[i] * (1 - key)) + key))) * 255);
            rgb[i] = Math.round(value);
        }

        return rgb;
    }

    public static void hexToRGB(String hex) {
        String hexCode;

        if (hex.startsWith("#")) {
            hexCode = hex.substring(1);
        } else {
            hexCode = hex;
        }

        if (hexCode.length() < 6) {
            System.out.println("too short");
        }

        String hexR = hexCode.substring(0, 2);
        String hexG = hexCode.substring(2, 4);
        String hexB = hexCode.substring(4);

        System.out.println(convertHexValue(hexR));
        System.out.println(convertHexValue(hexG));
        System.out.println(convertHexValue(hexB));


        System.out.println(hexCode);
    }

    public static int convertHexValue(String value) {
        int firstNum = getNumberValue(value.substring(0, 1));
        int secondNum = getNumberValue(value.substring(1, 2));

        return (firstNum * 16) + secondNum;
    }

    public static int getNumberValue(String value) {
        value = value.toUpperCase();
        int num = 0;

        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException nfe){
            switch (value) {
                case "A":
                    num = 10;
                    break;
                case "B":
                    num = 11;
                    break;
                case "C":
                    num = 12;
                    break;
                case "D":
                    num = 13;
                    break;
                case "E":
                    num = 14;
                    break;
                case "F":
                    num = 15;
                    break;
                default:
                    break;
            }
        }

        return num;
    }

    public static String rgbToHex(Color c){
        return String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
    }

}
