import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guess;
  JButton playAgain;
  JLabel promptGuess;
  JLabel tooHiLow;
  JLabel lastGuess;
  Random rand = new Random();
  int rando = rand.nextInt(100) + 1;

  GuessingGame() {
    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);
    
    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");
    
    guess = new JButton("Guess");
    playAgain = new JButton("Play Again");
    
    userGuess.addActionListener(this);
    guess.addActionListener(this);
    playAgain.addActionListener(this);

    promptGuess = new JLabel("Enter your guess: ");
    tooHiLow = new JLabel("");
    lastGuess = new JLabel("");

    frame.add(promptGuess);
    frame.add(userGuess);
    frame.add(guess);
    frame.add(tooHiLow);
    frame.add(lastGuess);
    frame.add(playAgain);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());
    
      if(guess < rando) {
      tooHiLow.setText("Too low!");
    }

      if(guess > rando) {
      tooHiLow.setText("Too high!");
    }

      if(guess == rando) {
      tooHiLow.setText("You got it!");
    }

      lastGuess.setText("The last guess was " + guess);
    }

    else if(ae.getActionCommand().equals("Play Again")) {
      rando = rand.nextInt(100) + 1;
      
      promptGuess.setText("Enter your guess: ");
      tooHiLow.setText("");
      lastGuess.setText("");
      userGuess.setText("");
    }

    else {
      tooHiLow.setText("You pressed Enter. Please press Guess."); 
    }
  }
}