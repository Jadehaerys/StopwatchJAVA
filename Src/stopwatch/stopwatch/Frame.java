package stopwatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import stopwatch.Frame;

public class Frame extends JFrame {

    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    JButton exitButton = new JButton();
    JLabel startLabel = new JLabel();
    JLabel stopLabel = new JLabel();
    JLabel elapsedLabel = new JLabel();
    JTextField startTextField = new JTextField();
    JTextField stopTextField = new JTextField();
    JTextField elapsedTextField = new JTextField();

    long startTime;
    long stopTime;
    double elapsedTime;

    public Frame() {
        // Frame constructor
        

        setTitle("Clocky Stopwatch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setLayout(new GridBagLayout()); // add controls

        GridBagConstraints gridConstraints = new GridBagConstraints();
        startButton.setText("Start Timer");

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;

        add(startButton, gridConstraints);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                startButtonActionPerformed(e);
            }
        });


        stopButton.setText("Stop Timer");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;

        add(stopButton, gridConstraints);

        stopButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                
                stopButtonActionPerformed(e);

            }


        });

        exitButton.setText("Exit");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
    
        add(exitButton, gridConstraints);

        exitButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                exitButtonActionPerformed(e);
            }

        });

        startLabel.setText("Start Time");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;

        add(startLabel, gridConstraints);

        stopLabel.setText("Stop Time");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;

        add(stopLabel, gridConstraints);

        elapsedLabel.setText("Elapsed Time (sec)");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;

        add(elapsedLabel, gridConstraints);

        startTextField.setText("");
        startTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;

        add(startTextField, gridConstraints);

        stopTextField.setText("");
        stopTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;

        add(stopTextField, gridConstraints);

        elapsedTextField.setText("");
        elapsedTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;

        add(elapsedTextField, gridConstraints);

        pack();



    }

    private void startButtonActionPerformed(ActionEvent e){

        startTime = System.currentTimeMillis();
        startTextField.setText(String.valueOf(startTime));
        stopTextField.setText("");
        elapsedTextField.setText("");

    }

    private void stopButtonActionPerformed(ActionEvent e){

        stopTime = System.currentTimeMillis();
        stopTextField.setText(String.valueOf(stopTime));
        elapsedTime = (stopTime - startTime) / 1000.0;
        elapsedTextField.setText(String.valueOf(elapsedTime));
    }

    private void exitButtonActionPerformed(ActionEvent e){

        System.exit(0);

    }

    public static void main(String[] args) {
        Frame stopwatchFrame = new Frame();
        stopwatchFrame.setVisible(true);
    }

}
