package storehouse.food;

import storehouse.Foodstuff;

public class Sweets extends Foodstuff {
    public Sweets(int id, String name, int quantity, String description, double price,
                  String productionDate, double temperature, int shelfLife) {
        super(id, name, quantity, description, price, productionDate,
                temperature, shelfLife);
    }
}
