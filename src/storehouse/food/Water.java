package storehouse.food;

import storehouse.Goods;

public class Water extends Goods{

    public Water(){};

    public Water(int id, String name, int quantity, String description, double price) {
        super(id, name, quantity, description, price);
    }

}
