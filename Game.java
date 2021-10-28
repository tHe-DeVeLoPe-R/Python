package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame {

    JTextField result , no_Of_guesses , userInput;
    JLabel result_label , no_of_guesses_label , message , error;
    JButton submit , giveup , replay;
    int trys , system_generated;

    Container screen = getContentPane();

    public void gameInterface(){
        setLayout(null);
        setTitle("GuessGame");
        setResizable(false);
        setBounds(200 , 100 , 1000 , 500);
        screen.setBackground(new Color(170 , 150 , 190));

        result_label = new JLabel("Result:");
        result_label.setForeground(Color.WHITE);
        result_label.setBounds(80 , 10 , 100 , 50);
        result_label.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        screen.add(result_label);

        result = new JTextField("Neutral");
        result.setEditable(false);
        result.setBounds(65 , 60 , 100 , 30);
        result.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        result.setHorizontalAlignment(JTextField.CENTER);
        screen.add(result);

        no_of_guesses_label = new JLabel("No. Of Guesses you have made:");
        no_of_guesses_label.setForeground(Color.WHITE);
        no_of_guesses_label.setBounds(250 , 10 , 400 , 50);
        no_of_guesses_label.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        screen.add(no_of_guesses_label);

        no_Of_guesses = new JTextField("0");
        no_Of_guesses.setEditable(false);
        no_Of_guesses.setBounds(300 , 60 , 170 , 30);
        no_Of_guesses.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        no_Of_guesses.setHorizontalAlignment(JTextField.CENTER);
        screen.add(no_Of_guesses);

        message = new JLabel("I have generated a number in my code lets guess! can you ?...");
        message.setBounds(100 , 170 , 700 , 30);
        message.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        message.setHorizontalAlignment(JTextField.CENTER);
        screen.add(message);

        userInput = new JTextField();
        userInput.setBounds(300 , 230 , 150 , 27);
        userInput.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        userInput.setHorizontalAlignment(JTextField.CENTER);
        screen.add(userInput);

        submit = new JButton("Submit");
        submit.setBounds(310 , 290 , 110 , 40);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setFocusPainted(false);
        submit.setFont(new Font(Font.DIALOG , Font.BOLD , 15));
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);

        screen.add(submit);

        replay = new JButton("Replay");
        replay.setBounds(710 , 290 , 110 , 40);
        replay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        replay.setFocusPainted(false);
        replay.setFont(new Font(Font.DIALOG , Font.BOLD , 15));
        replay.setForeground(Color.white);
        replay.setBackground(Color.DARK_GRAY);

        screen.add(replay);

        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setText(" ");
                trys = 0;
                Random random = new Random();
                system_generated = random.nextInt(100);
                no_Of_guesses.setText("0");
                result.setText("Neutral");
                result.setForeground(Color.BLACK);
            }
        });

        Random random = new Random();
        system_generated = random.nextInt(100);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameBrain();

            }
        });

        error = new JLabel("");
        error.setBounds(250 , 350 , 600 , 20);
        error.setForeground(Color.RED);
        screen.add(error);

        giveup = new JButton("GiveUp");
        giveup.setBounds(710 , 400 , 110 , 40);
        giveup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        giveup.setFocusPainted(false);
        giveup.setFont(new Font(Font.DIALOG , Font.BOLD , 15));
        giveup.setForeground(Color.white);
        giveup.setBackground(Color.RED);
        screen.add(giveup);

        giveup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giveUp();
            }
        });


    //compulsory 2 lines of code to exit on close and to make frame visible
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void gameBrain(){



        try {

            int userGuess = Integer.parseInt(userInput.getText());
            error.setText(" ");

            if (system_generated == userGuess){
               result.setText("Success");
               result.setForeground(Color.GREEN);
               error.setText("You suceeded click replay to restart");
               error.setForeground(Color.GREEN);
            }else{
                result.setText("Failed");
                result.setForeground(Color.RED);
            }

            trys+=1;
            String trys_string_value = String.valueOf(trys);
            no_Of_guesses.setText(trys_string_value);

        }
        catch (Exception e){

            error.setText("wrong input!! only integer numbers are allowed");
        }

    }

    public void giveUp(){
     String system_generated_string = String.valueOf(system_generated);
     result.setForeground(Color.BLUE);
     result.setText(system_generated_string);
    }
}
