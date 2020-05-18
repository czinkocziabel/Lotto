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

public class ViewController implements Initializable {

    private final int MAX = 99;
    private final int MIN = 1;

    private int num1, num2, num3, num4, num5;

    @FXML
    private Label label1, label2, label3, label4, label5;

    @FXML
    private TextField input1, input2, input3, input4, input5;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        num1 = 0;
        num2 = 0;
        num3 = 0;
        num4 = 0;
        num5 = 0;
        num1 = getRandomNumber();
        num2 = getRandomNumber();
        num3 = getRandomNumber();
        num4 = getRandomNumber();
        num5 = getRandomNumber();
        label1.setText(String.valueOf(num1));
        label2.setText(String.valueOf(num2));
        label3.setText(String.valueOf(num3));
        label4.setText(String.valueOf(num4));
        label5.setText(String.valueOf(num5));
    }

    private int getRandomNumber() {

        int random = (int) (Math.random() * MAX) + MIN;
        if (random == num1 || random == num2 || random == num3 || random == num4 || random == num5) {
            return getRandomNumber();
        }

        return random;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
