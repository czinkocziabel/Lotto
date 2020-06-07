/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ViewController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="Class Variables">
    private final int MAX = 99;
    private final int MIN = 1;

    private final int[] genNum = new int[5];

    private int selNum1, selNum2, selNum3, selNum4, selNum5;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="FXML Items">
    @FXML
    private Pane basePane, alertPane;

    @FXML
    private Label label1, label2, label3, label4, label5, resultLabel, alertText;

    @FXML
    private TextField input1, input2, input3, input4, input5;
//</editor-fold>

    @FXML
    private void handleButtonAction(ActionEvent event) {

        //We are generating numbers.
        genNum[0] = 0;
        genNum[1] = 0;
        genNum[2] = 0;
        genNum[3] = 0;
        genNum[4] = 0;
        genNum[0] = getRandomNumber();
        genNum[1] = getRandomNumber();
        genNum[2] = getRandomNumber();
        genNum[3] = getRandomNumber();
        genNum[4] = getRandomNumber();

        //We are setting the generated numbers to the labels.
        label1.setText(String.valueOf(genNum[0]));
        label2.setText(String.valueOf(genNum[1]));
        label3.setText(String.valueOf(genNum[2]));
        label4.setText(String.valueOf(genNum[3]));
        label5.setText(String.valueOf(genNum[4]));

        calculate();

    }

    @FXML
    private void alertButtonAction(ActionEvent event) {
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertText.setText("");
        alertPane.setVisible(false);
    }

    private String calculate() {
        try {
            //We are gathernig the numbers.
            selNum1 = Integer.parseInt(input1.getText());
            selNum2 = Integer.parseInt(input2.getText());
            selNum3 = Integer.parseInt(input3.getText());
            selNum4 = Integer.parseInt(input4.getText());
            selNum5 = Integer.parseInt(input5.getText());
        } catch (Exception e) {
            alert("Nem jó számot adtál meg.");
            return "";
        }
        if (selNum1 < 1 || selNum1 > 99 || selNum2 < 1 || selNum2 > 99 || selNum3 < 1 || selNum3 > 99 || selNum4 < 1 || selNum4 > 99 || selNum5 < 1 || selNum5 > 99) {
            alert("Minden számnak 1 és 99 között kell lennie!");
            return "";
        }

        Set<Integer> selectedNumbers = new HashSet<>();
        selectedNumbers.add(selNum1);
        selectedNumbers.add(selNum2);
        selectedNumbers.add(selNum3);
        selectedNumbers.add(selNum4);
        selectedNumbers.add(selNum5);

        if (selectedNumbers.size() < 5) {
            alert("A számoknak különbözőnek kell lenniük.");
            return "";
        }
        int result = 0;
        for (int i = 0; i < selectedNumbers.size(); i++) {
        if(selectedNumbers.contains(genNum[i])){
        result++;}
        }
        switch(result){
            
            case 0 : resultLabel.setText("Sajnos nincs találatod!");
                    break;
            case 1 : resultLabel.setText("Egyesed van!");
                    break;
            case 2 : resultLabel.setText("Kettesed van!");
                    break;
            case 3 : resultLabel.setText("Hármasod van!");
                    break;
            case 4 : resultLabel.setText("Négyesed van!");
                    break;
            case 5 : resultLabel.setText("Ötösöd van!");
                    break;
                
        }
        return "";

    }

    private void alert(String text) {
        basePane.setDisable(false);
        basePane.setOpacity(0.3);
        alertPane.setVisible(true);
        alertText.setText(text);
    }

    private int getRandomNumber() {

        int random = (int) (Math.random() * MAX) + MIN;
       
        if (random == genNum[0] || random == genNum[1] || random == genNum[2] || random == genNum[3] || random == genNum[4]) {
            return getRandomNumber();
        }

        return random;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
