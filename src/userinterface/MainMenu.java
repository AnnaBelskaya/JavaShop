package userinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import customers.User;
import javafx.scene.text.Text;
import mailing.EmailUI;
import customers.UserUI;
import storehouse.Goods;
import storehouse.food.Sweets;
import userinterface.tables.AddItem;
import userinterface.tables.TableBuilder;

public class MainMenu {
    private EmailUI email = new EmailUI();
    private UserUI users = new UserUI();
    private TableBuilder tableBuilder;

    //Buttons
    Button addItem = new Button("Add Item");
    Button deleteItem = new Button("Delete Item");

    private HBox hBox;

    //Tables
    public static ObservableList<User> allUsers;

    public void showMenu(Pane root){
        Image image = new Image("file:MainWindow.jps");
        ImageView backgroundImage = new ImageView(image);
        root.getChildren().add(backgroundImage);

        tableBuilder = new TableBuilder(root);
        getUser();
        addLabels(root);
        createButtonsSet(root);
    }


    private void addLabels(Pane root){
        Label sendEmail = new Label("Send User\n an E-mail");
        sendEmail.setFont(new Font("Colibri", 17));
        sendEmail.setOnMouseClicked(event -> {
            email.show();
        });

        Label userList = new Label("  Open  \nUser List");
        userList.setFont(new Font("Colibri", 17));
        userList.setOnMouseClicked(event -> {
            users.show();
        });

        HBox hBox = new HBox();
        hBox.setTranslateX(700);
        hBox.setTranslateY(10);
        hBox.setSpacing(70);
        hBox.getChildren().addAll(userList, sendEmail);

        root.getChildren().add(hBox);
    }

    //get all of the users
    public void getUser(){
        allUsers = FXCollections.observableArrayList();
        allUsers.add(new User(0,"Elvis Presley (example)","presley@gmail.com",
                "21/12/1968",true));
        allUsers.add(new User(1,"Johny Cash (example)","cash@gmail.com",
                "03/07/1975", false));
    }

    private void createButtonsSet(Pane root){
        deleteItem.setOnMouseClicked(e -> deleteButtonClicked());
        deleteItem.setFont(new Font("Arial", 16));
        deleteItem.setMinSize(80,40);

        addItem.setOnMouseClicked(e -> addButtonClicked());
        addItem.setMinSize(80,40);
        addItem.setFont(new Font("Arial", 16));

        hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(50);
        hBox.getChildren().addAll(addItem,deleteItem);
        hBox.setTranslateX(700);
        hBox.setTranslateY(410);

        root.getChildren().add(hBox);
    }

    //Delete button clicked
    private void deleteButtonClicked(){
        Object item = tableBuilder.basicTable.mainTable.getSelectionModel().getSelectedItem();

        TableBuilder.allGoods.remove(item);
        TableBuilder.fizzyDrinksList.remove(item);
        TableBuilder.sweetsList.remove(item);
        TableBuilder.clothesList.remove(item);
        TableBuilder.veggiesList.remove(item);
        TableBuilder.waterList.remove(item);
        TableBuilder.pcList.remove(item);
        TableBuilder.smartphonesList.remove(item);
    }

    //Add button clicked
    private void addButtonClicked(){
        AddItem addProduct = new AddItem();
        addProduct.show();
    }
}