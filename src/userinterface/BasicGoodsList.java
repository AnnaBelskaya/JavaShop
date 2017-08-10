package userinterface;

import javafx.collections.FXCollections;
import storehouse.clothes.Clothes;
import storehouse.food.FizzyDrinks;
import storehouse.food.Sweets;
import storehouse.food.Veggies;
import storehouse.food.Water;
import storehouse.hardware.PC;
import storehouse.hardware.Smartphone;
import userinterface.tables.BasicTable;
import userinterface.tables.TableBuilder;

public class BasicGoodsList {

    public void fillObservableList(){
        getWater();
        getVeggies();
        getSweets();
        getFizzyDrinks();
        getSmartphone();
        getPC();
        getClothes();
    }

    private void getWater(){
        TableBuilder.waterList = FXCollections.observableArrayList();
        TableBuilder.waterList.add(new Water(0,"Clear Water",100,
                "The clearest water ever",12.60));
        TableBuilder.allGoods.add(TableBuilder.waterList.get(0));
    }

    private void getFizzyDrinks(){
        TableBuilder.fizzyDrinksList = FXCollections.observableArrayList();
        TableBuilder.fizzyDrinksList.add(new FizzyDrinks(TableBuilder.allGoods.size(), "Lemonade",
                700,"Sweet&Cool", 9.50, "10/03/2017",
                4, 1));
        TableBuilder.allGoods.add(TableBuilder.fizzyDrinksList.get(0));
    }

    private void getSweets(){
        TableBuilder.sweetsList = FXCollections.observableArrayList();
        TableBuilder.sweetsList.add(new Sweets(TableBuilder.allGoods.size(),"Milky Way to Mars",
                1000, "Joy for a sweet tooth.", 28.50, "30/05/2017",
                12, 1));
        TableBuilder.allGoods.add(TableBuilder.sweetsList.get(0));
    }

    private void getVeggies(){
        TableBuilder.veggiesList = FXCollections.observableArrayList();
        TableBuilder.veggiesList.add(new Veggies(TableBuilder.allGoods.size(), "Cucumbers",
                120, "Crispy-Crunchy", 10.70, "05/07/2017",
                20,2, "Green"));
        TableBuilder.allGoods.add(TableBuilder.veggiesList.get(0));
    }

    private void getSmartphone(){
        TableBuilder.smartphonesList = FXCollections.observableArrayList();
        TableBuilder.smartphonesList.add(new Smartphone(TableBuilder.allGoods.size(), "iPhone",
                200,"Best phone for taking selfies", 2500, 2,
                "DDR4", 2,1400,3,"MacOS", "5,2",
                40));
        TableBuilder.allGoods.add(TableBuilder.smartphonesList.get(0));
    }

    private void getPC(){
        TableBuilder.pcList = FXCollections.observableArrayList();
        TableBuilder.pcList.add(new PC(TableBuilder.allGoods.size(), "Apple MacBook",
                100,"Best notebook for surfing the net", 1500, 8,
                "DDR3", 2,2.2,4,"Intel HD Graphics 4000", 2,
                2,650, "DDR2"));
        TableBuilder.allGoods.add(TableBuilder.pcList.get(0));
    }

    private void getClothes(){
        TableBuilder.clothesList = FXCollections.observableArrayList();
        TableBuilder.clothesList.add(new Clothes(TableBuilder.allGoods.size(), "Super Shirt", 500,
                "Super shirt for summer", 1000,"D&G",
                1980,2000, 60));
        TableBuilder.allGoods.add(TableBuilder.clothesList.get(0));
    }
}
