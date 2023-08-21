package UI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ts extends JFrame {
  private JPanel timerPanel;
  private JPanel stopwatchPanel;
  private JButton timerButton;
  private JButton stopwatchButton;

  public Ts() {

    //change the background color

    setTitle("Timer and Stopwatch");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(3, 3));
    
    
    timerPanel = new JPanel();
    stopwatchPanel = new JPanel();
    timerButton = new JButton("Timer");
    timerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CountDown CountDown = new CountDown();
        CountDown.setVisible(true);
      }
    });
    timerPanel.add(timerButton);
    

    stopwatchButton = new JButton("Stopwatch");
    stopwatchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.setVisible(true);
        
      }
      
    });
    stopwatchPanel.add(stopwatchButton);

    add(timerPanel);
    add(stopwatchPanel);
  }

  public static void main(String[] args) {
    Ts Ts = new Ts();
    Ts.setVisible(true);
  }
}