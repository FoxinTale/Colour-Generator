import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GUI {
    public static int r;
    public static int g;
    public static int b;


    public static boolean customColourSelected;
    public static Color customColour;

    // So much of this GUI is split off into separate functions, mainly because it was starting to get too lengthy to comprehend for me.
    // And, being basically a lot of repeated code it helped.
    public static void createGUI(){
        customColourSelected = false;
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        window.setTitle("Colour Generator");

        float[] hsv = new float[3];

        Color panelColour =  Color.decode("#FFF0F5");

        JCheckBox useCustomColourOption = new JCheckBox("Use Custom Colour: ");

        JLabel primaryLabel = new JLabel("Primary Colour");
        JLabel primaryLabelTwo = new JLabel("Primary Colour: ");
        /*
        Indexes for the following arrays:
            0 - Primary colour.
            1 - Complimentary colour.
            2 - Triadic colour one.
            3 - Triadic colour two.
            4 - Analogous colour one.
            5 - Analogous colour two.
            6 - Split complimentary colour one.
            7 - Split complimentary colour two.
         */
        JTextField[] rgbTexts = new JTextField[8];
        JTextField[] hexTexts = new JTextField[8];
        JTextField[] hsvTexts = new JTextField[8];
        JPanel[] colourPanels = new JPanel[8];

        JPanel monoBaseColourPanel = new RoundedPanel(5);
        JPanel monoColourOnePanel = new RoundedPanel(5);
        JPanel monoColourTwoPanel = new RoundedPanel(5);
        JPanel monoColourThreePanel = new RoundedPanel(5);
        JPanel monoColourFourPanel = new RoundedPanel(5);

        JTextField monoBaseColourText = new JTextField();
        JTextField monoColourOneText = new JTextField();
        JTextField monoColourTwoText = new JTextField();
        JTextField monoColourThreeText = new JTextField();
        JTextField monoColourFourText = new JTextField();



        fillTextBoxArray(rgbTexts);
        fillTextBoxArray(hexTexts);
        fillTextBoxArray(hsvTexts);

        JButton generate = new JButton("Give me a colour!");
        JButton openPicker = new JButton("Pick Colour");

        // Main Labels
        primaryLabel.setBounds(55, 25, 100, 25);
        primaryLabelTwo.setBounds(900, 25, 100, 25);

        // I gave up trying to put these into a loop of some kind.
        // It's good enough for now. I've done enough code moving.
        // Maybe I'll revisit it later.

        /*
        If I were to put it into a sort of function, height is the only thing that stays the same. That is at 25.
        I also think I'll need to re-arrange how all the arrays are structured. Or change the way I structured the GUI.


         */
        rgbTexts[0].setBounds(100, 61, 100, 25);
        rgbTexts[1].setBounds(315, 61, 100, 25);
        rgbTexts[2].setBounds(100, 236, 100, 25);
        rgbTexts[3].setBounds(315, 236, 100, 25);
        rgbTexts[4].setBounds(530, 61, 100, 25);
        rgbTexts[5].setBounds(530, 236, 100, 25);
        rgbTexts[6].setBounds(735, 61, 100, 25);
        rgbTexts[7].setBounds(735, 236, 100, 25);

        hexTexts[0].setBounds(100, 96, 100, 25);
        hexTexts[1].setBounds(315, 96, 100, 25);
        hexTexts[2].setBounds(100, 271, 100, 25);
        hexTexts[3].setBounds(315, 271, 100, 25);
        hexTexts[4].setBounds(530, 96, 100, 25);
        hexTexts[5].setBounds(530, 271, 100, 25);
        hexTexts[6].setBounds(735, 96, 100, 25);
        hexTexts[7].setBounds(735, 271, 100, 25);

        hsvTexts[0].setBounds(100, 131, 110, 25);
        hsvTexts[1].setBounds(300, 131, 110, 25);
        hsvTexts[2].setBounds(100, 306, 110, 25);
        hsvTexts[3].setBounds(300, 306, 110, 25);
        hsvTexts[4].setBounds(520, 131, 110, 25);
        hsvTexts[5].setBounds(520, 306, 110, 25);
        hsvTexts[6].setBounds(730, 131, 110, 25);
        hsvTexts[7].setBounds(730, 306, 110, 25);

        generate.setBounds(15, 620, 740, 40);
        useCustomColourOption.setBounds(15, 165, 150, 25);

        int panelY = 23;
        for(int i = 0; i < 8; i++){
            colourPanels[i] = new RoundedPanel(5);
            colourPanels[i].setBounds(1050, panelY, 200, 30);
            window.add(colourPanels[i]);
            panelY += 35;
        }

        ActionListener generateDo = e -> {
            if(!customColourSelected){
                r = Generate.red();
                g = Generate.green();
                b = Generate.blue();
            } else {
                r = customColour.getRed();
                g = customColour.getGreen();
                b = customColour.getBlue();
            }

            String hex = String.format("#%02x%02x%02x", r, g, b);
            rgbTexts[0].setText("(" + r + " , " + g + " , " + b + ")");
            hexTexts[0].setText(hex);
            colourPanels[0].setBackground(Color.decode(hex));
            Color.RGBtoHSB(r, g, b, hsv);
            hsvTexts[0].setText(ColourConversion.rgbToHSV(hsv));


            // I could probably put these into a sort of multi-dimensional array and then put it in a loop. but uh...why.
            // That just seems painful and somewhat pointless to save just a few lines of code, when this already works.
            float[] compHSV = MakeColours.getComplimentaryColour(hsv);
            float[] triOneHSV = MakeColours.getTriadicColour(hsv, false);
            float[] triTwoHSV = MakeColours.getTriadicColour(hsv, true);
            float[] analogousOneHSV = MakeColours.getAnalogousColour(hsv, false, false);
            float[] analogousTwoHSV = MakeColours.getAnalogousColour(hsv, false, true);
            float[] splitCompOneHSV = MakeColours.getAnalogousColour(compHSV, true, false);
            float[] splitCompTwoHSV = MakeColours.getAnalogousColour(compHSV, true, true);

            Utilities.fillColourInfo(rgbTexts[1], hexTexts[1], hsvTexts[1], colourPanels[1], compHSV);
            Utilities.fillColourInfo(rgbTexts[2], hexTexts[2], hsvTexts[2], colourPanels[2], triOneHSV);
            Utilities.fillColourInfo(rgbTexts[3], hexTexts[3], hsvTexts[3], colourPanels[3], triTwoHSV);
            Utilities.fillColourInfo(rgbTexts[4], hexTexts[4], hsvTexts[4], colourPanels[4], analogousOneHSV);
            Utilities.fillColourInfo(rgbTexts[5], hexTexts[5], hsvTexts[5], colourPanels[5], analogousTwoHSV);
            Utilities.fillColourInfo(rgbTexts[6], hexTexts[6], hsvTexts[6], colourPanels[6], splitCompOneHSV);
            Utilities.fillColourInfo(rgbTexts[7], hexTexts[7], hsvTexts[7], colourPanels[7], splitCompTwoHSV);
        };

        ActionListener customColourDo = e -> {
            customColourSelected = useCustomColourOption.isSelected();

            if(customColourSelected){
                generate.setText("Give me information about this colour.");
                openPicker.setVisible(true);
            } else {
                generate.setText("Give me a colour.");
                openPicker.setVisible(false);
            }
        };

        ActionListener openPickerDo = e -> {
          if(customColourSelected){
           colourPicker(colourPanels[0], rgbTexts[0]);
          }
        };

        openPicker.setVisible(false);

        generate.addActionListener(generateDo);
        useCustomColourOption.addActionListener(customColourDo);
        openPicker.addActionListener(openPickerDo);

        window.add(primaryLabel);
        window.add(primaryLabelTwo);

        monoBaseColourPanel.setBounds(20, 375, 75,75);
        openPicker.setBounds(225, 167, 100, 20);

        drawLabelGrouping(window, 20, 60); // Primary Colour
        drawLabelGrouping(window, 232, 60); // Complimentary Colour
        drawLabelGrouping(window, 20, 235);
        drawLabelGrouping(window, 232, 235);
        drawLabelGrouping(window, 443, 60);
        drawLabelGrouping(window, 443, 235);
        drawLabelGrouping(window, 654, 60);
        drawLabelGrouping(window, 654, 235);

        drawAndSetTextBoxArray(window, rgbTexts, panelColour);
        drawAndSetTextBoxArray(window, hexTexts, panelColour);
        drawAndSetTextBoxArray(window, hsvTexts, panelColour);

        drawAnalogousLabels(window);
        drawTriadicLabels(window);
        drawCompLabels(window);

        // 23, 58, 93, 128, 163, 198, 233, 268, 303, 338, 373, 408, 443, 478, 513, 548
        drawPanelGrouping(window, 15, 23, panelColour); // Primary Colour
        drawPanelGrouping(window, 225, 23, panelColour); // Complimentary Colour
        drawPanelGrouping(window, 15, 198, panelColour); // Triadic Colour One
        drawPanelGrouping(window, 225, 198, panelColour); // Triadic Colour Two
        drawPanelGrouping(window, 435, 23, panelColour); // Analogous Colour One
        drawPanelGrouping(window, 435, 198, panelColour); // Analogous Colour Two
        drawPanelGrouping(window, 645, 23, panelColour); // Split Complimentary One
        drawPanelGrouping(window, 645, 198, panelColour); //Split Complimentary Two

        window.add(monoBaseColourPanel);
        window.add(useCustomColourOption);
        window.add(generate);
        window.add(openPicker);

        window.setSize(1280, 800);
        window.setResizable(false);
        window.setLayout(null);// using no layout managers
        window.setVisible(true);// making the frame visible
    }


    public static void drawTriadicLabels(JFrame window){
        JLabel triColourLabel1 = new JLabel("Triadic Colour One");
        JLabel triColourLabel1Two = new JLabel("Triadic Colour One: ");

        JLabel triColourLabel2 = new JLabel("Triadic Colour Two");
        JLabel triColourLabel2Two = new JLabel("Triadic Colour Two: ");

        triColourLabel1.setBounds(55, 200, 150, 25);
        triColourLabel2.setBounds(265, 200, 150, 25);
        triColourLabel1Two.setBounds(900, 95, 150, 25);
        triColourLabel2Two.setBounds(900, 130, 150, 25);

        window.add(triColourLabel1);
        window.add(triColourLabel1Two);
        window.add(triColourLabel2);
        window.add(triColourLabel2Two);
    }
    public static void drawAnalogousLabels(JFrame window){
        JLabel analogousColourLabel1 = new JLabel("Analogous Colour One");
        JLabel analogousColourLabel1Two = new JLabel("Analogous Colour One: ");

        JLabel analogousColourLabel2 = new JLabel("Analogous Colour Two");
        JLabel analogousColourLabel2Two = new JLabel("Analogous Colour Two: ");

        analogousColourLabel1.setBounds(470, 25, 150, 25);
        analogousColourLabel2.setBounds(470, 200, 150, 25);

        analogousColourLabel1Two.setBounds(900, 165, 150, 25);
        analogousColourLabel2Two.setBounds(900, 200, 150, 25);

        window.add(analogousColourLabel1);
        window.add(analogousColourLabel1Two);
        window.add(analogousColourLabel2);
        window.add(analogousColourLabel2Two);
    }

    public static void drawCompLabels(JFrame window){
        JLabel complimentaryLabel = new JLabel("Complimentary Colour");
        JLabel complimentaryLabelTwo = new JLabel("Complimentary Colour: ");

        JLabel splitCompColourLabel1 = new JLabel("Split Complimentary 1");
        JLabel splitCompColourLabel1Two = new JLabel("Split Complimentary 1: ");

        JLabel splitCompColourLabel2 = new JLabel("Split Complimentary 2");
        JLabel splitCompColourLabel2Two = new JLabel("Split Complimentary 2: ");

        complimentaryLabel.setBounds(265, 25, 150, 25);
        splitCompColourLabel1.setBounds(675, 25, 150, 25);
        splitCompColourLabel2.setBounds(675, 200, 150, 25);
        complimentaryLabelTwo.setBounds(900, 60, 150, 25);
        splitCompColourLabel1Two.setBounds(900, 235, 150, 25);
        splitCompColourLabel2Two.setBounds(900, 270, 150, 25);

        window.add(complimentaryLabel);
        window.add(complimentaryLabelTwo);
        window.add(splitCompColourLabel1);
        window.add(splitCompColourLabel1Two);
        window.add(splitCompColourLabel2);
        window.add(splitCompColourLabel2Two);
    }

    public static void drawLabelGrouping(JFrame window, int startX, int startY){
        JLabel[] labels = new JLabel[3];

        labels[0] = new JLabel("RGB Value: ");
        labels[1] = new JLabel("Hex Value: ");
        labels[2] = new JLabel("HSB Value: ");
        int posY = startY;

        for (JLabel label : labels) {
            label.setBounds(startX, posY, 75, 25);
            posY += 35;
            window.add(label);
        }
    }

    public static void fillTextBoxArray(JTextField[] texts){
        for( int  i = 0; i < 8; i++){
            texts[i] = new JTextField();
        }
    }

    public static void drawAndSetTextBoxArray(JFrame window, JTextField[] texts, Color panelColour){
        for(int i = 0; i < 8; i++){
            texts[i].setEditable(false);
            texts[i].setBackground(panelColour);
            texts[i].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            window.add(texts[i]);
        }
    }

    public static void drawPanelGrouping(JFrame window, int startX, int startY, Color panelColour){
        JPanel[] panels = new JPanel[4];
        int posY = startY;
        for(int i = 0; i < panels.length; i++){
            panels[i] = new RoundedPanel(5, panelColour);
            panels[i].setBounds(startX, posY, 200, 30);
            posY += 35;
            window.add(panels[i]);
        }
    }

    public static void colourPicker(JPanel colourPanel, JTextField colourText) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        JColorChooser colourPicker = new JColorChooser();
        colourPicker.setBounds(5, 5, 600, 320);
        AbstractColorChooserPanel[] accp = colourPicker.getChooserPanels();

        colourPicker.removeChooserPanel(accp[0]);
        colourPicker.removeChooserPanel(accp[1]);
        colourPicker.removeChooserPanel(accp[2]);
        colourPicker.removeChooserPanel(accp[accp.length - 1]);
        colourPicker.setPreviewPanel(new JPanel());

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                customColour = colourPicker.getColor();
                colourPanel.setBackground(customColour);
                colourText.setText(ColourConversion.rgbToHex(customColour));
            }
        });

        window.add(colourPicker);

        window.setSize(720, 320);
        window.setResizable(false);
        window.setLayout(null);// using no layout managers
        window.setVisible(true);// making the frame visible
    }
}
