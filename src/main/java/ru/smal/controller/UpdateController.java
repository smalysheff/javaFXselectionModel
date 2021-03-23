package ru.smal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.smal.model.RadioElement;

public class UpdateController {

    public Label idLbl;
    @FXML
    private TextField nameTextFiled;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField descriptionTextField;

    public void setData(RadioElement radioElement){
        if(radioElement != null) {
            idLbl.setText(String.valueOf(radioElement.getId()));
            nameTextFiled.setText(radioElement.getName());
            quantityTextField.setText(String.valueOf(radioElement.getQuantity()));
            descriptionTextField.setText(radioElement.getDescription());
        } else {
            idLbl.setText("");
            nameTextFiled.setText("");
            quantityTextField.setText("");
            descriptionTextField.setText("");
        }

    }
}
