package ru.netology;

public class Goods {
    protected String name;
    protected Double price;
    protected String manufacturer;
    public Goods(String name, Double price, String manufacturer) {

        if (name == null) {
            throw new NullPointerException("Имя товара не может быть null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Товар не может быть без имени");
        }

        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
