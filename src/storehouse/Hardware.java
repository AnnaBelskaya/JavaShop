package storehouse;

abstract public class Hardware extends Goods{
    public float memory;
    public String ddr;
    public int kernels;
    public double frequency;
    public int warranty;

    public float getMemory() {
        return memory;
    }

    public void setMemory(float memory) {
        this.memory = memory;
    }

    public String getDdr() {
        return ddr;
    }

    public void setDdr(String ddr) {
        this.ddr = ddr;
    }

    public int getKernels() {
        return kernels;
    }

    public void setKernels(int kernels) {
        this.kernels = kernels;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public Hardware(int id, String name, int quantity, String description,
                    double price, float memory, String ddr, int kernels,
                    double frequency, int warranty) {
        super(id, name, quantity, description, price);
        this.memory = memory;
        this.ddr = ddr;
        this.kernels = kernels;
        this.frequency = frequency;
        this.warranty = warranty;
    }
}
