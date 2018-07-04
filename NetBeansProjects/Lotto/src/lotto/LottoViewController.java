package lotto;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LottoViewController implements Initializable {
    //<editor-fold defaultstate="collapsed" desc="Class Variables">
    private final int MAX = 99;
    private final int MIN = 1;
    
    private final String WIN0 = "You did not win!";
    private final String WIN1 = "You've got one hit on lotto!";
    private final String WIN2 = "You've got two hits on lotto!";
    private final String WIN3 = "Three hits! Now, this is something.";
    private final String WIN4 = "Four hits! Be proud of yourself.";
    private final String WIN5 = "Full lotto hits! Congratulations!";
    
    private int genNum1;
    private int genNum2;
    private int genNum3;
    private int genNum4;
    private int genNum5;
    
    private int selNum1;
    private int selNum2;
    private int selNum3;
    private int selNum4;
    private int selNum5;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="FXML items import">
    @FXML
    private Pane basePane;
    @FXML
    private Pane alertPane;
    @FXML
    private Label alertText;
    @FXML
    private Button alertButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label resultLabel;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
//</editor-fold>
    
    @FXML
    private void handleAlertButton(ActionEvent event) {
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);
        alertText.setText("");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        genNum1 = 0;
        genNum2 = 0;
        genNum3 = 0;
        genNum4 = 0;
        genNum5 = 0;
        genNum1 = getRandomNumber();
        genNum2 = getRandomNumber();
        genNum3 = getRandomNumber();
        genNum4 = getRandomNumber();
        genNum5 = getRandomNumber();   
        calculate();
    }
    
    private void calculate(){
        try{
         selNum1 = Integer.parseInt(input1.getText());
         selNum2 = Integer.parseInt(input2.getText());
         selNum3 = Integer.parseInt(input3.getText());
         selNum4 = Integer.parseInt(input4.getText());
         selNum5 = Integer.parseInt(input5.getText());
        }catch(NumberFormatException e){
            alert("You gave wrong number(s)!");
            System.out.println(e);
            return;
        }
        
        HashSet<Integer> selectedNumbers = new HashSet<>();
        selectedNumbers.add(selNum1);
        selectedNumbers.add(selNum2);
        selectedNumbers.add(selNum3);
        selectedNumbers.add(selNum4);
        selectedNumbers.add(selNum5);
        if (selectedNumbers.size() < 5){
           alert("All numbers have to be different!");
           return;
        }

        ArrayList<Integer> userNumbers = new ArrayList<>(selectedNumbers);

        for (Integer number : userNumbers){
            if (number < MIN || number > MAX){
                alert("All number have to be from 1 to 99!");
                return;
            }
        }
        
        label1.setText("" + genNum1);
        label2.setText("" + genNum2);
        label3.setText("" + genNum3);
        label4.setText("" + genNum4);
        label5.setText("" + genNum5);
        
        resultCheck(userNumbers);
        return;
    }
    
    private void alert(String text){
         basePane.setDisable(true);
         basePane.setOpacity(0.3);
         alertPane.setVisible(true);
         alertText.setText(text);
    }
    
    private void resultCheck(ArrayList<Integer> userNumbers){
        int result = 0;
        for (int i=0; i < userNumbers.size(); i++){
            if (userNumbers.get(i) == genNum1 || userNumbers.get(i) == genNum2 || userNumbers.get(i) == genNum3 || userNumbers.get(i) == genNum4 || userNumbers.get(i) == genNum5)
                result++;
        }
        
        switch(result){
            case 0 : resultLabel.setText(WIN0);
                    break;
            case 1 : resultLabel.setText(WIN1);
                    break;
            case 2 : resultLabel.setText(WIN2);
                    break;
            case 3 : resultLabel.setText(WIN3);
                    break;
            case 4 : resultLabel.setText(WIN4);
                    break;
            case 5 : resultLabel.setText(WIN5);
                    break;
        }
    }
    
    private int getRandomNumber(){
      int random = (int) (Math.random() * MAX) + MIN; 
      if (random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5){
          return getRandomNumber();
      }
      return random;      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      System.out.println("Program started...");  
    }     
}
