package userinterface.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import storehouse.Goods;
import storehouse.clothes.Clothes;
import storehouse.food.FizzyDrinks;
import storehouse.food.Sweets;
import storehouse.food.Veggies;
import storehouse.food.Water;
import storehouse.hardware.PC;
import storehouse.hardware.Smartphone;
import userinterface.BasicGoodsList;
import userinterface.InputFields;

public class TableBuilder {
    public static ObservableList<Goods> allGoods = FXCollections.observableArrayList();

    public static ObservableList<FizzyDrinks> fizzyDrinksList;
    public static ObservableList<Sweets> sweetsList;
    public static ObservableList<Clothes> clothesList;
    public static ObservableList<Veggies> veggiesList;
    public static ObservableList<Water> waterList;
    public static ObservableList<PC> pcList;
    public static ObservableList<Smartphone> smartphonesList;

    private Pane pane;
    public BasicTable basicTable;
    private BasicGoodsList basicGoodsList;

    public TreeView<String> tree;
    public TreeItem<String> root, food, hardware, clothes,
        fizzyDrinks, sweets, veggies, water,
        pc, smartphone;

    public TableBuilder(Pane pane) {
        this.pane = pane;
        basicTable = new BasicTable();
        basicGoodsList = new BasicGoodsList();
        basicGoodsList.fillObservableList();
        basicTable.createBasicTable(pane);
        basicTable.mainTable.setItems(allGoods);
        initialize();
        mouseClick();
    }

    private void initialize(){
        tree = new TreeView<>();
        ImageView waterImage = new ImageView(new Image("file:water.png"));
        ImageView drinksImage = new ImageView(new Image("file:drinks.png"));
        ImageView sweetsImage = new ImageView(new Image("file:sweets.png"));
        ImageView veggiesImage = new ImageView(new Image("file:veggies.png"));
        ImageView clothesImage = new ImageView(new Image("file:clothes.png"));
        ImageView smartphoneImage = new ImageView(new Image("file:smartphone.png"));
        ImageView pcImage = new ImageView(new Image("file:pc.png"));

        fizzyDrinks = new TreeItem<>("Fizzy drinks", drinksImage);
        root = new TreeItem<>("All Items");
        root.setExpanded(true);

        food = new TreeItem<>("Food");
        hardware = new TreeItem<>("Hardware");
        clothes = new TreeItem<>("Clothes", clothesImage);
        root.getChildren().addAll(food, hardware, clothes);

        sweets = new TreeItem<>("Sweets", sweetsImage);
        veggies = new TreeItem<>("Vegetables", veggiesImage);
        water = new TreeItem<>("Water", waterImage);
        food.getChildren().addAll(fizzyDrinks, sweets, veggies, water);
        food.setExpanded(true);


        pc = new TreeItem<>("PC", pcImage);
        smartphone = new TreeItem<>("Smartphone", smartphoneImage);
        hardware.getChildren().addAll(pc, smartphone);
        hardware.setExpanded(true);

        tree.setRoot(root);
        tree.setMaxHeight(400);
        tree.setPrefWidth(200);

        Label label = new Label("Product categories");
        label.setFont(new Font(16));

        VBox vBox = new VBox();
        vBox.setTranslateX(10);
        vBox.setTranslateY(80);
        vBox.setSpacing(0);
        vBox.getChildren().addAll(label,tree);

        pane.getChildren().add(vBox);
    }

    private void mouseClick(){
            tree.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                    TreeItem<String> item = tree.getSelectionModel().getSelectedItem();
                    basicTable.removeColumns();
                    try {
                    switch (item.getValue()) {
                        case ("All Items"):
                            basicTable.createBasicTable(pane);
                            basicTable.mainTable.setItems(allGoods);
                            break;
                        case ("Water"):
                            basicTable.createBasicTable(pane);
                            basicTable.mainTable.setItems(waterList);
                            break;
                        case ("Fizzy drinks"):
                            basicTable.createFoodTable(pane);
                            basicTable.mainTable.setItems(fizzyDrinksList);
                            break;
                        case ("Sweets"):
                            basicTable.createFoodTable(pane);
                            basicTable.mainTable.setItems(sweetsList);
                            break;
                        case ("Vegetables"):
                            basicTable.createVeggiesTable(pane);
                            basicTable.mainTable.setItems(veggiesList);
                            break;
                        case ("Smartphone"):
                            basicTable.createSmartphoneTable(pane);
                            basicTable.mainTable.setItems(smartphonesList);
                            break;
                        case ("PC"):
                            basicTable.createPCTable(pane);
                            basicTable.mainTable.setItems(pcList);
                            break;
                        case ("Clothes"):
                            basicTable.createClothesTable(pane);
                            basicTable.mainTable.setItems(clothesList);
                            break;
                    }
                } catch (NullPointerException e){ }
            }
        } );
    }
}
