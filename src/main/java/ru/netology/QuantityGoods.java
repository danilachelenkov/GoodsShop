package ru.netology;

public class QuantityGoods {
    private Goods goods;
    private long count;

    public QuantityGoods(Goods goods) {
        if (goods == null) {
            throw new IllegalArgumentException("Объект товара не может быть пустым");
        }
        this.goods = goods;
        this.count = 0;
    }

    public QuantityGoods(Goods goods, long count) {
        if (goods == null) {
            throw new IllegalArgumentException("Объект товара не может быть пустым");
        }
        this.goods = goods;
        this.count = count;
    }

    public Goods getGoods() {
        return goods;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;

        QuantityGoods qGds = (QuantityGoods) obj;

        if (this.goods.manufacturer == qGds.getGoods().manufacturer
                && this.goods.name == qGds.getGoods().name
                && (this.goods.price - qGds.getGoods().price) < 0.01) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return String.join("", goods.name, goods.manufacturer, goods.price.toString()).hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s \nшт. %s", this.goods.toString(), this.count);
    }
}
