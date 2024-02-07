import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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
        JLabel complimentaryLabel = new JLabel("Complimentary Colour");
  //      JLabel rgbLabel = new JLabel("RGB Value: ");
 //       JLabel rgbCompLabel = new JLabel("RGB Value: ");
 //       JLabel hexLabel = new JLabel("Hex Value: ");
 //       JLabel hexCompLabel = new JLabel("Hex Value: ");
 //       JLabel hsvLabel = new JLabel("HSV Value: ");
 //       JLabel hsvCompLabel = new JLabel("HSV Value: ");

        JPanel primaryPanel = new RoundedPanel(5, panelColour);
        JPanel complimentaryPanel = new RoundedPanel(5, panelColour);
 //       JPanel rgbPanel = new RoundedPanel(5, panelColour);
 //       JPanel rbgCompPanel = new RoundedPanel(5, panelColour);
 //       JPanel hexPanel = new RoundedPanel(5, panelColour);
 //       JPanel hexCompPanel = new RoundedPanel(5, panelColour);
 //       JPanel hsvPanel = new RoundedPanel(5, panelColour);
 //       JPanel hsvCompPanel = new RoundedPanel(5, panelColour);
        JPanel colourPanel = new RoundedPanel(5);
        JPanel colourCompPanel = new RoundedPanel(5);

        JTextField rgbText = new JTextField();
        JTextField rgbCompText = new JTextField();
        JTextField hexText = new JTextField();
        JTextField hexCompText = new JTextField();
        JTextField hsvText = new JTextField();
        JTextField hsvCompText = new JTextField();

        textBoxes.add(rgbText);
        textBoxes.add(rgbCompText);
        textBoxes.add(hexText);
        textBoxes.add(hexCompText);
        textBoxes.add(hsvText);
        textBoxes.add(hsvCompText);

        for (JTextField textBox : textBoxes) {
            textBox.setEditable(false);
            textBox.setBackground(panelColour);
            textBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        }

        JButton generate = new JButton("Give me a colour!");

        // 35

        primaryLabel.setBounds(90, 25, 100, 25);
        complimentaryLabel.setBounds(325, 25, 150, 25);
   //     rgbLabel.setBounds(20, 60, 75, 25);
  //      rgbCompLabel.setBounds(275, 60, 75, 25);
  //      hexLabel.setBounds(20, 95, 75, 25);
 //       hexCompLabel.setBounds(275, 95, 75, 25);
 //       hsvLabel.setBounds(20, 130, 75, 25);
 //       hsvCompLabel.setBounds(275, 130, 75, 25);

        rgbText.setBounds(100, 61, 100, 25);
        rgbCompText.setBounds(355, 61, 100, 25);
        hexText.setBounds(100, 96, 100, 25);
        hexCompText.setBounds(355, 96, 100, 25);
        hsvText.setBounds(100, 131, 150, 25);
        hsvCompText.setBounds(355, 131, 125, 25);

        generate.setBounds(15, 305, 490, 30);
        //35

        primaryPanel.setBounds(15, 23, 240, 30);
        complimentaryPanel.setBounds(265, 23, 240, 30);
   //     rgbPanel.setBounds(15, 58, 240, 30);
//        rbgCompPanel.setBounds(265, 58, 240, 30);
//        hexPanel.setBounds(15, 93, 240, 30);
 //       hexCompPanel.setBounds(265, 93, 240, 30);
  //      hsvPanel.setBounds(15, 128, 240, 30);
//        hsvCompPanel.setBounds(265, 128, 240, 30);
        colourPanel.setBounds(15, 233,240, 30);
        colourCompPanel.setBounds(265, 233, 240, 30);

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
            ColourConversion.getTriadicColourOne(hsv);
            ColourConversion.getTriadicColourTwo(hsv);
            ColourConversion.fillColourInfo(rgbCompText, hexCompText, hsvCompText, colourCompPanel, compHSV);
            /*
            compR = compColour.getRed();
            compG = compColour.getGreen();
            compB = compColour.getBlue();
            String compHex = String.format("#%02x%02x%02x", compR, compG, compB);

            rgbCompText.setText("(" + compR + " , " + compG + " , " + compB + ")");
            hexCompText.setText(compHex);
            hsvCompText.setText(String.format("%.1f%n, %.1f%n, %.1f%n", compHSV[0], compHSV[1] *= 100,compHSV[2] *= 100));
            colourCompPanel.setBackground(Color.decode(compHex));
             */
        };

        generate.addActionListener(generateDo);
        window.add(primaryLabel);
        window.add(complimentaryLabel);
  //      window.add(rgbLabel);
   //     window.add(rgbCompLabel);
   //     window.add(hexLabel);
   //     window.add(hexCompLabel);
   //     window.add(hsvLabel);
   //     window.add(hsvCompLabel);
        drawLabelGrouping(window, 20, 60);
        drawLabelGrouping(window, 275, 60);

        window.add(rgbText);
        window.add(rgbCompText);
        window.add(hexText);
        window.add(hexCompText);
        window.add(hsvText);
        window.add(hsvCompText);
        window.add(primaryPanel);
        window.add(complimentaryPanel);
   //     window.add(rgbPanel);
   //     window.add(rbgCompPanel);
  //      window.add(hexPanel);
 //       window.add(hexCompPanel);
 //       window.add(hsvPanel);
  //      window.add(hsvCompPanel);
        window.add(colourPanel);
        window.add(colourCompPanel);

        drawPanelGrouping(window, 265, 58, panelColour);
        drawPanelGrouping(window, 15, 58, panelColour);

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
        JPanel[] panels = new JPanel[3];
        int posY = startY;
        for(int i = 0; i < panels.length; i++){
            panels[i] = new RoundedPanel(5, panelColour);
            panels[i].setBounds(startX, posY, 240, 30);
            posY += 35;
            window.add(panels[i]);
        }
    }
}
