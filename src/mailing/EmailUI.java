package mailing;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import customers.User;
import userinterface.MainMenu;

public class EmailUI {
    private SendEmail sendEmail;
    private ObservableList<User> subscribedUsers;
    private TableView<User> userTable;

    private TextField themeInput = new TextField();
    private TextArea emailText = new TextArea();
    private TextField gmailUsername = new TextField();
    private PasswordField gmailPassword = new PasswordField();

    private Pane root = new Pane();
    private Scene scene = new Scene(root);
    private Stage stage = new Stage();

    public void show(){
        setStage();
        createList();
        createTable();
        stage.setScene(scene);
        stage.show();
    }

    private void setStage(){
        stage.setWidth(680);
        stage.setHeight(450);
        stage.setTitle("Send Email");
        stage.getIcons().add(new Image("file:message.png"));
    }

    private void createTable(){
        userTable = new TableView();

        //ID column
        TableColumn<User,Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        //name column
        TableColumn<User,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(250);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Email column
        TableColumn<User,String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(250);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Date column
        TableColumn<User,String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(50);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //Buttons
        Button sendEmail = new Button("Send user an Email");
        sendEmail.setOnMouseClicked(e -> sendEmailButtonClicked());

        Button unsubscribeButton = new Button("Unsubscribe user");
        unsubscribeButton.setOnMouseClicked(e -> unsubscribeButtonClicked());

        themeInput.setPromptText("Theme");

        emailText.setMaxHeight(70);
        userTable.setItems(subscribedUsers);
        userTable.getColumns().addAll(idColumn,nameColumn,emailColumn,
                dateColumn);
        userTable.setMaxHeight(150);
        userTable.setMinHeight(150);

        gmailUsername.setPromptText("Username");
        gmailPassword.setPromptText("Password");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(20);
        hBox.getChildren().addAll(gmailUsername, gmailPassword,
                sendEmail, unsubscribeButton);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(addLabel("User List"), userTable,
                addLabel("New Email"), themeInput, emailText, addLabel("Gmail Account"), hBox);
        vbox.setMaxWidth(650);
        vbox.setMinWidth(650);
        vbox.setMaxHeight(400);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        root.getChildren().addAll(vbox);
    }


    private Label addLabel(String text){
        final Label label = new Label(text);
        label.setFont(new Font("Arial", 18));
        return label;
    }

    private void sendEmailButtonClicked(){
        ObservableList<User> usersSelected = userTable.getSelectionModel().getSelectedItems();
        for (int i = 0; i < usersSelected.size(); i++) {
            sendEmail = new SendEmail(gmailUsername.getText(), gmailPassword.getText(),
                    themeInput.getText(), emailText.getText(),
                    usersSelected.get(i).getEmail());
        }
        sendEmail.send();
        gmailPassword.clear();
        gmailUsername.clear();
        themeInput.clear();
        emailText.clear();
    }

    private void unsubscribeButtonClicked(){
        ObservableList<User> usersSelected;
        usersSelected = userTable.getSelectionModel().getSelectedItems();
        for (int i = 0; i < usersSelected.size(); i++){
            int id = usersSelected.get(i).getId();
            MainMenu.allUsers.get(id).setSubs(false);
        }
        userTable.getItems().removeAll(usersSelected);
    }

    private void createList(){
        subscribedUsers = FXCollections.observableArrayList();
        for (int i = 0; i < MainMenu.allUsers.size(); i++){
            if (MainMenu.allUsers.get(i).isSubs()){
                subscribedUsers.add(MainMenu.allUsers.get(i));
            }
        }
    }
}
