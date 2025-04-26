package controllers;

import java10.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import models.User;
import models.dto.CreateUserDto;
import services.SceneManager;
import services.UserService;
import utils.SceneLocator;


public class CreateUserController {

    // kur dojm me bo nderlidhje mes kodit dhe fxml: @FXML
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAge;

    private UserService userService;

    public CreateUserController() {
        this.userService = new UserService();
    }


    @FXML
    private void handleCancelClick() throws Exception{
        this.cleanFields();
//        FXMLLoader loader = new FXMLLoader(
//                getClass().getResource("/views/home.fxml")
//        );
//        Parent parent = loader.load();
//
//        Main.scene.setRoot(parent);   // ktu ju kemi qas skenes prej Main te javes10
        SceneManager.load(SceneLocator.HOME_PAGE);
    }

    @FXML
    private void handleSaveClick() {
        // nuk i dhojm mundsi qe kontrolleri direkt me thirr repon, kshtuqe e shtojm ni klase/shtrese te re: servisi; qe ka mundsi me bo validime, pastaj ajo e thirr repon (komunikon me baze te t'dhenave...)
        try {
            User user = this.userService.create(this.getUserData());
            System.out.println("User created successfully!");
            System.out.println("User ID: " + user.getId());
            this.cleanFields();
        } catch (Exception e) {
            System.out.println("Error while creating user!" + e.getMessage());
        }
    }

    private CreateUserDto getUserData(){   // qikjo u kriju veq me bo kodin ma tpastert te handleSaveClick
        String name = this.txtName.getText();
        String email = this.txtEmail.getText();
        int age = Integer.parseInt(this.txtAge.getText());
        return new CreateUserDto(name, email, age);
    }

    private void cleanFields() {
        this.txtName.setText("");
        this.txtEmail.setText("");
        this.txtAge.setText("");
    }

}
