package ru.netology;

public class GoodsByWeight extends Goods {
    protected Double weight;
    protected Double priceOfAllWeight;

    public GoodsByWeight(String name, Double price, String manufacture, Double weight) {
        super(name, price, manufacture);

        if (weight <= 0) {
            throw new IllegalArgumentException("Все товара должен быть больше 0");
        }

        this.weight = weight;
        this.priceOfAllWeight = calcTotalPrice(price, weight); //DRY
    }

    public Double getWeight() {
        return weight;
    }

    public void correctWeight(Double newValue) {
        this.weight = newValue;
        this.priceOfAllWeight = calcTotalPrice(super.price, newValue);
    }

    private Double calcTotalPrice(Double price, Double weight){
        return weight * price;
    }
}
