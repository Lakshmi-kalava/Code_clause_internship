package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Stopwatch implements ActionListener{


    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton pauseButton = new JButton("PAUSE");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    int milliseconds = 0;

    String seconds_string = String.format("%02d", seconds);
    String milliseconds_string = String.format("%03d", milliseconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    boolean started = false;

    long startTime = 0;

    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            long currentTime = System.currentTimeMillis();
            elapsedTime = (int) (currentTime - startTime);
            updateDisplay();
        }
    });
    Stopwatch(){

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        timeLabel.setBounds(100,100,450,100);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        startButton.setBounds(100,200,150,50);
        startButton.setFont(new Font("Sanserif", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        pauseButton.setBounds(250,200,150,50);
        pauseButton.setFont(new Font("Sanserif", Font.PLAIN, 20));
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(this);

        resetButton.setBounds(400,200,150,50);
        resetButton.setFont(new Font("Sanserif", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);



        frame.setTitle("STOPWATCH");
        frame.add(startButton);
        frame.add(pauseButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton){
            started=true;
            start();    
        }
        if(e.getSource()==pauseButton){
            if(started==true){
                started=false;
                pauseButton.setText("RESUME");
                stop();
            }
            else{
                started=true;
                pauseButton.setText("PAUSE");
                timer.start();

            }
        }
        if(e.getSource()==resetButton){
            started=false;
            startButton.setText("START");
            reset();
        }

    }
    void start() {
        startTime = System.currentTimeMillis() - elapsedTime;
        timer.start();
    }
    void updateDisplay() {
        hours = (elapsedTime / 3600000);
        minutes = (elapsedTime / 60000) % 60;
        seconds = (elapsedTime / 1000) % 60;
        milliseconds = (elapsedTime) % 1000;
        String seconds_string = String.format("%02d", seconds);
        String milliseconds_string = String.format("%03d", milliseconds);
        String minutes_string = String.format("%02d", minutes);
        String hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
    }
    void stop(){

        timer.stop();
    }
    void reset(){
        timer.stop();
        elapsedTime=0;
        milliseconds=0;
        seconds=0;
        minutes=0;
        hours=0;
        seconds_string = String.format("%02d", seconds);
        milliseconds_string = String.format("%03d", milliseconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
    }
    public void setVisible(boolean b) {
    }
}
