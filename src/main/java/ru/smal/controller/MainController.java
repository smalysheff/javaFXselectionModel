package ru.smal.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.smal.dao.Dao;
import ru.smal.model.RadioElement;
import ru.smal.service.RadioElementDaoImpl;

import java.io.IOException;

public class MainController {

    private final SessionFactory factory;
    private final ObservableList<RadioElement> radioElements;
    private RadioElement selectedItem;
    private AnchorPane anchorPane;

    public MainController(){
        factory = new Configuration().configure().buildSessionFactory();
        radioElements = FXCollections.observableArrayList();
    }

    @FXML
    private TableView<RadioElement> tableView;
    @FXML
    private TableColumn<RadioElement, Integer> idCol;
    @FXML
    private TableColumn<RadioElement, String> nameCol;
    @FXML
    private TableColumn<RadioElement, Integer> quantityCol;
    @FXML
    private TableColumn<RadioElement, String> descriptionCol;



    @FXML
    public void initialize(){
        initData();
        tableView.setItems(radioElements);
        idCol.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getId()));
        nameCol.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getName()));
        quantityCol.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getQuantity()));
        descriptionCol.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getDescription()));

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (obj, oldValue, newValue) -> {
                    selectedItem = newValue;
                    System.out.println(newValue);
        });

    }

    public void onActionUpdate(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/update.fxml"));
        anchorPane = loader.load();
        UpdateController updateController = loader.getController();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Update");
        stage.show();

        updateController.setData(selectedItem);
    }

    void initData(){
        Dao<RadioElement, Integer> radioElementDaoImpl = new RadioElementDaoImpl(factory);
        radioElements.addAll(radioElementDaoImpl.findByAll());
    }


}
