/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ViewController implements Initializable {

    private final int MAX = 99;
    private final int MIN = 1;

    private int genNum1, genNum2, genNum3, genNum4, genNum5;

    private int selNum1, selNum2, selNum3, selNum4, selNum5;

    @FXML
    private Pane basePane, alertPane;

    @FXML
    private Label label1, label2, label3, label4, label5, result, alertText;

    @FXML
    private TextField input1, input2, input3, input4, input5;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        //We are generating numbers.
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

        //We are setting the generated numbers to the labels.
        label1.setText(String.valueOf(genNum1));
        label2.setText(String.valueOf(genNum2));
        label3.setText(String.valueOf(genNum3));
        label4.setText(String.valueOf(genNum4));
        label5.setText(String.valueOf(genNum5));

        calculate();

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
            basePane.setDisable(false);
            basePane.setOpacity(0.3);
            alertPane.setVisible(true);
            alertText.setText("Nem jó számot adtál meg.");
        }
        return "";
    }

    private int getRandomNumber() {

        int random = (int) (Math.random() * MAX) + MIN;
        if (random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5) {
            return getRandomNumber();
        }

        return random;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
