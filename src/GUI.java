import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    public static int r;
    public static int g;
    public static int b;

    public static boolean customColourSelected;
    public static void createGUI(){
        customColourSelected = false;
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        window.setTitle("Colour Generator");
        ArrayList<JTextField> textBoxes = new ArrayList<>();

        float[] hsv = new float[3];

        Color panelColour =  Color.decode("#FFF0F5");

        JCheckBox useCustomColourOption = new JCheckBox("Use Custom Colour: ");

        JLabel primaryLabel = new JLabel("Primary Colour");
        JLabel primaryLabelTwo = new JLabel("Primary Colour: ");

        JLabel complimentaryLabel = new JLabel("Complimentary Colour");
        JLabel complimentaryLabelTwo = new JLabel("Complimentary Colour: ");

        JLabel triColourLabel1 = new JLabel("Triadic Colour One");
        JLabel triColourLabel1Two = new JLabel("Triadic Colour One: ");

        JLabel triColourLabel2 = new JLabel("Triadic Colour Two");
        JLabel triColourLabel2Two = new JLabel("Triadic Colour Two: ");

        JLabel analogousColourLabel1 = new JLabel("Analogous Colour One");
        JLabel analogousColourLabel1Two = new JLabel("Analogous Colour One: ");

        JLabel analogousColourLabel2 = new JLabel("Analogous Colour Two");
        JLabel analogousColourLabel2Two = new JLabel("Analogous Colour Two: ");

        JLabel splitCompColourLabel1 = new JLabel("Split Complimentary 1");
        JLabel splitCompColourLabel1Two = new JLabel("Split Complimentary 1: ");

        JLabel splitCompColourLabel2 = new JLabel("Split Complimentary 2");
        JLabel splitCompColourLabel2Two = new JLabel("Split Complimentary 2: ");

        JPanel colourPanel = new RoundedPanel(5);
        JPanel colourCompPanel = new RoundedPanel(5);
        JPanel colourTriOnePanel = new RoundedPanel(5);
        JPanel colourTriTwoPanel = new RoundedPanel(5);
        JPanel colourAnalogousOnePanel = new RoundedPanel(5);
        JPanel colourAnalogousTwoPanel = new RoundedPanel(5);
        JPanel colourSplitCompOnePanel = new RoundedPanel(5);
        JPanel colourSplitCompTwoPanel = new RoundedPanel(5);


        JTextField rgbText = new JTextField();
        JTextField rgbCompText = new JTextField();
        JTextField rgbTriOneText = new JTextField();
        JTextField rgbTriTwoText = new JTextField();
        JTextField rgbAnalogousOneText = new JTextField();
        JTextField rgbAnalogousTwoText = new JTextField();
        JTextField rgbSplitCompColourOneText = new JTextField();
        JTextField rgbSplitCompColourTwoText = new JTextField();

        JTextField hexText = new JTextField();
        JTextField hexCompText = new JTextField();
        JTextField hexTriOneText = new JTextField();
        JTextField hexTriTwoText = new JTextField();
        JTextField hexAnalogousOneText = new JTextField();
        JTextField hexAnalogousTwoText = new JTextField();
        JTextField hexSplitCompOneText = new JTextField();
        JTextField hexSplitCompTwoText = new JTextField();

        JTextField hsvText = new JTextField();
        JTextField hsvCompText = new JTextField();
        JTextField hsvTriOneText = new JTextField();
        JTextField hsvTriTwoText = new JTextField();
        JTextField hsvAnalogousOneText = new JTextField();
        JTextField hsvAnalogousTwoText = new JTextField();
        JTextField hsvSplitCompOneText = new JTextField();
        JTextField hsvSplitCompTwoText = new JTextField();

        textBoxes.add(rgbText);
        textBoxes.add(rgbCompText);
        textBoxes.add(rgbTriOneText);
        textBoxes.add(rgbTriTwoText);
        textBoxes.add(rgbAnalogousOneText);
        textBoxes.add(rgbAnalogousTwoText);
        textBoxes.add(rgbSplitCompColourOneText);
        textBoxes.add(rgbSplitCompColourTwoText);

        textBoxes.add(hexText);
        textBoxes.add(hexCompText);
        textBoxes.add(hexTriOneText);
        textBoxes.add(hexTriTwoText);
        textBoxes.add(hexAnalogousOneText);
        textBoxes.add(hexAnalogousTwoText);
        textBoxes.add(hexSplitCompOneText);
        textBoxes.add(hexSplitCompTwoText);

        textBoxes.add(hsvText);
        textBoxes.add(hsvCompText);
        textBoxes.add(hsvTriOneText);
        textBoxes.add(hsvTriTwoText);
        textBoxes.add(hsvAnalogousOneText);
        textBoxes.add(hsvAnalogousTwoText);
        textBoxes.add(hsvSplitCompOneText);
        textBoxes.add(hsvSplitCompTwoText);

        JButton generate = new JButton("Give me a colour!");

        // Main Labels
        primaryLabel.setBounds(55, 25, 100, 25);
        triColourLabel1.setBounds(55, 200, 150, 25);
        triColourLabel2.setBounds(265, 200, 150, 25);
        complimentaryLabel.setBounds(265, 25, 150, 25);
        analogousColourLabel1.setBounds(470, 25, 150, 25);
        analogousColourLabel2.setBounds(470, 200, 150, 25);
        splitCompColourLabel1.setBounds(675, 25, 150, 25);
        splitCompColourLabel2.setBounds(675, 200, 150, 25);

        // Secondary Labels
        primaryLabelTwo.setBounds(900, 25, 100, 25);
        triColourLabel1Two.setBounds(900, 95, 150, 25);
        triColourLabel2Two.setBounds(900, 130, 150, 25);
        complimentaryLabelTwo.setBounds(900, 60, 150, 25);
        analogousColourLabel1Two.setBounds(900, 165, 150, 25);
        analogousColourLabel2Two.setBounds(900, 200, 150, 25);
        splitCompColourLabel1Two.setBounds(900, 235, 150, 25);
        splitCompColourLabel2Two.setBounds(900, 270, 150, 25);

        rgbText.setBounds(100, 61, 100, 25);
        rgbCompText.setBounds(315, 61, 100, 25);
        rgbTriOneText.setBounds(100, 236, 100, 25);
        rgbTriTwoText.setBounds(315, 236, 100, 25);
        rgbAnalogousOneText.setBounds(530, 61, 100, 25);
        rgbAnalogousTwoText.setBounds(530, 236, 100, 25);
        rgbSplitCompColourOneText.setBounds(735, 61, 100, 25);
        rgbSplitCompColourTwoText.setBounds(735, 236, 100, 25);

        hexText.setBounds(100, 96, 100, 25);
        hexCompText.setBounds(315, 96, 100, 25);
        hexTriOneText.setBounds(100, 271, 100, 25);
        hexTriTwoText.setBounds(315, 271, 100, 25);
        hexAnalogousOneText.setBounds(530, 96, 100, 25);
        hexAnalogousTwoText.setBounds(530, 271, 100, 25);
        hexSplitCompOneText.setBounds(735, 96, 100, 25);
        hexSplitCompTwoText.setBounds(735, 271, 100, 25);

        hsvText.setBounds(100, 131, 110, 25);
        hsvCompText.setBounds(300, 131, 110, 25);
        hsvTriOneText.setBounds(100, 306, 110, 25);
        hsvTriTwoText.setBounds(300, 306, 110, 25);
        hsvAnalogousOneText.setBounds(520, 131, 110, 25);
        hsvAnalogousTwoText.setBounds(520, 306, 110, 25);
        hsvSplitCompOneText.setBounds(730, 131, 110, 25);
        hsvSplitCompTwoText.setBounds(730, 306, 110, 25);

        generate.setBounds(15, 550, 740, 40);
        useCustomColourOption.setBounds(15, 165, 150, 25);

        colourPanel.setBounds(1050, 23,200, 30);
        colourCompPanel.setBounds(1050, 58, 200, 30);
        colourTriOnePanel.setBounds(1050, 93, 200, 30);
        colourTriTwoPanel.setBounds(1050, 128, 200, 30);
        colourAnalogousOnePanel.setBounds(1050, 163, 200, 30);
        colourAnalogousTwoPanel.setBounds(1050, 198, 200, 30);
        colourSplitCompOnePanel.setBounds(1050, 233, 200, 30);
        colourSplitCompTwoPanel.setBounds(1050, 268, 200, 30);


        ActionListener generateDo = e -> {
            if(!customColourSelected){
                r = Generate.red();
                g = Generate.green();
                b = Generate.blue();

                String hex = String.format("#%02x%02x%02x", r, g, b);
                rgbText.setText("(" + r + " , " + g + " , " + b + ")");
                hexText.setText(hex);
                colourPanel.setBackground(Color.decode(hex));
                Color.RGBtoHSB(r, g, b, hsv);
                hsvText.setText(ColourConversion.RGBHSV(hsv));
            } else {
                // We're going to get the custom colour from the
            }

            float[] compHSV = ColourConversion.getComplimentaryColour(hsv);
            float[] triOneHSV = ColourConversion.getTriadicColourOne(hsv);
            float[] triTwoHSV = ColourConversion.getTriadicColourTwo(hsv);
            float[] analogousOneHSV = ColourConversion.getAnalogousColourOne(hsv, false);
            float[] analogousTwoHSV = ColourConversion.getAnalogousColourTwo(hsv, false);
            float[] splitCompOneHSV = ColourConversion.getAnalogousColourOne(compHSV, true);
            float[] splitCompTwoHSV = ColourConversion.getAnalogousColourTwo(compHSV, true);

            ColourConversion.fillColourInfo(rgbCompText, hexCompText, hsvCompText, colourCompPanel, compHSV);
            ColourConversion.fillColourInfo(rgbTriOneText, hexTriOneText, hsvTriOneText, colourTriOnePanel, triOneHSV);
            ColourConversion.fillColourInfo(rgbTriTwoText, hexTriTwoText, hsvTriTwoText, colourTriTwoPanel, triTwoHSV);
            ColourConversion.fillColourInfo(rgbAnalogousOneText, hexAnalogousOneText, hsvAnalogousOneText, colourAnalogousOnePanel, analogousOneHSV);
            ColourConversion.fillColourInfo(rgbAnalogousTwoText, hexAnalogousTwoText, hsvAnalogousTwoText, colourAnalogousTwoPanel, analogousTwoHSV);
            ColourConversion.fillColourInfo(rgbSplitCompColourOneText, hexSplitCompOneText, hsvSplitCompOneText, colourSplitCompOnePanel, splitCompOneHSV);
            ColourConversion.fillColourInfo(rgbSplitCompColourTwoText, hexSplitCompTwoText, hsvSplitCompTwoText, colourSplitCompTwoPanel, splitCompTwoHSV);
        };

        ActionListener customColourDo = e -> {
            customColourSelected = useCustomColourOption.isSelected();

            if(customColourSelected){
                generate.setText("Give me information about this colour.");
            } else {
                generate.setText("Give me a colour.");
            }
        };


        generate.addActionListener(generateDo);
        useCustomColourOption.addActionListener(customColourDo);

        window.add(primaryLabel);
        window.add(primaryLabelTwo);
        window.add(complimentaryLabel);
        window.add(complimentaryLabelTwo);
        window.add(triColourLabel1);
        window.add(triColourLabel1Two);
        window.add(triColourLabel2);
        window.add(triColourLabel2Two);
        window.add(analogousColourLabel1);
        window.add(analogousColourLabel1Two);
        window.add(analogousColourLabel2);
        window.add(analogousColourLabel2Two);
        window.add(splitCompColourLabel1);
        window.add(splitCompColourLabel1Two);
        window.add(splitCompColourLabel2);
        window.add(splitCompColourLabel2Two);


        drawLabelGrouping(window, 20, 60); // Primary Colour
        drawLabelGrouping(window, 232, 60); // Complimentary Colour
        drawLabelGrouping(window, 20, 235);
        drawLabelGrouping(window, 232, 235);
        drawLabelGrouping(window, 443, 60);
        drawLabelGrouping(window, 443, 235);
        drawLabelGrouping(window, 654, 60);
        drawLabelGrouping(window, 654, 235);

        for (JTextField textBox : textBoxes) {
            textBox.setEditable(false);
            textBox.setBackground(panelColour);
            textBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            window.add(textBox);
        }

        window.add(colourPanel);
        window.add(colourCompPanel);
        window.add(colourTriOnePanel);
        window.add(colourTriTwoPanel);
        window.add(colourAnalogousOnePanel);
        window.add(colourAnalogousTwoPanel);
        window.add(colourSplitCompOnePanel);
        window.add(colourSplitCompTwoPanel);


        // 23, 58, 93, 128, 163, 198, 233, 268, 303, 338, 373, 408, 443, 478, 513, 548
        drawPanelGrouping(window, 15, 23, panelColour); // Primary Colour
        drawPanelGrouping(window, 225, 23, panelColour); // Complimentary Colour
        drawPanelGrouping(window, 15, 198, panelColour); // Triadic Colour One
        drawPanelGrouping(window, 225, 198, panelColour); // Triadic Colour Two
        drawPanelGrouping(window, 435, 23, panelColour); // Analogous Colour One
        drawPanelGrouping(window, 435, 198, panelColour); // Analogous Colour Two
        drawPanelGrouping(window, 645, 23, panelColour); // Split Complimentary One
        drawPanelGrouping(window, 645, 198, panelColour); //Split Complimentary Two

        window.add(generate);

        window.setSize(1280, 800);
        window.setResizable(false);
        window.setLayout(null);// using no layout managers
        window.setVisible(true);// making the frame visible
    }


    public static void drawLabelGrouping(JFrame window, int startX, int startY){
        JLabel[] labels = new JLabel[3];

        labels[0] = new JLabel("RGB Value: ");
        labels[1] = new JLabel("Hex Value: ");
        labels[2] = new JLabel("HSB Value: ");
        int posY = startY;

        for(int i = 0; i < labels.length; i++){
            labels[i].setBounds(startX, posY, 75, 25);
            posY += 35;
            window.add(labels[i]);
        }
    }

    public static void customColourUsed(){

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
}
