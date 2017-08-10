package storehouse;

abstract public class Goods {
    public int id;
    public String name;
    public int quantity;
    public String description;
    public double price;

    public Goods() {
        id = 0;
        name = "";
        quantity = 0;
        description = "";
        price = 0;
    }

    public Goods(int id, String name, int quantity, String description, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
