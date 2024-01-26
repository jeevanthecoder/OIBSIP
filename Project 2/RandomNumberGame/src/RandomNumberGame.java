import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumberGame {
    private JLabel randomNumberGameLabel;
    private JButton checkButton;
    private JFormattedTextField input;
    private JLabel Rounds;
    private JLabel credits;
    private JLabel Result;
    private JPanel RandomNumber;
    private JLabel Guess;
    private JPanel Main;
    private JPanel GuessInput;
    private JPanel Button;
    private JPanel ResultDisplay;
    private JPanel CredistDisplay;
    private JPanel RoundsDisplay;
    private JLabel AttemptsDisplay;
    private JLabel attemptValue;
    private JPanel AttemptsPanel;
    private JLabel GeneratedValue;
    Random random = new Random();

    public RandomNumberGame(){
        final String[] error = {""};
        checkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                String message = "";
                Random random = new Random();
                int generateValue = 0;
                String rounds = Rounds.getText().trim();
                int currentRound = Integer.parseInt(String.valueOf(rounds.charAt(rounds.length() - 1)));
                int creditpoints = Integer.parseInt(credits.getText());
                int attempts = Integer.parseInt(attemptValue.getText().trim());
                String generatedValue = GeneratedValue.getText();
                String error_message = "";
                try {
                    Integer.parseInt(input.getText());
                } catch (Exception ex) {
                    error_message = ex.toString();
                }
                if (error_message.length() > 1) {
                    Result.setText("Please Enter the Integer Value!!!!!");
                } else {
                    int inputValue = Integer.parseInt(input.getText());

                    String result = Result.getText();

                    System.out.println(generatedValue);


                    if ((currentRound == 3 && attempts == 4) || (currentRound == 3 && inputValue == Integer.parseInt(generatedValue) && result.equals("Well Done !!!Right Answer. Your Total Score is : " + creditpoints))) {
                        Result.setText("Well Done !!!Right Answer. Your Total Score is : " + creditpoints);
                    } else {
//                    System.out.println(creditpoints);
                        if (generatedValue.isEmpty()) {
                            generateValue = random.nextInt(1, 99);
                            System.out.println(generateValue);
                            GeneratedValue.setText(String.valueOf(generateValue));
                            if (inputValue == generateValue) {
                                creditpoints += (creditpoints + 1) * currentRound;
                                System.out.println(creditpoints);
                                credits.setText(String.valueOf(creditpoints));
                                System.out.println(String.valueOf(creditpoints));
                                Rounds.setText("Round : " + (currentRound + 1));
                                attemptValue.setText(String.valueOf(0));
                                Result.setText("Well Done !!!Right Answer");
                            } else {

                                if (inputValue < generateValue)
                                    message = "Entered Value is lesser than the generated value.";
                                else if (inputValue > generateValue)
                                    message = "Entered Value is greater than the generated value";
                                Result.setText("Wrong Answer!!!. " + message);
                                attemptValue.setText(String.valueOf(attempts + 1));

                            }
                        } else {
                            if (attempts == 4) {
                                attempts = -1;
                                if (currentRound + 1 == 2) {
                                    GeneratedValue.setText(String.valueOf(random.nextInt(100, 300)));
                                    Rounds.setText("Round : " + 2);

                                } else if (currentRound + 1 == 3) {
                                    GeneratedValue.setText(String.valueOf(random.nextInt(400, 800)));
                                    Rounds.setText("Round : " + 3);
                                } else {
                                    Result.setText("Game over!!!");
                                }

                            }
//                        System.out.println("GeneratedValue has something!!!");
//                        System.out.println("CurrentRound : " + currentRound);
                            generateValue = Integer.parseInt(generatedValue);
//                        System.out.println(inputValue + " " + generateValue);
                            if (inputValue == generateValue) {
                                if (currentRound + 1 == 2) {
                                    GeneratedValue.setText(String.valueOf(random.nextInt(100, 300)));
                                    Rounds.setText("Round : " + 2);

                                } else if (currentRound + 1 == 3) {
                                    GeneratedValue.setText(String.valueOf(random.nextInt(400, 800)));
                                    Rounds.setText("Round : " + 3);
                                } else {
                                    Result.setText("Game over!!!");
                                }

                                creditpoints += (creditpoints + 1) * currentRound;

//                            System.out.println(creditpoints);
                                credits.setText(String.valueOf(creditpoints));
//                            System.out.println(String.valueOf(creditpoints));
                                attemptValue.setText(String.valueOf(1));
                                if (currentRound == 3)
                                    Result.setText("Well Done !!!Right Answer. Your Total Score is : " + creditpoints);
                                else
                                    Result.setText("Well Done !!!Right Answer");
                            } else {
                                if (inputValue < generateValue)
                                    message = "Entered Value is lesser than the generated value.";
                                else if (inputValue > generateValue)
                                    message = "Entered Value is greater than the generated value";
                                Result.setText("Wrong Answer!!!. " + message);
                                if (attempts == -1) attemptValue.setText("1");
                                else attemptValue.setText(String.valueOf(attempts + 1));

                            }
                        }
                    }
                }
            }

    });
    }
    

    public static void main(String[] args) {
        Random random1 = new Random();
        JFrame frame = new JFrame("RandomNumberGame");
        frame.setContentPane(new RandomNumberGame().RandomNumber);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

//    public void TheGame(String message,int inputTaken){
//        int origin = 1, bound = 100,roundLevelCredit=0,rounds=1;
//
//        while(rounds<3) {
//            roundLevelCredit+=10;
//            final boolean[] flag = {false};
//
//            generatedValue = random.nextInt(origin, bound);
//            while(attempts<=4) {
//                RandomNumberGame randomNumberGame = new RandomNumberGame(message,inputTaken);
//                int finalRoundLevelCredit = roundLevelCredit;
//                if(inputTaken==generatedValue) {
//                                creditPoints+= finalRoundLevelCredit /attempts;
//                                flag[0] =true;
//                                message="Well Done!!";
//
//                            }else{
//
//                                attempts++;
//                                message=(4-attempts)+" remaining!!!\nEnter the correct value.";
//                            }
//
//                            Result.setText(message);
//
//            }
//            if(flag[0]==false){
//                Result.setText("Game over!!!");
//                break;
//            }
//            origin=100;
//            bound=300;
//            credits.setText(String.valueOf(creditPoints));
//            rounds++;
//            Rounds.setText("Round : "+String.valueOf(rounds));
//
//        }
//
//    }

}
