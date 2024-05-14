public class MakeColours {
    public static float[] getComplimentaryColour(float [] hsv){
        float h = hsv[0];
        h *= 360;

        float[] complimentaryHSV = new float [3];
        if(h <= 180){
            h += 180.0;
        } else {
            h -= 180.0;
        }

        Utilities.fillArray(complimentaryHSV, h, hsv[1], hsv[2]);
        return complimentaryHSV;
    }

    public static float[] getTriadicColour(float[] hsv, boolean subtract){
        float h = hsv[0];

        h *= 360;

        float[] triadicHSV = new float[3];

        if(subtract){
            h -= 120;
            if(h <= 0){
                h += 360;
            }
        } else {
            h += 120;
            if(h >= 360){
                h -= 360;
            }
        }

        Utilities.fillArray(triadicHSV, h, hsv[1], hsv[2]);
        return triadicHSV;
    }


    public static float[] getAnalogousColour(float[] hsv, boolean isComp, boolean subtract){
        float h = hsv[0];
        if(!isComp){
            h *= 360;
        }

        if(subtract){
            h -= 30;
            if(h <= 0){
                h += 360;
            }
        } else {
            h += 30;
            if(h >= 360){
                h -= 360;
            }
        }

        float[] analogousHSV = new float[3];
        Utilities.fillArray(analogousHSV, h, hsv[1], hsv[2]);

        return analogousHSV;
    }


    public static float[] getMonochromaticColour(float[] hsv, boolean subtract){
        float s = hsv[1];

        s *= 100;

        float[] monochromaticColour = new float[3];
        if(subtract){
            if(s > 10){
                s -= 10;
            } else {
                s = 0;
            }
        } else {
            if(s <= 90){
                s += 10;
            } else {
                s = 100;
            }
        }

        System.out.println(s);
        Utilities.fillArray(monochromaticColour, hsv[0], s / 100, hsv[2]);
        return monochromaticColour;
    }
}
