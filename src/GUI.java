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

        JPanel colourPanel = new RoundedPanel(5);
        JPanel colourCompPanel = new RoundedPanel(5);
        JPanel colourTriOnePanel = new RoundedPanel(5);
        JPanel colourTriTwoPanel = new RoundedPanel(5);
        JPanel colourAnalogousOnePanel = new RoundedPanel(5);
        JPanel colourAnalogousTwoPanel = new RoundedPanel(5);




        JTextField rgbText = new JTextField();
        JTextField rgbCompText = new JTextField();
        JTextField rgbTriOneText = new JTextField();
        JTextField rgbTriTwoText = new JTextField();
        JTextField rgbAnalogousOneText = new JTextField();
        JTextField rgbAnalogousTwoText = new JTextField();

        JTextField hexText = new JTextField();
        JTextField hexCompText = new JTextField();
        JTextField hexTriOneText = new JTextField();
        JTextField hexTriTwoText = new JTextField();
        JTextField hexAnalogousOneText = new JTextField();
        JTextField hexAnalogousTwoText = new JTextField();

        JTextField hsvText = new JTextField();
        JTextField hsvCompText = new JTextField();
        JTextField hsvTriOneText = new JTextField();
        JTextField hsvTriTwoText = new JTextField();
        JTextField hsvAnalogousOneText = new JTextField();
        JTextField hsvAnalogousTwoText = new JTextField();


        textBoxes.add(rgbText);
        textBoxes.add(rgbCompText);
        textBoxes.add(rgbTriOneText);
        textBoxes.add(rgbTriTwoText);
        textBoxes.add(rgbAnalogousOneText);
        textBoxes.add(rgbAnalogousTwoText);

        textBoxes.add(hexText);
        textBoxes.add(hexCompText);
        textBoxes.add(hexTriOneText);
        textBoxes.add(hexTriTwoText);
        textBoxes.add(hexAnalogousOneText);
        textBoxes.add(hexAnalogousTwoText);

        textBoxes.add(hsvText);
        textBoxes.add(hsvCompText);
        textBoxes.add(hsvTriOneText);
        textBoxes.add(hsvTriTwoText);
        textBoxes.add(hsvAnalogousOneText);
        textBoxes.add(hsvAnalogousTwoText);

        JButton generate = new JButton("Give me a colour!");

        primaryLabel.setBounds(90, 25, 100, 25);
        primaryLabelTwo.setBounds(850, 25, 100, 25);
        triColourLabel1.setBounds(90, 200, 150, 25);
        triColourLabel1Two.setBounds(850, 95, 150, 25);
        triColourLabel2.setBounds(325, 200, 150, 25);
        triColourLabel2Two.setBounds(850, 130, 150, 25);
        complimentaryLabel.setBounds(325, 25, 150, 25);
        complimentaryLabelTwo.setBounds(850, 60, 150, 25);
        analogousColourLabel1.setBounds(560, 25, 150, 25);
        analogousColourLabel1Two.setBounds(850, 165, 150, 25);
        analogousColourLabel2.setBounds(560, 200, 150, 25);
        analogousColourLabel2Two.setBounds(850, 200, 150, 25);

        rgbText.setBounds(100, 61, 100, 25);
        rgbCompText.setBounds(355, 61, 100, 25);
        rgbTriOneText.setBounds(100, 236, 100, 25);
        rgbTriTwoText.setBounds(355, 236, 100, 25);
        rgbAnalogousOneText.setBounds(610, 61, 100, 25);
        rgbAnalogousTwoText.setBounds(610, 236, 100, 25);

        hexText.setBounds(100, 96, 100, 25);
        hexCompText.setBounds(355, 96, 100, 25);
        hexTriOneText.setBounds(100, 271, 100, 25);
        hexTriTwoText.setBounds(355, 271, 100, 25);
        hexAnalogousOneText.setBounds(610, 96, 100, 25);
        hexAnalogousTwoText.setBounds(610, 271, 100, 25);

        hsvText.setBounds(100, 131, 125, 25);
        hsvCompText.setBounds(355, 131, 125, 25);
        hsvTriOneText.setBounds(100, 306, 125, 25);
        hsvTriTwoText.setBounds(355, 306, 125, 25);
        hsvAnalogousOneText.setBounds(610, 131, 125, 25);
        hsvAnalogousTwoText.setBounds(610, 306, 125, 25);

        generate.setBounds(15, 550, 740, 40);
        useCustomColourOption.setBounds(15, 165, 150, 25);

        colourPanel.setBounds(1000, 23,200, 30);
        colourCompPanel.setBounds(1000, 58, 200, 30);
        colourTriOnePanel.setBounds(1000, 93, 200, 30);
        colourTriTwoPanel.setBounds(1000, 128, 200, 30);
        colourAnalogousOnePanel.setBounds(1000, 163, 200, 30);
        colourAnalogousTwoPanel.setBounds(1000, 198, 200, 30);


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
            float[] analogousOneHSV = ColourConversion.getAnalogousColourOne(hsv);
            float[] analogousTwoHSV = ColourConversion.getAnalogousColourTwo(hsv);

            ColourConversion.fillColourInfo(rgbCompText, hexCompText, hsvCompText, colourCompPanel, compHSV);
            ColourConversion.fillColourInfo(rgbTriOneText, hexTriOneText, hsvTriOneText, colourTriOnePanel, triOneHSV);
            ColourConversion.fillColourInfo(rgbTriTwoText, hexTriTwoText, hsvTriTwoText, colourTriTwoPanel, triTwoHSV);
            ColourConversion.fillColourInfo(rgbAnalogousOneText, hexAnalogousOneText, hsvAnalogousOneText, colourAnalogousOnePanel, analogousOneHSV);
            ColourConversion.fillColourInfo(rgbAnalogousTwoText, hexAnalogousTwoText, hsvAnalogousTwoText, colourAnalogousTwoPanel, analogousTwoHSV);
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


        drawLabelGrouping(window, 20, 60); // Primary Colour
        drawLabelGrouping(window, 272, 60); // Complimentary Colour
        drawLabelGrouping(window, 20, 235);
        drawLabelGrouping(window, 272, 235);
        drawLabelGrouping(window, 523, 60);
        drawLabelGrouping(window, 523, 235);

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


        // 23, 58, 93, 128, 163, 198, 233, 268, 303, 338, 373, 408, 443, 478, 513, 548
        drawPanelGrouping(window, 15, 23, panelColour); // Primary Colour
        drawPanelGrouping(window, 265, 23, panelColour); // Complimentary Colour
        drawPanelGrouping(window, 15, 198, panelColour); // Triadic Colour One
        drawPanelGrouping(window, 265, 198, panelColour); // Triadic Colour Two
        drawPanelGrouping(window, 515, 23, panelColour); // Analogous Colour One
        drawPanelGrouping(window, 515, 198, panelColour); // Analogous Colour Two

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
        labels[2] = new JLabel("HSV Value: ");
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
            panels[i].setBounds(startX, posY, 240, 30);
            posY += 35;
            window.add(panels[i]);
        }
    }
}
