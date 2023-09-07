package ru.netology;

import java.util.ArrayList;
import java.util.List;

//SOLID_4 Interface segregation principle
//Разделение интерфейса по принципу работы с товаром внутри контейнера
//Для склада, например такой вид действия как расчет стоимости не предусматривается, предусматривается пока только заполнение\возврат товара
public class Cart implements Shopper, Calculatable {
    private static String receiptList;
    private Store store;
    List<Goods> listProduct;

    public Cart(Store store) {
        if (store == null)
            throw new NullPointerException("store is not set. store is null");

        listProduct = new ArrayList<>();
    }

    public void check() {
        receiptList = listProduct.toString();
    }

    public static String getReceiptList() {
        if (receiptList == null || receiptList == "")
            throw new IllegalStateException("Чек не сформирован, необходимо запустить формироение чека");

        return receiptList;
    }

    @Override
    public boolean returnGoods(Goods goods) {
        store.returnGoods(goods);
        return false;
    }

    @Override
    public boolean put(Goods goods) {
        store.buyGoods(goods);
        return false;
    }

    @Override
    public double calculate() {
        Double total = 0.00;

        for (Goods goods : listProduct) {
            total = +goods.price;
        }
        return total;
    }
}
