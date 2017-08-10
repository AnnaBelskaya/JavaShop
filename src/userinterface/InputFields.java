package userinterface;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import storehouse.clothes.Clothes;
import storehouse.food.FizzyDrinks;
import storehouse.food.Sweets;
import storehouse.food.Veggies;
import storehouse.food.Water;
import storehouse.hardware.PC;
import storehouse.hardware.Smartphone;
import userinterface.tables.BasicTable;
import userinterface.tables.TableBuilder;

public class InputFields {
    private ChoiceBox chooseCategory = new ChoiceBox();
    private Button addBtn = new Button("Add item");

    private Pane pane;
    private TextField nameInput = new TextField();
    private TextField quantityInput = new TextField();
    private TextField descriptionInput = new TextField();
    private TextField priceInput = new TextField();

    private TextField productionDateInput = new TextField();
    private TextField temperatureInput = new TextField();
    private TextField shelflifeInput = new TextField();

    private TextField sortInput = new TextField();
    private TextField[] foodInput = new TextField[]{productionDateInput,
            temperatureInput, shelflifeInput};

    private TextField brandNameInput = new TextField();
    private TextField yearInput = new TextField();
    private TextField countriesInput = new TextField();
    private TextField workersInput = new TextField();
    private TextField[] clothesInput = new TextField[]{
            brandNameInput, yearInput, countriesInput, workersInput};


    private TextField memoryInput = new TextField();
    private TextField ddrInput = new TextField();
    private TextField frequencyInput = new TextField();
    private TextField kernelsInput = new TextField();
    private TextField warrantyInput = new TextField();

    private TextField osInput = new TextField();
    private TextField screensizeInput = new TextField();
    private TextField batteryInput = new TextField();

    private TextField[] smartphoneInput = new TextField[]{
            memoryInput, ddrInput, frequencyInput, kernelsInput,
            warrantyInput, osInput, screensizeInput, batteryInput};

    private TextField graphicCardInput = new TextField();
    private TextField kernelsGCInput = new TextField();
    private TextField frequencyGCInput = new TextField();
    private TextField memoryGCInput = new TextField();
    private TextField ddrGCInput = new TextField();

    private TextField[] pcInput = new TextField[]{graphicCardInput,
            kernelsGCInput, frequencyGCInput, memoryGCInput, ddrGCInput,
            memoryInput, ddrInput, frequencyInput, kernelsInput,
            warrantyInput};

    private VBox basicVBox = new VBox();
    private VBox foodVBox = new VBox();
    private VBox clothesVBox = new VBox();
    private VBox hardwareVBox = new VBox();


    public InputFields(Pane pane) {
        this.pane = pane;

        createInputFields();
        createChoiceBox();
        initialize();
    }

    private void initialize() {
        Label label = new Label("Choose category: ");
        Label general = new Label("General:");
        Label smartphone = new Label("Smartphone Info:");
        Label graphicCard = new Label("Graphic card:");

        addBtn.setMinSize(80, 40);
        addBtn.setTranslateX(40);
        addBtn.setTranslateY(350);
        addBtn.setOnMouseClicked(e -> addFizzyDrink());

        //Smartphone
        HBox hw1 = new HBox();
        hw1.setSpacing(10);
        hw1.setMaxWidth(180);
        hw1.getChildren().addAll(memoryInput, ddrInput);

        HBox hw2 = new HBox();
        hw2.setSpacing(10);
        hw2.setMaxWidth(180);
        hw2.getChildren().addAll(frequencyInput, kernelsInput);

        HBox hw3 = new HBox();
        hw3.setSpacing(10);
        hw3.setMaxWidth(180);
        hw3.getChildren().addAll(osInput, screensizeInput);

        //PC
        HBox hw4 = new HBox();
        hw4.setSpacing(10);
        hw4.setMaxWidth(180);
        hw4.getChildren().addAll(graphicCardInput, kernelsGCInput);

        HBox hw5 = new HBox();
        hw5.setSpacing(10);
        hw5.setMaxWidth(180);
        hw5.getChildren().addAll(frequencyGCInput, memoryGCInput);


        VBox categoryBox = new VBox();
        categoryBox.setSpacing(5);
        categoryBox.getChildren().addAll(label, chooseCategory);

        basicVBox.getChildren().addAll(categoryBox, nameInput,
                quantityInput, descriptionInput, priceInput);

        basicVBox.setTranslateX(40);
        basicVBox.setTranslateY(60);
        basicVBox.setSpacing(15);

        foodVBox.getChildren().addAll(productionDateInput, shelflifeInput, temperatureInput, sortInput);
        foodVBox.setTranslateX(270);
        foodVBox.setTranslateY(60);
        foodVBox.setSpacing(10);

        clothesVBox.getChildren().addAll(brandNameInput, yearInput,
                countriesInput, workersInput);
        clothesVBox.setTranslateX(270);
        clothesVBox.setTranslateY(270);
        clothesVBox.setSpacing(10);

        hardwareVBox.setTranslateX(480);
        hardwareVBox.setTranslateY(60);
        hardwareVBox.setSpacing(10);
        hardwareVBox.getChildren().addAll(general, hw1, hw2, warrantyInput,
                smartphone, hw3, batteryInput, graphicCard,
                hw4, hw5, ddrGCInput);
    }

    public void addToTheForm() {
        pane.getChildren().addAll(addBtn, basicVBox, foodVBox, clothesVBox,
                hardwareVBox);
    }

    private void createInputFields() {
        nameInput.setPromptText("Name");
        quantityInput.setPromptText("Quantity");
        descriptionInput.setPromptText("Description");
        priceInput.setPromptText("Price");

        productionDateInput.setPromptText("Production date");
        temperatureInput.setPromptText("Storage temperature");
        shelflifeInput.setPromptText("Storage period");
        sortInput.setPromptText("Sort");
        sortInput.setDisable(true);

        brandNameInput.setPromptText("Brand name");
        brandNameInput.setDisable(true);
        yearInput.setPromptText("Comp. foundation year");
        yearInput.setDisable(true);
        countriesInput.setPromptText("Countries number");
        countriesInput.setDisable(true);
        workersInput.setPromptText("Workers number");
        workersInput.setDisable(true);

        memoryInput.setPromptText("Ram");
        memoryInput.setDisable(true);
        ddrInput.setPromptText("DDR");
        ddrInput.setDisable(true);
        frequencyInput.setPromptText("Frequency");
        frequencyInput.setDisable(true);
        kernelsInput.setPromptText("Kernels");
        kernelsInput.setDisable(true);
        warrantyInput.setPromptText("Warranty");
        warrantyInput.setDisable(true);

        osInput.setPromptText("OS");
        osInput.setDisable(true);
        screensizeInput.setPromptText("Screen size");
        screensizeInput.setDisable(true);
        batteryInput.setPromptText("Battery life");
        batteryInput.setDisable(true);

        graphicCardInput.setPromptText("Graphic card");
        graphicCardInput.setDisable(true);
        kernelsGCInput.setPromptText("Kernels");
        kernelsGCInput.setDisable(true);
        frequencyGCInput.setPromptText("Frequency");
        frequencyGCInput.setDisable(true);
        memoryGCInput.setPromptText("Memory");
        memoryGCInput.setDisable(true);
        ddrGCInput.setPromptText("DDR");
        ddrGCInput.setDisable(true);
    }

    private void createChoiceBox() {
        chooseCategory.setStyle("-fx-background-color: orange;" +
                "-fx-focus-color: #0093FF");
        chooseCategory.getItems().addAll("Fizzy Drinks",
                "Sweets", "Vegetables", "Water", new Separator(), "Clothes",
                new Separator(), "Smartphone", "PC");
        chooseCategory.getSelectionModel().selectFirst();
        chooseCategory.setMinWidth(150);

        chooseCategory.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue ov, Number value, Number new_value) {
                        accessByDefault();
                        if (ov.getValue().equals(0)) {
                            for (int i = 0; i < foodInput.length; i++)
                                foodInput[i].setDisable(false);
                            addBtn.setOnMouseClicked(e -> addFizzyDrink());
                        }

                        if (ov.getValue().equals(1)) {
                            for (int i = 0; i < foodInput.length; i++)
                                foodInput[i].setDisable(false);
                            addBtn.setOnMouseClicked(e -> addSweets());
                        }

                        if (ov.getValue().equals(2)) {
                            for (int i = 0; i < foodInput.length; i++)
                                foodInput[i].setDisable(false);
                            sortInput.setDisable(false);
                            addBtn.setOnMouseClicked(e -> addVeggies());
                        }

                        if (ov.getValue().equals(3)) {
                            addBtn.setOnMouseClicked(e -> addWater());
                        }

                        if (ov.getValue().equals(5)) {
                            for (int i = 0; i < clothesInput.length; i++)
                                clothesInput[i].setDisable(false);
                            addBtn.setOnMouseClicked(e -> addClothes());
                        }

                        if (ov.getValue().equals(7)) {
                            for (int i = 0; i < smartphoneInput.length; i++)
                                smartphoneInput[i].setDisable(false);
                            addBtn.setOnMouseClicked(e -> addSmartphone());

                        }

                        if (ov.getValue().equals(8)) {
                            for (int i = 0; i < pcInput.length; i++)
                                pcInput[i].setDisable(false);
                            addBtn.setOnMouseClicked(e -> addPC());
                        }
                    }
                });
    }

    private void accessByDefault() {
        sortInput.setDisable(true);
        for (int i = 0; i < pcInput.length; i++)
            pcInput[i].setDisable(true);
        for (int i = 0; i < smartphoneInput.length; i++)
            smartphoneInput[i].setDisable(true);
        for (int i = 0; i < foodInput.length; i++)
            foodInput[i].setDisable(true);
        for (int i = 0; i < clothesInput.length; i++)
            clothesInput[i].setDisable(true);
    }

    private void addWater() {

        TableBuilder.waterList.add(new Water(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText())));

        TableBuilder.allGoods.add(new Water(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText())));

        nameInput.clear();
        quantityInput.clear();
        descriptionInput.clear();
        priceInput.clear();
    }

    private void addFizzyDrink() {

        TableBuilder.fizzyDrinksList.add(new FizzyDrinks(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText()),
                productionDateInput.getText(),
                Double.parseDouble(temperatureInput.getText()),
                Integer.parseInt(shelflifeInput.getText())));

        TableBuilder.allGoods.add(TableBuilder.fizzyDrinksList.get(
                TableBuilder.fizzyDrinksList.size() - 1));
        nameInput.clear();
        quantityInput.clear();
        descriptionInput.clear();
        priceInput.clear();
        productionDateInput.clear();
        temperatureInput.clear();
        shelflifeInput.clear();
    }

    private void addSweets() {

        TableBuilder.sweetsList.add(new Sweets(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText()),
                productionDateInput.getText(),
                Double.parseDouble(temperatureInput.getText()),
                Integer.parseInt(shelflifeInput.getText())));

        TableBuilder.allGoods.add(TableBuilder.sweetsList.get(
                TableBuilder.sweetsList.size() - 1));
        nameInput.clear();
        quantityInput.clear();
        descriptionInput.clear();
        priceInput.clear();
        productionDateInput.clear();
        temperatureInput.clear();
        shelflifeInput.clear();
    }

    private void addVeggies() {
        TableBuilder.veggiesList.add(new Veggies(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText()),
                productionDateInput.getText(),
                Double.parseDouble(temperatureInput.getText()),
                Integer.parseInt(shelflifeInput.getText()),
                sortInput.getText()));

        TableBuilder.allGoods.add(TableBuilder.veggiesList.get(
                TableBuilder.veggiesList.size() - 1));
        nameInput.clear();
        quantityInput.clear();
        descriptionInput.clear();
        priceInput.clear();
        productionDateInput.clear();
        temperatureInput.clear();
        shelflifeInput.clear();
        sortInput.clear();
    }

    private void addClothes() {
        TableBuilder.clothesList.add(new Clothes(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText()),
                brandNameInput.getText(),
                Integer.parseInt(yearInput.getText()),
                Integer.parseInt(workersInput.getText()),
                Integer.parseInt(countriesInput.getText())
        ));

        TableBuilder.allGoods.add(TableBuilder.clothesList.get(
                TableBuilder.clothesList.size() - 1));
        nameInput.clear();
        quantityInput.clear();
        descriptionInput.clear();
        priceInput.clear();

        brandNameInput.clear();
        yearInput.clear();
        workersInput.clear();
        countriesInput.clear();
    }
    private void addSmartphone() {
        TableBuilder.smartphonesList.add(new Smartphone(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText()),

                Float.parseFloat(memoryInput.getText()),
                ddrInput.getText(),
                Integer.parseInt(kernelsInput.getText()),
                Integer.parseInt(frequencyInput.getText()),
                Integer.parseInt(warrantyInput.getText()),
                osInput.getText(),
                screensizeInput.getText(),
                Integer.parseInt(batteryInput.getText())
                ));

        TableBuilder.allGoods.add(TableBuilder.smartphonesList.get(
                TableBuilder.smartphonesList.size() - 1));
        nameInput.clear();
        quantityInput.clear();
        descriptionInput.clear();
        priceInput.clear();

        memoryInput.clear();
        ddrInput.clear();
        frequencyInput.clear();
        kernelsInput.clear();
        warrantyInput.clear();

        osInput.clear();
        screensizeInput.clear();
        batteryInput.clear();
    }

    private void addPC() {
        TableBuilder.pcList.add(new PC(TableBuilder.allGoods.size(),
                nameInput.getText(),
                Integer.parseInt(quantityInput.getText()),
                descriptionInput.getText(),
                Double.parseDouble(priceInput.getText()),

                Float.parseFloat(memoryInput.getText()),
                ddrInput.getText(),
                Integer.parseInt(kernelsInput.getText()),
                Integer.parseInt(frequencyInput.getText()),
                Integer.parseInt(warrantyInput.getText()),

                graphicCardInput.getText(),
                Integer.parseInt(kernelsGCInput.getText()),
                Integer.parseInt(frequencyGCInput.getText()),
                Float.parseFloat(memoryGCInput.getText()),
                ddrGCInput.getText()
        ));

        TableBuilder.allGoods.add(TableBuilder.smartphonesList.get(
                TableBuilder.smartphonesList.size() - 1));
        nameInput.clear();
        quantityInput.clear();
        descriptionInput.clear();
        priceInput.clear();

        memoryInput.clear();
        ddrInput.clear();
        frequencyInput.clear();
        kernelsInput.clear();
        warrantyInput.clear();

        graphicCardInput.clear();
        kernelsGCInput.clear();
        frequencyGCInput.clear();
        memoryGCInput.clear();
        ddrGCInput.clear();
    }
}

