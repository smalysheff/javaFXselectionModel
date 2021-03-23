package ru.smal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.smal.dao.Dao;
import ru.smal.model.RadioElement;
import ru.smal.service.RadioElementDaoImpl;

public class UpdateController {

    public Label idLbl;
    public Button buttonUpdate;
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

    public RadioElement getData(){
        RadioElement radioElement = new RadioElement();
        radioElement.setName(nameTextFiled.getText());
        radioElement.setQuantity(Integer.parseInt(quantityTextField.getText()));
        radioElement.setDescription(descriptionTextField.getText());
        return radioElement;
    }

    public void onActionUpdate() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<RadioElement, Integer> radioElementDaoImpl = new RadioElementDaoImpl(factory);
        radioElementDaoImpl.update(getData());
        factory.close();
    }
}
