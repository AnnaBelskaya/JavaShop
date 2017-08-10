package userinterface.tables;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import userinterface.InputFields;


public class AddItem {
    private Pane root = new Pane();
    private Scene scene = new Scene(root);
    private Stage stage = new Stage();
    private InputFields inputFields = new InputFields(root);

    public void show(){
        setStage();
        stage.setScene(scene);
        stage.show();
    }

    private void setStage(){
        scene.getStylesheets().add("buttonStyle.css");
        stage.setWidth(700);
        stage.setHeight(450);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.setTitle("Add New Item");
        stage.getIcons().add(new Image("file:human.png"));
        stage.setAlwaysOnTop(true);

        Image image = new Image("file:InputWindow.jps");
        ImageView backgroundImage = new ImageView(image);

        root.getChildren().add(backgroundImage);
        addElements();
        addButton();
    }

    public void addButton() {
        Button closeBtn = new Button("Close");
        closeBtn.setMinSize(80,40);

        closeBtn.setOnAction(actionEvent -> stage.close());
        closeBtn.setTranslateX(130);
        closeBtn.setTranslateY(350);

        root.getChildren().add(closeBtn);
    }

    private void addElements(){
        inputFields.addToTheForm();
    }
}
