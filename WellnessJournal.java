// Created by Annemarie Mueller 1/23/2021
// Models the wellness journal JFrame
 
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.JButton;

public class WellnessJournal extends JFrame {
  // Fields
  private Category[] categories;
  private JLabel background;

   // Constructor
  public WellnessJournal() {
    super("Wellness Journal");

    Category[] categories = {
      new Category("Calories  ", Color.BLUE),
      new Category("Hours of Sleep  ", Color.LIGHT_GRAY),
      new Category("Glasses of Water  ", Color.WHITE)
    };
    this.categories = categories;
    
    int w = 600;
    int h = 310;
    setMinimumSize(new Dimension(w, h));

    // Sets the background to the galaxy jpeg
    ImageIcon img = new ImageIcon("galaxy.jpg");
    background = new JLabel("", img, JLabel.CENTER);
    background.setBounds(0, 0, w, h);
    add(background);

    Box back = Box.createHorizontalBox();
    back.add(Box.createHorizontalStrut(5));
    for (Category c : categories) {
      back.add(c);
      back.add(Box.createHorizontalStrut(5));
    }

    JTextField prompt = new JTextField("        Word for the Day:        type a word here");
    prompt.setFont(new Font("Monospaced", Font.BOLD, 16));
    prompt.setBackground(Color.BLUE);
    prompt.setEditable(true);
    prompt.setHorizontalAlignment(JTextField.LEFT);
    
    Container c = getContentPane();
    c.setBackground(Color.GRAY);
    c.add(back);
    c.add(prompt, BorderLayout.SOUTH);
  }

  // Methods
  public static void main(String[] args) {
    WellnessJournal window = new WellnessJournal();
    window.setLocation(50, 50);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}