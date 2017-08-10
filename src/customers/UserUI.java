package customers;

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
import userinterface.MainMenu;

public class UserUI {
    private TableView<User> userTable;

    private TextField nameInput, emailInput, dateInput;
    private CheckBox subscriprionInput;
    private Pane root = new Pane();
    private Scene scene = new Scene(root);
    private Stage stage = new Stage();

    public void show(){
        setStage();
        createTable();
        stage.setScene(scene);
        stage.show();
    }

    private void setStage(){
        stage.setWidth(680);
        stage.setHeight(450);
        stage.setTitle("User Information");
        stage.getIcons().add(new Image("file:human.png"));
    }

    private Label addLabel(){
        final Label label = new Label("User List");
        label.setFont(new Font("Arial", 20));
        return label;
    }

    private void createTable(){
        userTable = new TableView();

        //ID column
        TableColumn<User,Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        //name column
        TableColumn<User,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Email column
        TableColumn<User,String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Date column
        TableColumn<User,String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(50);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //Subscription column
        TableColumn<User,Boolean> subsColumn = new TableColumn<>("Subscription");
        subsColumn.setMinWidth(50);
        subsColumn.setCellValueFactory(new PropertyValueFactory<>("subs"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Email input
        emailInput = new TextField();
        emailInput.setPromptText("Email");
        emailInput.setMinWidth(100);

        //Date input
        dateInput = new TextField();
        dateInput.setPromptText("Date");
        dateInput.setMinWidth(50);

        //Subscription input
        Label label = new Label("Subscription: ");
        label.setFont(new Font(12));
        subscriprionInput = new CheckBox();
        label.setTranslateY(3);
        subscriprionInput.setTranslateY(3);

        //Buttons
        Button addButton = new Button("Add user");
        Button deleteButton = new Button("Delete user");

        addButton.setOnMouseClicked(e -> addButtonClicked());
        deleteButton.setOnMouseClicked(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,emailInput,dateInput,label,subscriprionInput);

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10,10,10,10));
        hBox2.setSpacing(15);
        hBox2.getChildren().addAll(addButton,deleteButton);
        hBox2.setTranslateX(450);

        userTable.setItems(MainMenu.allUsers);
        userTable.getColumns().addAll(idColumn,nameColumn,emailColumn,
                dateColumn,subsColumn);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(addLabel(), userTable,
                hBox,hBox2);
        vbox.setMaxWidth(650);
        vbox.setMinWidth(650);
        vbox.setMaxHeight(400);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        root.getChildren().add(vbox);
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<User> usersSelected;
        usersSelected = userTable.getSelectionModel().getSelectedItems();
        usersSelected.forEach(MainMenu.allUsers::remove);
    }

    //Add button clicked
    public void addButtonClicked(){
        if (!nameInput.getText().equals("") &&
                !emailInput.getText().equals("") &&
                !dateInput.getText().equals("")) {
            try {
                User user = new User();
                if (MainMenu.allUsers.size() == 0)
                    user.setId(0);
                else
                    user.setId(MainMenu.allUsers.get(MainMenu.allUsers.size() - 1).getId() + 1);
                user.setName(nameInput.getText());
                user.setEmail(emailInput.getText());
                user.setDate(dateInput.getText());
                user.setSubs(subscriprionInput.isSelected());
                userTable.getItems().addAll(user);
                nameInput.clear();
                emailInput.clear();
                dateInput.clear();
            } catch (NumberFormatException e) {
            }
        }
    }
}