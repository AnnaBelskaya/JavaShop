package storehouse.clothes;

import storehouse.Goods;

public class Clothes extends Goods {
    public String brandname;
    public int year;
    public int workers;
    public int countries;

    public Clothes(int id, String name, int quantity, String description,
                   double price, String brandname, int year, int workers,
                   int countries) {
        super(id, name, quantity, description, price);
        this.brandname = brandname;
        this.year = year;
        this.workers = workers;
        this.countries = countries;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getCountries() {
        return countries;
    }

    public void setCountries(int countries) {
        this.countries = countries;
    }
}
