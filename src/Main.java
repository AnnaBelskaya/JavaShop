import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import userinterface.MainMenu;

public class Main extends Application{
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 550;
    private Pane root = new Pane();
    private Scene scene = new Scene(root);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        scene.getStylesheets().add("buttonStyle.css");
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Java Store");
        primaryStage.setResizable(false);
        new MainMenu().showMenu(root);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
