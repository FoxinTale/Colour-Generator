import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    public static int r;
    public static int g;
    public static int b;

    public static void createGUI(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        window.setTitle("Colour Generator");
        ArrayList<JTextField> textBoxes = new ArrayList<>();

        float[] hsv = new float[3];

        Color panelColour =  Color.decode("#FFF0F5");

        JLabel primaryLabel = new JLabel("Primary Colour");
        JLabel primaryLabelTwo = new JLabel("Primary Colour: ");
        JLabel complimentaryLabel = new JLabel("Complimentary Colour");
        JLabel complimentaryLabelTwo = new JLabel("Complimentary Colour: ");
        JLabel triColourLabel1 = new JLabel("Triadic Colour One");
        JLabel triColourLabel1Two = new JLabel("Triadic Colour One: ");
        JLabel triColourLabel2 = new JLabel("Triadic Colour Two");
        JLabel triColourLabel2Two = new JLabel("Triadic Colour Two: ");

        JPanel colourPanel = new RoundedPanel(5);
        JPanel colourCompPanel = new RoundedPanel(5);
        JPanel colourTriOnePanel = new RoundedPanel(5);
        JPanel colourTriTwoPanel = new RoundedPanel(5);

        JTextField rgbText = new JTextField();
        JTextField rgbCompText = new JTextField();
        JTextField rgbTriOneText = new JTextField();
        JTextField rgbTriTwoText = new JTextField();
        JTextField hexText = new JTextField();
        JTextField hexCompText = new JTextField();
        JTextField hexTriOneText = new JTextField();
        JTextField hexTriTwoText = new JTextField();
        JTextField hsvText = new JTextField();
        JTextField hsvCompText = new JTextField();
        JTextField hsvTriOneText = new JTextField();
        JTextField hsvTriTwoText = new JTextField();

        textBoxes.add(rgbText);
        textBoxes.add(rgbCompText);
        textBoxes.add(rgbTriOneText);
        textBoxes.add(rgbTriTwoText);
        textBoxes.add(hexText);
        textBoxes.add(hexCompText);
        textBoxes.add(hexTriOneText);
        textBoxes.add(hexTriTwoText);
        textBoxes.add(hsvText);
        textBoxes.add(hsvCompText);
        textBoxes.add(hsvTriOneText);
        textBoxes.add(hsvTriTwoText);

        for (JTextField textBox : textBoxes) {
            textBox.setEditable(false);
            textBox.setBackground(panelColour);
            textBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        }

        JButton generate = new JButton("Give me a colour!");

        primaryLabel.setBounds(90, 25, 100, 25);
        primaryLabelTwo.setBounds(575, 25, 100, 25);
        triColourLabel1.setBounds(90, 200, 150, 25);
        triColourLabel1Two.setBounds(575, 95, 150, 25);
        triColourLabel2.setBounds(325, 200, 150, 25);
        triColourLabel2Two.setBounds(575, 130, 150, 25);
        complimentaryLabel.setBounds(325, 25, 150, 25);
        complimentaryLabelTwo.setBounds(575, 60, 150, 25);

        rgbText.setBounds(100, 61, 100, 25);
        rgbCompText.setBounds(355, 61, 100, 25);
        rgbTriOneText.setBounds(100, 236, 100, 25);
        rgbTriTwoText.setBounds(355, 236, 100, 25);
        hexText.setBounds(100, 96, 100, 25);
        hexCompText.setBounds(355, 96, 100, 25);
        hexTriOneText.setBounds(100, 271, 100, 25);
        hexTriTwoText.setBounds(355, 271, 100, 25);
        hsvText.setBounds(100, 131, 150, 25);
        hsvCompText.setBounds(355, 131, 125, 25);
        hsvTriOneText.setBounds(100, 306, 125, 25);
        hsvTriTwoText.setBounds(355, 306, 125, 25);

        generate.setBounds(15, 400, 490, 30);

        colourPanel.setBounds(720, 23,200, 30);
        colourCompPanel.setBounds(720, 58, 200, 30);
        colourTriOnePanel.setBounds(720, 93, 200, 30);
        colourTriTwoPanel.setBounds(720, 128, 200, 30);

        ActionListener generateDo = e -> {
            r = Generate.red();
            g = Generate.green();
            b = Generate.blue();

            String hex = String.format("#%02x%02x%02x", r, g, b);
            rgbText.setText("(" + r + " , " + g + " , " + b + ")");
            hexText.setText(hex);
            colourPanel.setBackground(Color.decode(hex));
            Color.RGBtoHSB(r, g, b, hsv);
            hsvText.setText(ColourConversion.RGBHSV(hsv));

            float[] compHSV = ColourConversion.getComplimentaryColour(hsv);
            float[] triOneHSV = ColourConversion.getTriadicColourOne(hsv);
            float[] triTwoHSV = ColourConversion.getTriadicColourTwo(hsv);

            ColourConversion.getTriadicColourTwo(hsv);
            ColourConversion.fillColourInfo(rgbCompText, hexCompText, hsvCompText, colourCompPanel, compHSV);
            ColourConversion.fillColourInfo(rgbTriOneText, hexTriOneText, hsvTriOneText, colourTriOnePanel, triOneHSV);
            ColourConversion.fillColourInfo(rgbTriTwoText, hexTriTwoText, hsvTriTwoText, colourTriTwoPanel, triTwoHSV);
        };

        generate.addActionListener(generateDo);
        window.add(primaryLabel);
        window.add(primaryLabelTwo);
        window.add(complimentaryLabel);
        window.add(complimentaryLabelTwo);
        window.add(triColourLabel1);
        window.add(triColourLabel1Two);
        window.add(triColourLabel2);
        window.add(triColourLabel2Two);
        drawLabelGrouping(window, 20, 60); // Primary Colour
        drawLabelGrouping(window, 275, 60); // Complimentary Colour
        drawLabelGrouping(window, 20, 235);
        drawLabelGrouping(window, 275, 235);

        for (JTextField textBox : textBoxes) {
            window.add(textBox);
        }

        window.add(colourPanel);
        window.add(colourCompPanel);
        window.add(colourTriOnePanel);
        window.add(colourTriTwoPanel);

        // 23, 58, 93, 128, 163, 198, 233, 268, 303, 338, 373, 408, 443, 478, 513, 548
        drawPanelGrouping(window, 15, 23, panelColour); // Primary Colour
        drawPanelGrouping(window, 265, 23, panelColour); // Complimentary Colour
        drawPanelGrouping(window, 15, 198, panelColour);
        drawPanelGrouping(window, 265, 198, panelColour);

        window.add(generate);

        window.setSize(960, 640);
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
