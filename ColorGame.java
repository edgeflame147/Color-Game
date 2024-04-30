import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ColorGame implements ActionListener {
    JFrame j1 = new JFrame("Color Game");
    JPanel j2 = new JPanel();
    JTextArea j3 = new JTextArea(" Welcome to the Color Game! \n The rules are pretty simple: \n type"+
    " the color of the word, not \n the actual text itself. \n --------Press start to begin--------");
    JLabel j4 = new JLabel();
    JButton j5 = new JButton("Start");
    JLabel j6 = new JLabel();
    int numClicks;
    Color[] colorAry = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta, 
    Color.black};
    String[] colorKey = {"red", "orange", "yellow", "green", "blue", "purple", "black"};
    int labelBack;
    int labelText;
    int background;
    int score;
    

    public ColorGame() {}

    public void frame(int width, int height) {
        j1.setSize(width, height);
    }

    public void panel() {
        j1.add(j2);
        j2.setLayout(new BoxLayout(j2, BoxLayout.Y_AXIS));
    }

    public void button() {
        j2.add(j5);
        j2.setMaximumSize(new Dimension(100, 30));
        j5.addActionListener(this);
        j5.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void text() {
        j2.add(j3);
        j3.setAlignmentX(Component.CENTER_ALIGNMENT);
        j3.setMaximumSize(new Dimension(200, 100));

    }

    public void label() {
        j2.add(j4);
        j4.setAlignmentX(Component.CENTER_ALIGNMENT);
        j4.setMaximumSize(new Dimension(100, 100));
        j4.setFont(new Font("Sanserif", Font.PLAIN, 30));
    }

    public void score() {
        j2.add(j6);
        j6.setAlignmentX(Component.CENTER_ALIGNMENT);
        j6.setMaximumSize(new Dimension(100, 100));
        j6.setFont(new Font("Sansserif", Font.PLAIN, 17));
    }
    
    public void actionPerformed(ActionEvent e) {
        numClicks++;
        j5.setText("Enter");
        j3.setMaximumSize(new Dimension(150, 60));
        if(numClicks >= 2) {
            if(j3.getText().toLowerCase().trim().equals(colorKey[labelBack])) {
                score += 1;
                System.out.println("Yes, the colors match :)");
            }
        }
        j6.setText("Score: "+score+"/"+(numClicks-1));
        j3.setText(" ");
        colorSetter();
        if(numClicks > 15) {
            j3.setMaximumSize(new Dimension(150, 80));
            j4.setText("");
            j6.setText("");
            j3.setText(" Thanks for playing! \n Your score was "+score+"/15. \n"+
            " Click to flash different \n background colors :)");
            j5.setText("Flash");

        }

    } 

    public void colorSetter() {
        labelBack = (int)(Math.random()*7);
        labelText = (int)(Math.random()*7);
        background = (int)(Math.random()*7);
        while(labelBack==labelText || labelBack==background || labelText==background) {
            labelBack = (int)(Math.random()*7);
            labelText = (int)(Math.random()*7);
            background = (int)(Math.random()*7);
        }
        j2.setBackground(colorAry[background]);
        j4.setForeground(colorAry[labelBack]);
        j4.setText(colorKey[labelText]);

    }
    public static void main(String[] args) {
        ColorGame c1 = new ColorGame();
        c1.frame(350, 400);
        c1.j1.setVisible(true);
        c1.panel();
        c1.label();
        c1.text();
        c1.button();
        c1.score();
    }
}