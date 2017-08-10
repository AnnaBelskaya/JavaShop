package storehouse.food;

import storehouse.Foodstuff;

public class Veggies extends Foodstuff {

    public String sort;

    public Veggies(int id, String name, int quantity, String description,
                   double price, String productionDate, double temperature,
                   int shelfLife, String sort) {
        super(id, name, quantity, description, price, productionDate,
                temperature, shelfLife);
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

}
