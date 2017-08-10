package storehouse;

abstract public class Foodstuff extends Goods {
    public String productionDate;
    public double temperature;
    public int shelfLife;

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Foodstuff(int id, String name, int quantity, String description, double price,
                     String productionDate, double temperature, int shelfLife) {
        super(id, name, quantity, description, price);
        this.productionDate = productionDate;
        this.temperature = temperature;
        this.shelfLife = shelfLife;
    }


}
