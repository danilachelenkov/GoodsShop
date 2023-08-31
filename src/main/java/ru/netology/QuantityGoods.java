package ru.netology;

public class QuantityGoods {
    private Goods goods;
    private long count;

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
}
