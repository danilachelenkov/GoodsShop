package ru.netology;

public class Goods {
    protected String name;
    protected Double price;
    protected String manufacturer;

    protected GoodsType type;

    public Goods(String name, Double price, String manufacturer, GoodsType type) {

        if (name == null) {
            throw new NullPointerException("Имя товара не может быть null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Товар не может быть без имени");
        }

        if (type == null)
            this.type = GoodsType.UNKNOWN;

        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.type = type;
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

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;

        Goods gds = (Goods) obj;

        if (this.manufacturer == gds.manufacturer
                && this.name == gds.name
                && (this.price - gds.price) < 0.01) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\nПроизводитель: " + manufacturer +
                "\nТовар: " + name +
                "\nЦена: " + price;
    }

    public enum GoodsType {
        MEAT,
        BAKERY,
        DAIRY,
        SWEETS,
        UNKNOWN
    }

}
