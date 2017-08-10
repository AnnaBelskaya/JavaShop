package storehouse.food;

import storehouse.Foodstuff;

public class FizzyDrinks extends Foodstuff {
    public FizzyDrinks(int id, String name, int quantity, String description,
                       double price, String productionDate, double temperature, int shelfLife) {
        super(id, name, quantity, description, price, productionDate,
                temperature, shelfLife);
    }
}
