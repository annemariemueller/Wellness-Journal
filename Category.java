// Created by Annemarie Mueller 1/23/2021
// Models each category in the journal

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Box;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Category extends JPanel implements ActionListener {
  // Fields
  private JButton increase, decrease, enter;
  private JTextField display;
  private Stats stats;
  private Color panelColor;
  private String name;

  // Constructor
  public Category(String name, Color color) {
    panelColor = color;
    this.name = name;

    JTextField banner = new JTextField("  " + name);
    banner.setEditable(false);
    banner.setFont(new Font("Monospaced", Font.BOLD, 14));
    banner.setHorizontalAlignment(JTextField.CENTER);
    
    // Buttons to increase and decrease your stats
    increase = new JButton(" More ");
    increase.addActionListener(this);
    decrease = new JButton(" Less ");
    decrease.addActionListener(this);
    // Button to enter the day's stats 
    enter = new JButton("Enter");
    enter.setBackground(Color.BLUE);
    enter.addActionListener(this);    
    
    display = new JTextField("0  ");
    display.setFont(new Font("Monospaced", Font.BOLD, 16));
    display.setBackground(new Color(200, 0, 200));
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);

    JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 0));
    buttons.add(increase);
    buttons.add(decrease);
    buttons.add(enter);
    
    Box b1 = Box.createVerticalBox();
    b1.add(banner);
    b1.add(Box.createVerticalStrut(5));
    b1.add(display);
    b1.add(Box.createVerticalStrut(12));
    Box b2 = Box.createHorizontalBox();
    b2.add(Box.createHorizontalStrut(60));
    Box b3 = Box.createVerticalBox();
    b3.add(enter);
    b3.add(Box.createVerticalStrut(8));
    b3.add(buttons);
    b2.add(b3);
    b1.add(b2);
    b1.add(Box.createVerticalStrut(5));
    add(b1);
    buttons.setVisible(true);

    Scanner s = new Scanner(System.in);
    if (name.equals("Calories  ")) {
      System.out.println("Track your day in this wellness journal!");
      System.out.print("Enter your target number of calories in hundreds (20 is standard): ");
      stats = new Stats(s.nextInt());
    }
    else if (name.equals("Hours of Sleep  ")) {
      System.out.print("Enter your target number of hours of sleep (8 is standard): ");
      stats = new Stats(s.nextInt());
    }
    else {
    System.out.print("Enter your target number of glasses of water (8 is standard): ");
    stats = new Stats(s.nextInt());
    }
  }

  // Methods
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton)e.getSource();

    if (b == increase) {
      stats.increase(1);
      display.setText("" + stats.getCurrent());
    }
    else if (b == decrease) {
      stats.decrease(1);
      display.setText("" + stats.getCurrent());
    }
    else if (b == enter) {
      // Good stats
      if (stats.getRating() == 0) {
        JOptionPane.showMessageDialog(null, null, "That looks good!", JOptionPane.PLAIN_MESSAGE);
      }
      // Too low
      else if (stats.getRating() == -1) {
        JOptionPane.showMessageDialog(null, null, "Tomorrow aim for more.", JOptionPane.PLAIN_MESSAGE);
      }
      // Too high
      else if (stats.getRating() == 1) {
        JOptionPane.showMessageDialog(null, null, "Tomorrow aim for less.", JOptionPane.PLAIN_MESSAGE);
      }
    }
  }
}