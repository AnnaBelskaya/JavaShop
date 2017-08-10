package storehouse.hardware;

import storehouse.Hardware;

public class PC extends Hardware {
    public String graphicCard;
    public int kernelsGC;
    public int frequencyGC;
    public float memoryGC;
    public String ddrGC;

    public PC(int id, String name, int quantity, String description,
              double price, float memory, String ddr, int kernels,
              double frequency, int warranty, String graphicCard, int kernelsGC,
              int frequencyGC, float memoryGC, String ddrGC) {
        super(id, name, quantity, description, price, memory, ddr,
                kernels, frequency, warranty);
        this.graphicCard = graphicCard;
        this.kernelsGC = kernelsGC;
        this.frequencyGC = frequencyGC;
        this.memoryGC = memoryGC;
        this.ddrGC = ddrGC;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public int getKernelsGC() {
        return kernelsGC;
    }

    public void setKernelsGC(int kernelsGC) {
        this.kernelsGC = kernelsGC;
    }

    public int getFrequencyGC() {
        return frequencyGC;
    }

    public void setFrequencyGC(int frequencyGC) {
        this.frequencyGC = frequencyGC;
    }

    public float getMemoryGC() {
        return memoryGC;
    }

    public void setMemoryGC(float memoryGC) {
        this.memoryGC = memoryGC;
    }

    public String getDdrGC() {
        return ddrGC;
    }

    public void setDdrGC(String ddrGC) {
        this.ddrGC = ddrGC;
    }
}