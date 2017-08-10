package storehouse.hardware;

import storehouse.Goods;
import storehouse.Hardware;

public class Smartphone extends Hardware {
    public String os;
    public String screenSize;
    public int batteryLife;

    public Smartphone(int id, String name, int quantity, String description,
                      double price, float memory, String ddr, int kernels,
                      int frequency, int warranty, String os, String screenSize,
                      int batteryLife) {
        super(id, name, quantity, description, price, memory, ddr,
                kernels, frequency, warranty);
        this.os = os;
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }
}
