package ru.netology;

public class GoodsByWeight extends Goods {
    protected Double weight;
    protected Double priceOfAllWeight;

    // Класс описывающий продукт у которого характеристика количества не штучное исчесление,
    // а физический вес. SOLID_2 (Open-closed principle)
    //Унаследован от Goods и расширяет его

    public GoodsByWeight(String name, Double price, String manufacture, Double weight, GoodsType type) {
        super(name, price, manufacture, type);

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

    private Double calcTotalPrice(Double price, Double weight) {
        return weight * price;
    }
}
