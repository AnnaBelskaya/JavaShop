package userinterface.tables;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import storehouse.Goods;

public class BasicTable {
    public static TableView mainTable;

    //Columns
    private TableColumn<Goods,String> productionDateColumn, temperatureColumn,
            shelfLifeColumn, sortColumn,
            memoryColumn, ddrColumn, kernelsColumn, frequencyColumn,
            warrantyColumn,
            osColumn, screenSizeColumn, batteryLifeColumn,
            graphicCardColumn, kernelsGCColumn, frequencyGCColumn,
            memoryGCColumn, ddrGCColumn,
            brandNameColumn, yearColumn, workersColumn, countriesColumn;

    private void createTable(Pane root){
        mainTable = new TableView();

        //ID column
        TableColumn<Goods,Integer> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(50);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        //name column
        TableColumn<Goods,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(10);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Quantity column
        TableColumn<Goods,String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(50);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Date column
        TableColumn<Goods,String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(50);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        //Subscription column
        TableColumn<Goods,Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(50);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        mainTable.setItems(TableBuilder.allGoods);
        mainTable.getColumns().addAll(idColumn,nameColumn,quantityColumn,
                descriptionColumn,priceColumn);

        Label label = new Label("Products:");
        label.setFont(new Font("Arial", 18));

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, mainTable);
        vbox.setMaxWidth(750);
        vbox.setMinWidth(750);
        vbox.setMaxHeight(340);
        vbox.setTranslateX(220);
        vbox.setTranslateY(70);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        root.getChildren().add(vbox);
    }
    public void createBasicTable(Pane root) {
        createTable(root);
    }

    public void createFoodTable(Pane root){
        createTable(root);
        productionDateColumn = new TableColumn<>("Production date");
        productionDateColumn.setMinWidth(50);
        productionDateColumn.setCellValueFactory(new PropertyValueFactory<>("productionDate"));

        temperatureColumn = new TableColumn<>("Storage temperature");
        temperatureColumn.setMinWidth(50);
        temperatureColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));

        shelfLifeColumn = new TableColumn<>("Storage period");
        shelfLifeColumn.setMinWidth(50);
        shelfLifeColumn.setCellValueFactory(new PropertyValueFactory<>("shelfLife"));

        mainTable.getColumns().addAll(productionDateColumn,
                temperatureColumn,shelfLifeColumn);

    }

    public void createVeggiesTable(Pane root) {
        createFoodTable(root);
        sortColumn = new TableColumn<>("Sort");
        sortColumn.setMinWidth(50);
        sortColumn.setCellValueFactory(new PropertyValueFactory<>("sort"));
        mainTable.getColumns().add(sortColumn);
    }

    private void createHardwareTable(Pane root) {
        memoryColumn = new TableColumn<>("RAM");
        memoryColumn.setMinWidth(50);
        memoryColumn.setCellValueFactory(new PropertyValueFactory<>("memory"));

        ddrColumn = new TableColumn<>("DDR");
        ddrColumn.setMinWidth(50);
        ddrColumn.setCellValueFactory(new PropertyValueFactory<>("ddr"));

        kernelsColumn = new TableColumn<>("Kernels");
        kernelsColumn.setMinWidth(50);
        kernelsColumn.setCellValueFactory(new PropertyValueFactory<>("kernels"));

        frequencyColumn = new TableColumn<>("Frequency");
        frequencyColumn.setMinWidth(50);
        frequencyColumn.setCellValueFactory(new PropertyValueFactory<>("frequency"));

        warrantyColumn = new TableColumn<>("Warranty");
        warrantyColumn.setMinWidth(50);
        warrantyColumn.setCellValueFactory(new PropertyValueFactory<>("warranty"));

        mainTable.getColumns().addAll(memoryColumn, ddrColumn, kernelsColumn,
                frequencyColumn, warrantyColumn);
    }

    public void createSmartphoneTable(Pane root){
        createHardwareTable(root);
        osColumn = new TableColumn<>("OS");
        osColumn.setMinWidth(50);
        osColumn.setCellValueFactory(new PropertyValueFactory<>("os"));

        screenSizeColumn = new TableColumn<>("Screen Size");
        screenSizeColumn.setMinWidth(50);
        screenSizeColumn.setCellValueFactory(new PropertyValueFactory<>("screenSize"));

        batteryLifeColumn = new TableColumn<>("Battery Life");
        batteryLifeColumn.setMinWidth(50);
        batteryLifeColumn.setCellValueFactory(new PropertyValueFactory<>("batteryLife"));

        mainTable.getColumns().addAll(osColumn, screenSizeColumn, batteryLifeColumn);
    }

    public void createPCTable(Pane root){
        createHardwareTable(root);
        graphicCardColumn = new TableColumn<>("Graphic Card");
        graphicCardColumn.setMinWidth(50);
        graphicCardColumn.setCellValueFactory(new PropertyValueFactory<>("graphicCard"));

        kernelsGCColumn = new TableColumn<>("GC Kernels");
        kernelsGCColumn.setMinWidth(50);
        kernelsGCColumn.setCellValueFactory(new PropertyValueFactory<>("kernelsGC"));

        frequencyGCColumn = new TableColumn<>("GC Frequency");
        frequencyGCColumn.setMinWidth(50);
        frequencyGCColumn.setCellValueFactory(new PropertyValueFactory<>("frequencyGC"));

        memoryGCColumn = new TableColumn<>("GC RAM");
        memoryGCColumn.setMinWidth(50);
        memoryGCColumn.setCellValueFactory(new PropertyValueFactory<>("memoryGC"));

        ddrGCColumn = new TableColumn<>("GC DDR");
        ddrGCColumn.setMinWidth(50);
        ddrGCColumn.setCellValueFactory(new PropertyValueFactory<>("ddrGC"));


        mainTable.getColumns().addAll(graphicCardColumn, kernelsGCColumn,
                frequencyGCColumn, memoryGCColumn, ddrGCColumn);
    }

    public void createClothesTable(Pane root){
        createTable(root);
        brandNameColumn = new TableColumn<>("Brand Name");
        brandNameColumn.setCellValueFactory(new PropertyValueFactory<>("brandname"));

        yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        workersColumn = new TableColumn<>("Workers");
        workersColumn.setCellValueFactory(new PropertyValueFactory<>("workers"));

        countriesColumn = new TableColumn<>("Countries");
        countriesColumn.setCellValueFactory(new PropertyValueFactory<>("countries"));

        mainTable.getColumns().addAll(brandNameColumn, yearColumn,
                workersColumn, countriesColumn);
    }

    public void removeColumns(){
        try {
            mainTable.getColumns().removeAll(productionDateColumn,
                    temperatureColumn, shelfLifeColumn, sortColumn,
                    memoryColumn, ddrColumn, kernelsColumn, frequencyColumn,
                    warrantyColumn,
                    osColumn, screenSizeColumn, batteryLifeColumn,
                    graphicCardColumn, kernelsGCColumn, frequencyGCColumn,
                    memoryGCColumn, ddrGCColumn,
                    brandNameColumn, yearColumn, workersColumn, countriesColumn);
        } catch (NullPointerException e) {}
    }
}